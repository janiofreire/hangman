import { Component, Input, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { GameService } from 'src/app/service/game.service';

import { Game } from 'src/app/shared/game';
import { Hint } from 'src/app/shared/hint';
import { ResponseObject } from 'src/app/shared/responseObject';

@Component({
  selector: 'app-game-running',
  templateUrl: './game-running.component.html',
  styleUrls: ['./game-running.component.css']
})
export class GameRunningComponent implements OnInit {
  @Input("game")
  game:Game;
  selectedLetter:string;
  letters:string[];

  constructor(private gameService:GameService,private router: Router,
    private route: ActivatedRoute ) { }

  ngOnInit() {
    //this.session.get("game");
    this.game = JSON.parse(this.route.snapshot.paramMap.get("game"));
    //this.game = this.session.get("game");
    //this.session.remove("game");
    this.createLetters();
    
  }

  createLetters(){
    let stringLetters ="QWERTYUIOPASDFGHJKLÇZXCVBNM";
    let letterArrays = [];
    
    for(var i=0;i<stringLetters.length;i++){
      letterArrays.push(stringLetters.charAt(i));
    }

    this.letters= letterArrays.sort();
  }

  getRemaninGuess():Number{
    return this.game.maxGuesses-(this.game.hints!==null?this.game.hints.length:0);
  }

  getSendedLetter():string{
     return this.game.hints?this.game.hints.map(h=>h.letter).join(","):'';
  }
  
  getVisibleWord():string{
    let visibleWordList = new Array(this.game.word.length).fill("_",0,this.game.word.length);
    //let visibleWordList = Array.prototype.fill("_",0,this.game.word.length);
    
    if(this.game.hints!==null){
      this.game.hints.forEach(ht=>{
          ht.hintResult.positions.forEach(num=>{
            visibleWordList[num.valueOf()]=ht.letter;
          })
        });
    }

      return visibleWordList.join(",");
  }

  sendHint(){
    this.gameService.sendHint(this.game,this.selectedLetter).subscribe(
      r=>{
        this.updateData(r);
      }
      ,error=>{
        alert("Fail to acess server.");
      }
    );
  }

  updateData(result:ResponseObject<Hint>){
    if(this.game.hints===null){
      this.game.hints = [];
    }
    let localHint = result.listObjects[0];
    this.game.hints.push(localHint);
    if(localHint.hintResult.result!=null){
      this.close();
    }
    
  }

  close(){
    this.router.navigate([".."]);
  }
}
