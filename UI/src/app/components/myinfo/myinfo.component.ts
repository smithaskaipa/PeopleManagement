import { Component, OnInit } from '@angular/core';
import { Person } from '../../models/person.model';
import { PersonService } from '../../services/person.service';
import { CoolLocalStorage} from 'angular2-cool-storage';
import { User } from '../../models/user.model';
@Component({
	selector: 'myinfo',
	templateUrl: './myinfo.component.html',
	providers:[PersonService]
})
export class MyInfoComponent implements OnInit {

    localStorage : CoolLocalStorage;
    user : any={};
    person : Person;
	constructor(private personService : PersonService, private coollocalStorage : CoolLocalStorage) {
		 this.localStorage=coollocalStorage;
	}

	ngOnInit(){
		 this.user = this.localStorage.getObject('loggedInUser');
		 this.person = this.user.person;
	}
}
