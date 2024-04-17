import { ThisReceiver } from '@angular/compiler';
import { Injectable, OnInit, TemplateRef, ViewChild } from '@angular/core';
import {
  AbstractControl,
  FormControl,
  FormGroup,
  ValidationErrors,
  Validators,
} from '@angular/forms';
import { ModalDismissReasons, NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { Validators as ValidatorsEditor } from 'ngx-editor';
import { NgxMasonryComponent } from 'ngx-masonry';
import { Color } from 'src/app/shared/models/color';
import { Note } from 'src/app/shared/models/note';
import { ColorService } from 'src/app/shared/services/color.service';
import { NoteService } from 'src/app/shared/services/note.service';
import { CardViewerComponent } from '../components/card-viewer/card-viewer.component';
import { CardViewerActivityStates } from '../models/card-viewer-activity-states';
import { Style } from 'src/app/shared/models/style';
import { Priority } from 'src/app/shared/models/priority';
import { PriorityService } from 'src/app/shared/services/priority.service';
import { StyleService } from 'src/app/shared/services/style.service';
import { BookService } from 'src/app/shared/services/book.service';
import { Book } from 'src/app/shared/models/book';

@Injectable({
  providedIn: 'root',
})
export class NotesPageService {
  private _cardEitorForm = new FormGroup({
    actionType: new FormControl<CardViewerActivityStates>(
      CardViewerActivityStates.SAVE
    ),
    id: new FormControl<number>(-1),
    author: new FormControl('', [ValidatorsEditor.required()]),
    header: new FormControl('',[ValidatorsEditor.required()]),
    colorValue: new FormControl(""),
    noteText: new FormControl(""),
    styleId: new FormControl(0),
    priorityId: new FormControl(0),
  });

  private _search = '';

  private _colors: Color[] = [];
  private _books: Book[] = [];
  private _styles: Style[] = [];
  private _priorites: Priority[] = [];

  public get colors(): Color[] {
    return this._colors;
  }

  public get books(): Book[] {
    return this._books;
  }

  public get styles(): Style[] {
    return this._styles;
  }

  public get priorites(): Priority[] {
    return this._priorites;
  }

  public get search(): string {
    return this._search;
  }
  public set search(value: string) {
    this._search = value.trim();
  }

  public get cardEitorForm() {
    return this._cardEitorForm;
  }

  public constructor(
    private colorService: ColorService,
    private priorityService: PriorityService,
    private styleService: StyleService,
    private bookService: BookService,
    private modalService: NgbModal
  ) {
    this.retrieveColors();
    this.retrieveStyles();
    this.retrievePriorities();
    this.retrieveBooks();
  }

  public retrieveColors(): void {
    this.colorService.getAll().subscribe({
      next: (data) => {
        this._colors = data;
      },
    });
  }

  public retrievePriorities(): void {
    this.priorityService.getAll().subscribe({
      next: (data) => {
        this._priorites = data;
      },
    });
  }

  public retrieveStyles(): void {
    this.styleService.getAll().subscribe({
      next: (data) => {
        this._styles = [...data];
        console.log(this.styles);

      },
    });
  }

  public retrieveBooks(): void {
    this.bookService.getAll().subscribe({
      next: (data) => {
        this._books = data;
        console.log(this._books);

      },
    });
  }

  public updateNotes(book:Book): void {
    this.bookService.update(book).subscribe({
      next: data=>{
        let oldNote = this.findBookById(data.id!)!;
        oldNote.color = data.color;
        oldNote.note = data.note;
        oldNote.header = data.header;
        oldNote.author= data.author;
        oldNote.priority= data.priority;
        oldNote.style = data.style;
    },
    error: err => {
        console.error("Can`t update note: " + err);

    }
  })
  }

  public add(book:Book): void {
    this.bookService.create(book).subscribe({
      next: data=>{
        this._books.push(data);
    },
    error: err => {
        console.error("Can`t add book: " + err);

    }
  })
  }

  public delete(id:number):void {
    this.bookService.delete(id).subscribe({
      next: data=>{
        this._books.splice(this.findBookIdById(id),1);
    },
    error: err => {
        console.error("Can`t delete book: " + err);

    }
  })
  }


  openNoteCardModal(id: number | null) {
    let book = this.getNewBook()

    if (id !== null) book = this.findBookById(id)!;

    this.fillBookForm(book);
    this._cardEitorForm.patchValue({
      actionType: book.id != -1
        ? CardViewerActivityStates.EDIT
        : CardViewerActivityStates.SAVE,
    });

    this.modalService.open(CardViewerComponent).result.then(
      (result) => {
        console.log(this.formToBook());

        if (result == CardViewerActivityStates.SAVE)
          this.add(this.formToBook());
        else if (result == CardViewerActivityStates.EDIT)
          this.updateNotes(this.formToBook());
      },
      (reason) => {}
    );
  }

  formToBook():Book {
    let b = this.getNewBook();
    if (this._cardEitorForm.value.id != -1)
      b = this.findBookById(this._cardEitorForm.value.id!)!;

    b.author = this._cardEitorForm.value.author!;
    b.note!.content = this._cardEitorForm.value.noteText!;
    b.header = this._cardEitorForm.value.header!;

    b.style = this.findStyleById(this._cardEitorForm.value.styleId!);
    b.color = this.findColorByValue(this._cardEitorForm.value.colorValue!);
    b.priority = this.findPrioritiById(this._cardEitorForm.value.priorityId!);


    return b;

  }


  private fillBookForm(book: Book | null): void {
    this._cardEitorForm.patchValue({
      id: book ? book.id : null,
      noteText: book?.note ? book?.note.content : "",

      header: book ? book.header : '',
      colorValue: book ? book.color?.value : this.colors?.at(0)!.value,
      author: book ? book.author:"",
      styleId: book ? book.style?.id : this.styles?.at(0)!.id,
      priorityId: book ? book.priority?.id : this.priorites?.at(0)!.id,
    });
  }

  private findBookIdById(id:number):number {
    return this._books.findIndex(val => val.id == id);
  }

  private findBookById(id:number):Book|undefined {
    return this._books.find(val => val.id == id);
  }

  private findStyleById(id:number):Style|undefined {
    return this._styles.find(val => val.id == id);
  }

  private findPrioritiById(id:number):Priority|undefined {
    return this._priorites.find(val => val.id == id);
  }

  private findColorByValue(str:string):Color|undefined {
    return this._colors.find(val => val.value == str);
  }

  getNewNote():Note {
    let n = new Note();
    n.id = -1;
    n.content = ""
    return n;
  }

  getNewBook():Book {
    let b = new Book();
    b.id = -1;
    b.author = "";
    b.color = this.colors[0];
    b.header = "";
    b.style = this._styles[0];
    b.note = this.getNewNote();
    b.priority = this._priorites[0];
    return b;
  }



}
