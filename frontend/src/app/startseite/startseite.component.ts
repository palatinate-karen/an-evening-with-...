import {Component, OnInit} from '@angular/core';
import {Router} from "@angular/router";

@Component({
  selector: 'app-startseite',
  templateUrl: './startseite.component.html',
  styleUrls: ['./startseite.component.css']
})
export class StartseiteComponent implements OnInit {

  name: string = '';

  constructor(private router: Router) { }

  ngOnInit(): void {
  }

  onStartGame(celebrity: string) : void {
    // save name in browser
    localStorage.setItem('name', this.name);

    // redirect to Spielseite
    this.router.navigateByUrl('play/' + celebrity);
  }

}
