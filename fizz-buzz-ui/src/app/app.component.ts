import { Component } from '@angular/core';
import { FizzbuzzRequest } from './model/fizzbuzzrequest.model';
import { Fizzbuzz } from './model/fizzbuzz.model';
import { PlayService } from './play.service';


@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
  providers: [PlayService]
})
export class AppComponent {

  constructor(
    private playService: PlayService) {
  }

  title = 'FizzBuzz';

  public model: any = {};

  private fizzbuzzGameList: any[];
  private fizzbuzzResponse;

  numbersFormated: any[];
  results = "";
  error = "";

  fizzbuzz: Fizzbuzz[];

  public play(): void {

    this.results = "";
    this.error = "";

    let fizzbuzzList: Fizzbuzz[] = [];

    this.numbersFormated = this.model.numbers.split(',');

    let valid = true;
    let errors = "";

    this.numbersFormated.forEach((number, index) => {
      if (isNaN(number)) {
        errors += (number + " is not valid! ");
        valid = false;
      } else {
        fizzbuzzList[index] = new Fizzbuzz(number);
      }
    });

    if (valid) {

      let fizzbuzzRequest = new FizzbuzzRequest(fizzbuzzList);

      this.playService.play(fizzbuzzRequest)
        .subscribe(
          (data) => {
            this.fizzbuzzResponse = data;
            this.fizzbuzzGameList = this.fizzbuzzResponse.fizzbuzzGameList;
            this.fizzbuzzGameList.forEach((fizzbuzzGame, index) => {
              this.results += fizzbuzzGame.result + " ";
            });
          }
        );
    } else {
      this.error = errors;
    }
  }
}
