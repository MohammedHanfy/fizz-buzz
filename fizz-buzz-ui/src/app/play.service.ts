import { Http, Headers, RequestOptions } from '@angular/http';
import { Injectable } from '@angular/core';
import { map } from 'rxjs/operators';
import { FizzbuzzResponse } from './model/fizzbuzzresponse.model';
import { Observable, Subject } from 'rxjs';


@Injectable()
export class PlayService {

  private options: RequestOptions;

  constructor(
    private http: Http) {
      let headers = new Headers();
      headers.append('Content-Type', 'application/json; charset=UTF-8');
      this.options = new RequestOptions({ headers });
    }

  public play(fizzbuzzRequest): Observable<FizzbuzzResponse> {
    let body = JSON.stringify(fizzbuzzRequest);

    return this.http.post("http://localhost:8585/fizzbuzz/play", body, this.options)
      .pipe(
        map((response: any) => response.json())
      );
  }
}
