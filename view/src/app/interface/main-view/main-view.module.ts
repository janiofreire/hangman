import { CommonModule } from '@angular/common';
import { NgModule, } from '@angular/core';
import { GameViewModule } from '../game-view/game-view.module';
import { MainViewComponent } from './main-view.component';
import { FormsModule } from '@angular/forms'; 
import { ReactiveFormsModule } from '@angular/forms';
import { RouterModule } from '@angular/router';


@NgModule({
  declarations: [
  MainViewComponent
        
  ],
  imports: [
  
    CommonModule
    ,GameViewModule
    ,FormsModule
    ,ReactiveFormsModule
    ,RouterModule
  ],
  providers: []
  ,exports:[
      MainViewComponent
  ]
})
export class MainViewModule { }
