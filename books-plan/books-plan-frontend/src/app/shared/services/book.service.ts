import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { Book } from '../models/book';

const baseUrl = environment.baseServerUrl + environment.apiVersion + "/books";


@Injectable({
  providedIn: 'root'
})
export class BookService {
  constructor(private httpClient:HttpClient) {}

  public update(rec: Book):Observable<Book>  {
    return this.httpClient.put<Book>(baseUrl,rec);
  }

  public delete(id: number):Observable<any>  {
    return this.httpClient.delete(baseUrl+ "/" + id);
  }

  public getAll():Observable<Book[]> {
    return this.httpClient.get<Book[]>(baseUrl);
  }


  public create(book:Book):Observable<Book> {
    return this.httpClient.post<Book>(baseUrl,book);
  }
}
