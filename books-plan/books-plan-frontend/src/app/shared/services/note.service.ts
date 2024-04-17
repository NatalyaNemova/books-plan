import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { Note } from '../models/note';

const baseUrl = environment.baseServerUrl + environment.apiVersion + "/notes";

@Injectable({
  providedIn: 'root'
})
export class NoteService {

  constructor(private httpClient:HttpClient) {}

  public update(note:Note):Observable<Note>  {
    return this.httpClient.put<Note>(baseUrl,note);
  }

  public create(note:Note):Observable<Note>  {
    return this.httpClient.post<Note>(baseUrl,note);
  }

  public delete(id: number):Observable<any>  {
    return this.httpClient.delete(baseUrl+ "/" + id);
  }
}
