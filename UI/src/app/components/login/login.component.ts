import { Component, OnInit } from '@angular/core';
import { User } from '../../models/user.model';
import { AuthService } from '../../services/auth.service';
import {Router } from '@angular/router';
import { CoolLocalStorage} from 'angular2-cool-storage';

@Component({
	selector: 'person',
	templateUrl: './login.component.html',
	providers:[AuthService]
})
export class LoginComponent {

	user = new User;
	isValidUser : Boolean;
    user1 : User;
    localStorage:CoolLocalStorage;
	constructor(
		private _service:AuthService, private router:Router, coollocalStorage : CoolLocalStorage) {
		 this.localStorage=coollocalStorage;
	}

	login() {
		 this._service.login(this.user).subscribe(resp =>{this.user1 = resp,this.navigate(this.user1)});

	}

	navigate(user : User){
		if(user){
			this.router.navigate(['myinfo']);
			this.localStorage.setObject('loggedInUser',user);
		}else{
			
			this.router.navigate(['login']);
		}
	}
}

