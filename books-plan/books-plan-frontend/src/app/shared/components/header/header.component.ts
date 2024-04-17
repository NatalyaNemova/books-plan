import { Component } from '@angular/core';
import {NotesPageService} from "../../../pages/notes-page/notes-page-src/services/notes-page.service";
import {SearchService} from "../../services/search.service";

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.scss']
})
export class HeaderComponent {

  constructor(public notesPageService:NotesPageService, public searchService:SearchService) {
  }

}
