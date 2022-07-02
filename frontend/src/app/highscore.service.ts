import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {catchError, Observable, of} from "rxjs";
import {Score} from "./score";
import {ScoreImpl} from "./scoreImpl";

@Injectable({
  providedIn: 'root'
})
export class HighscoreService {

  private serverUrl = 'http://localhost:8080'

  httpOptions = {
    headers: new HttpHeaders(
      { 'Content-Type': 'application/json', 'Connection': 'keep-alive' })
  };

  constructor(private http: HttpClient) { }

  getHighestScore(): Observable<Score> {
    return this.http.get<Score>(this.serverUrl + '/highestScore')
      .pipe(
        catchError(this.handleError<Score>('getHighestScore'))
      );
  }

  async saveNewHighscore(newScore: ScoreImpl): Promise<void> {
    await this.http.post<void>(this.serverUrl + '/saveScore', newScore, this.httpOptions)
      .pipe(
        catchError(this.handleError<void>('saveNewHighscore'))
      ).toPromise();
  }

  getTopFive(): Observable<Score[]> {
    return this.http.get<Score[]>(this.serverUrl + '/topFive')
      .pipe(
        catchError(this.handleError<Score[]>('getHighestScore'))
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
