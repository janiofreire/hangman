import { CommonModule } from '@angular/common';
import { NgModule} from '@angular/core';
import { GameViewComponent } from '../game-view/game-view.component';


@NgModule({
  declarations: [
    GameViewComponent
        
  ],
  imports: [
  
    CommonModule
    
  ],
  providers: []
  ,exports:[
    GameViewComponent
  ]
})
export class GameViewModule { }
