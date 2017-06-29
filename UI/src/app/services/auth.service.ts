import {Injectable} from '@angular/core';
import {Router} from '@angular/router';
 import { HTTPAPIService } from './httpApi.service';
import {Observable} from 'rxjs/Rx';
 
@Injectable()
export class AuthService {
 
  constructor(
    private _router: Router,private httpApiService : HTTPAPIService){}
 
  login(user : any){
   return  this.httpApiService.callApiObservable("/users/login","POST",user,null);
  }

}