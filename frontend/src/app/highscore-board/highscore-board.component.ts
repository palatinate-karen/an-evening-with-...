import {Component, OnInit} from '@angular/core';
import {Score} from "../score";
import {HighscoreService} from "../highscore.service";
import {ActivatedRoute, Router} from "@angular/router";
import {ScoreImpl} from "../scoreImpl";

@Component({
  selector: 'app-highscore-board',
  templateUrl: './highscore-board.component.html',
  styleUrls: ['./highscore-board.component.css']
})
export class HighscoreBoardComponent implements OnInit {

  score: string | null;
  highscorers: Score[] = [];

  constructor(
    private highscoreService: HighscoreService,
    private activeRoute: ActivatedRoute,
    private router: Router
  ) {
    this.score = sessionStorage.getItem('score');
  }

  ngOnInit(): void {
    this.saveHighscore();
  }

  restartGame(){
    sessionStorage.clear()
    this.router.navigateByUrl('start');
  }

  restartRun() {
    sessionStorage.setItem('score', '');
    let celebrity: string = sessionStorage.getItem('celebrity') || 'kanye';
    this.router.navigateByUrl('play/' + celebrity);
  }
}
