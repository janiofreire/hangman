import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { GameService } from 'src/app/service/game.service';
import { Dificulte } from 'src/app/shared/dificulte';
import { MainPage } from 'src/app/shared/mainPage';
import { ResponseObject } from 'src/app/shared/responseObject';
import { MainPageService } from '../../service/main-page.service';
import { Game } from '../../shared/game';

@Component({
  selector: 'app-main-view',
  templateUrl: './main-view.component.html',
  styleUrls: ['./main-view.component.css']
})
export class MainViewComponent implements OnInit {

  private mainPage:MainPage= null;
  selectedDificulte:Dificulte=null;

  constructor(private mainPageService:MainPageService,private gameService:GameService,
    private route: ActivatedRoute,private router: Router ) {}

  ngOnInit() {
    this.mainPage = new MainPage();
    this.mainPageService.getInitData()
    .subscribe( (result) =>{
       this.fillDataResult(result);
       
    },
        erro =>{
          alert("Fail to acess server");
        });
  }

  fillDataResult(result:ResponseObject<MainPage>) {
    this.mainPage.listGames =  result.listObjects[0].listGames;
    this.mainPage.dificultes =  result.listObjects[0].dificultes;
  } 

  createNewGame(){
    this.gameService.createGame(this.selectedDificulte)
    .subscribe(r => {
      if(r.message==null){
        let localGame = r.listObjects[0];
        this.router.navigate(['/running',{game:JSON.stringify(localGame)}])
      }else{
        alert(r.message);
      }
    });
  }

  
}
