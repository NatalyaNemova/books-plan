import { Pipe, PipeTransform } from '@angular/core';
import { concat } from 'rxjs';
import { Book } from 'src/app/shared/models/book';

@Pipe({
  name: 'filterBooks',
})
export class FilterNotesPipe implements PipeTransform {
  transform(books: Book[], search: string): Book[] {
    search = search.trim().toLowerCase();

    if (search.trim() === '') {
      return books;
    }

    return books.filter((v) => this.foundSearch(v, search));
  }

  private foundSearch(book: Book, search: string): boolean {
    return ''
      .concat(
        book.author ? book.author.toLowerCase() : '',
        ' | ',
        book.header ? book.header.toLowerCase() : '',
        ' | ',
        book.priority?.desc? book.priority?.desc.toLowerCase() : '',
        ' | ',
        book.style?.name ? book.style.name.toLowerCase() : '',
      )
      .includes(search);
  }
}
