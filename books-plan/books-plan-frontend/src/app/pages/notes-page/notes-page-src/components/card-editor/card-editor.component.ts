import { Component } from '@angular/core';
import { FormGroup } from '@angular/forms';
import { Editor, Toolbar  } from 'ngx-editor';
import { NotesPageService } from '../../services/notes-page.service';

@Component({
  selector: 'app-card-editor',
  templateUrl: './card-editor.component.html',
  styleUrls: ['./card-editor.component.scss']
})
export class CardEditorComponent {

  contentForm!:FormGroup;

  constructor(public notesPageService:NotesPageService) {
    this.contentForm = notesPageService.cardEitorForm;
  }

  ngOnInit(): void {
  }


}
