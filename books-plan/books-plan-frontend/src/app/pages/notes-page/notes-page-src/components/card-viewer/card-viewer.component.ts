import { Component, Input, OnInit, TemplateRef } from '@angular/core';
import { FormGroup } from '@angular/forms';
import {
  ModalDismissReasons,
  NgbActiveModal,
  NgbModal,
} from '@ng-bootstrap/ng-bootstrap';
import { Color } from 'src/app/shared/models/color';
import { ColorService } from 'src/app/shared/services/color.service';
import { CardViewerActivityStates } from '../../models/card-viewer-activity-states';
import { NotesPageService } from '../../services/notes-page.service';

@Component({
  selector: 'app-card-viewer',
  templateUrl: './card-viewer.component.html',
  styleUrls: ['./card-viewer.component.scss'],
})
export class CardViewerComponent {
  constructor(
    public activeModal: NgbActiveModal,
    private colorService: ColorService,
    public notesPageService: NotesPageService
  ) {}


  public getActiveType(): CardViewerActivityStates {
    return this.notesPageService.cardEitorForm.controls['actionType'].value!;
  }

  public getActiveTypeButtonName(): string {
    let res: string;
    switch (this.getActiveType()) {
      case CardViewerActivityStates.EDIT:
        res = 'Изменить';
        break;

      case CardViewerActivityStates.SAVE:
        res = 'Сохранить';
        break;
      default:
        res = 'UNDEF';
    }
    return res;
  }
}
