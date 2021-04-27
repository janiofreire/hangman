import { CommonModule } from '@angular/common';
import { NgModule, } from '@angular/core';
import { FormsModule } from '@angular/forms'; 
import { ReactiveFormsModule } from '@angular/forms';
import { GameRunningComponent } from './game-running.component';


@NgModule({
  declarations: [
    GameRunningComponent
        
  ],
  imports: [
  
    CommonModule
     ,FormsModule
    ,ReactiveFormsModule
    
  ],
  providers: []
  ,exports:[
    GameRunningComponent
  ]
})
export class GameRunningModule { }
