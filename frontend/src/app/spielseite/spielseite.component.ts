import { Component, OnInit } from '@angular/core';
import {QuoteService} from "../quote.service";
import {ActivatedRoute, Router} from "@angular/router";
import {HighscoreService} from "../highscore.service";

@Component({
  selector: 'app-spielseite',
  templateUrl: './spielseite.component.html',
  styleUrls: ['./spielseite.component.css']
})
export class SpielseiteComponent implements OnInit {

  quote: string = '';
  private isQuoteReal: boolean = false;

  score: number;

  highscore: number = 0;
  highscorer: string = '';

  private celebrity: string = '';

  constructor(
    private highscoreService: HighscoreService,
    private quoteService: QuoteService,
    private activeRoute: ActivatedRoute,
    private router: Router)
  {
    this.score = 0;
    this.celebrity = activeRoute.snapshot.url.toString().split(",")[1];
  }

  ngOnInit(): void {
    this.getHighestScore();
    this.getQuote();
  }

  private getHighestScore(): void {
    this.highscoreService.getHighestScore()
      .subscribe(score => {
        this.highscore = score.count;
        this.highscorer = score.name;
      });
  }

  private getQuote(): void {
    this.quoteService.getQuote(this.celebrity)
      .subscribe(quote => {
        this.quote = quote.cite;
        this.isQuoteReal = quote.real;
      });
  }

  getAnswer(answer: boolean): void {
    if (answer === this.isQuoteReal) {
      ++this.score;
      this.getQuote();
    } else {
      sessionStorage.setItem('score', String(this.score));
      this.router.navigateByUrl('highscore');
    }
  }

}
