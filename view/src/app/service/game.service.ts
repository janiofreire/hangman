import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Dificulte } from '../shared/dificulte';
import { Game } from '../shared/game';
import { ResponseObject } from '../shared/responseObject';
import { environment } from 'src/environments/environment';
import { Hint } from '../shared/hint';

@Injectable({
  providedIn: 'root'
})
export class GameService {
  apiName = "game";
  constructor(private http: HttpClient) { }

  createGame(dificulte:Dificulte):Observable<ResponseObject<Game>>{
    return this.http.post<ResponseObject<Game>>(environment.URL_SERVER+'/'+this.apiName+'/createGame/'+dificulte,'');
  }

  sendHint(game:Game,letter:string):Observable<ResponseObject<Hint>>{
    return this.http.post<ResponseObject<Hint>>(environment.URL_SERVER+'/'+this.apiName+'/sendHint',
    {gameId:game.id,letter:letter});
  }
}
