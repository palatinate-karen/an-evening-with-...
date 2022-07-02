import { NgModule } from '@angular/core';
import {RouterModule, Routes} from "@angular/router";
import {StartseiteComponent} from "./startseite/startseite.component";
import {SpielseiteComponent} from "./spielseite/spielseite.component";
import {HighscoreBoardComponent} from "./highscore-board/highscore-board.component";

const routes: Routes = [
  { path: '', redirectTo: '/start', pathMatch: 'full' },
  { path: 'start', component: StartseiteComponent },
  { path: 'play/kanye', component: SpielseiteComponent },
  { path: 'play/trump', component: SpielseiteComponent },
  { path: 'highscore', component: HighscoreBoardComponent },
]

@NgModule({
  declarations: [],
  imports: [
    RouterModule.forRoot(routes)
  ],
  exports: [ RouterModule ]
})
export class AppRoutingModule { }
