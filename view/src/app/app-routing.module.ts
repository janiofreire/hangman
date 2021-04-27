import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { GameRunningComponent } from './interface/game-running/game-running.component';
import { MainViewComponent } from './interface/main-view/main-view.component';
import { MainViewModule } from './interface/main-view/main-view.module';

const routes: Routes = [
  { path: '', component: MainViewComponent },
  { path: 'running', component: GameRunningComponent }
  
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
