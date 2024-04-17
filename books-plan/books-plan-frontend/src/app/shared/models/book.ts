import { Color } from './color';
import { Note } from './note';
import { Priority } from './priority';
import { Style } from './style';

export class Book {
  id?: number;

  header?: string;

  author?: string;

  note?: Note;

  style?: Style;

  priority?: Priority;

  color?: Color;
}
