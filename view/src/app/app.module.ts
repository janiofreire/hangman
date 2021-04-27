import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { MainViewModule } from './interface/main-view/main-view.module';
import { HttpClientModule } from '@angular/common/http';
import { GameRunningModule } from './interface/game-running/game-running.module';



@NgModule({
  declarations: [
    AppComponent,
            
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    MainViewModule
  ,HttpClientModule
  ,GameRunningModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
