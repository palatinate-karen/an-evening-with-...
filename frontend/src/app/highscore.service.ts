import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {catchError, Observable, of} from "rxjs";
import {Score} from "./score";

@Injectable({
  providedIn: 'root'
})
export class HighscoreService {

  private serverUrl = 'http://localhost:8080'

  httpOptions = {
    headers: new HttpHeaders({ 'Content-Type': 'application/json' })
  };

  constructor(private http: HttpClient) { }

  getHighestScore(): Observable<Score> {
    return this.http.get<Score>(this.serverUrl + '/highestScore')
      .pipe(
        catchError(this.handleError<Score>('getHighestScore'))
      );
  }

  private handleError<T>(operation = 'operation', result?: T) {
    return (error: any): Observable<T> => {
      console.error(error);
      // Let the app keep running by returning an empty result.
      return of(result as T);
    };
  }
}
