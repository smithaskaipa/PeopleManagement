import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from '../app.component';

import { PersonComponent } from '../components/person/person.component';
import { routing }  from '../routes/app.routes';
import {HTTPAPIService } from  '../services/httpApi.service';
import { HttpModule } from '@angular/http';
import {ErrorService } from '../services/error.service';

@NgModule({
  declarations: [
    AppComponent,
    PersonComponent
  ],
  imports: [
    BrowserModule,
    routing,
HttpModule
  ],
  providers: [HTTPAPIService,ErrorService],
  bootstrap: [AppComponent]
})
export class AppModule { }
