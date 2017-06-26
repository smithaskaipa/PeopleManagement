import { Injectable } from '@angular/core';
import { HTTPAPIService } from './httpApi.service';
import {Observable} from 'rxjs/Rx';

@Injectable()
export class PersonService {

	constructor(private httpApiService : HTTPAPIService) { }

	getAllPersons(){

		return  this.httpApiService.callApiObservable("/persons","GET","",null);
	}

}
