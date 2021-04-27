import { Component, Input, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Game } from '../../shared/game';

@Component({
  selector: 'app-game-view',
  templateUrl: './game-view.component.html',
  styleUrls: ['./game-view.component.css']
})
export class GameViewComponent implements OnInit {

  @Input("game")
  game:Game;

  constructor(private router: Router ) { }
  
  ngOnInit() {
  }

  isOpenGame():boolean{
    return this.game.result===null;
  }

  openGame(){
    this.router.navigate(['/running',{game:JSON.stringify(this.game)}])
  }
}
