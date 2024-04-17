import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { Priority } from '../models/priority';

const baseUrl = environment.baseServerUrl + environment.apiVersion + "/priorities";


@Injectable({
  providedIn: 'root'
})
export class PriorityService {

  constructor(private httpClient:HttpClient) {
   }

   public getAll():Observable<Priority[]> {
    return this.httpClient.get<Priority[]>(baseUrl);
  }
}
