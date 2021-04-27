import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { MainPage } from '../shared/mainPage';
import { Observable } from 'rxjs/internal/Observable';
import { ResponseObject } from '../shared/responseObject';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class MainPageService {

  constructor(private http: HttpClient) { }

  getInitData():Observable<ResponseObject<MainPage>>{
    
    return this.http.get<ResponseObject<MainPage>>(environment.URL_SERVER+'/mainPage/');
  }
}
