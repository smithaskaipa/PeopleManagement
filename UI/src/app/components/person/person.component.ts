import { Component, OnInit } from '@angular/core';
import { Person } from '../../models/person.model';
import { PersonService } from '../../services/person.service';
import {Response } from '@angular/http';

@Component({
	selector: 'person',
	templateUrl: './person.component.html',
	providers:[PersonService]
})
export class PersonComponent implements OnInit {

	persons : Person[];
	
	constructor(private personService : PersonService)	{}

	ngOnInit(){
		this.personService.getAllPersons().subscribe(response => {this.persons =  response,console.log(this.persons)});
		
	}




}
