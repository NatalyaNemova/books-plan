import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { Style } from '../models/style';

const baseUrl = environment.baseServerUrl + environment.apiVersion + "/styles";


@Injectable({
  providedIn: 'root'
})
export class StyleService {

  constructor(private httpClient:HttpClient) {
   }

   public getAll():Observable<Style[]> {
    return this.httpClient.get<Style[]>(baseUrl);
  }
}
