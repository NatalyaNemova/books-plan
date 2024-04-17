import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from "@angular/common/http";

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HeaderComponent } from './shared/components/header/header.component';
import { NotesPageComponent } from './pages/notes-page/notes-page.component';
import { NoteCardComponent } from './pages/notes-page/notes-page-src/components/note-card/note-card.component';
import { NgxEditorModule } from 'ngx-editor';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { CardViewerComponent } from './pages/notes-page/notes-page-src/components/card-viewer/card-viewer.component';
import { ClickStopPropagationDirective } from './shared/directives/click-stop-propagation.directive';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { CardEditorComponent } from './pages/notes-page/notes-page-src/components/card-editor/card-editor.component';
import { NgxMasonryModule } from 'ngx-masonry';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { FilterNotesPipe } from './pages/notes-page/notes-page-src/pipes/filter-notes.pipe';
@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    NotesPageComponent,
    NoteCardComponent,
    CardViewerComponent,
    ClickStopPropagationDirective,
    CardEditorComponent,
    FilterNotesPipe,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    NgxEditorModule,
    NgbModule,
    FormsModule,
    ReactiveFormsModule,
    NgxMasonryModule,
    BrowserAnimationsModule,
    HttpClientModule,

  ],
  providers: [],
  bootstrap: [AppComponent],
  schemas: [

  ]
})
export class AppModule { }
