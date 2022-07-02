import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders, HttpParams} from "@angular/common/http";
import {catchError, Observable, of} from "rxjs";
import {Quote} from "./quote";

@Injectable({
  providedIn: 'root'
})
export class QuoteService {

  private quoteUrl = 'http://localhost:8080/cite'

  httpOptions = {
    headers: new HttpHeaders({ 'Content-Type': 'application/json' })
  };

  constructor(private http: HttpClient) { }

  getQuote(celebrity: string): Observable<Quote> {
    let params = new HttpParams().set('celebrity', celebrity);

    return this.http.get<Quote>(this.quoteUrl, { params: params })
      .pipe(
        catchError(this.handleError<Quote>('getQuote'))
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
