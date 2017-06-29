import { Injectable , EventEmitter} from '@angular/core';
import { Http , Response}   from '@angular/http';
import { Observable } from 	'rxjs/Observable' ;
import 'rxjs/Rx' ;
import {Headers} from '@angular/http';
import  { ErrorMessage } from './error.service';
import  { ErrorService } from './error.service';

@Injectable()
export class HTTPAPIService{
	//private globalUrl = "https://api.dev.obsessory.com/cmt";
	private globalUrl = "http://localhost:8080";

	constructor(private http : Http,private errorService:ErrorService){
	}



	private getHeaders(){
		let headers = new Headers();
		headers.append('Accept', 'application/json');
		headers.append('Content-Type' , 'application/json');    
		return headers;		
	}

	callApiObservable(relativeUrl : string, methodType : string ,methodData : any, headers : Headers, isJsonNotRequred?:boolean){
         let url = this.globalUrl+relativeUrl;
       
		if(headers==null){

			headers = this.getHeaders();
		}

		if(methodType==="GET"){
			if(isJsonNotRequred){
				return	this.http.get(url, {headers : headers}).catch(err => this.handleError(err));
			}
			return	this.http.get(url, {headers : headers}).map(res=> res.json()).catch(err => this.handleError(err));


		}else if (methodType==="POST"){
         
			if(isJsonNotRequred){
				return this.http.post(url , methodData , {
					headers : headers}).catch(err => this.handleError(err));
			}else{
				return this.http.post(url , methodData , {
					headers : headers}).map(res=>res.json()).catch(err => this.handleError(err));

			}
			
		}else if(methodType==="PUT"){
			return this.http.put(url , methodData , {
				headers : headers}).map(res=>res.json()).catch(err => this.handleError(err));

		}else{

		}
	}


	callApiPromise(relativeUrl : string, methodType : string ,methodData : any, headers : Headers){
		 let url = this.globalUrl+relativeUrl;

		if(methodType==="GET"){

			return this.http.get(url, {headers : headers}).toPromise().then(res=>res.json()).catch(err => this.handleError(err));

		}else if (methodType==="POST"){

			return this.http.post(url , methodData , {
				headers : headers}).toPromise().then(res=>res.json()).catch(err => this.handleError(err));

		}else if(methodType==="PUT"){

			return this.http.put(url , methodData , {
				headers : headers}).toPromise().then(res=>res.json()).catch(err => this.handleError(err));

		}else{

		}
	}




	handleError (error: Response | any) {

		this.errorService.setErrorMessage(error.json() as ErrorMessage);

		// In a real world app, you might use a remote logging infrastructure
		let errMsg: string;
		if (error instanceof Response) {
			const body = error.json() || '';
			const err = body.error || JSON.stringify(body);
			errMsg = `${error.status} - ${error.statusText || ''} ${err}`;
		} else {
			errMsg = error.message ? error.message : error.toString();
		}
		//console.error(errMsg);
		return Observable.throw(errMsg);
	}

}