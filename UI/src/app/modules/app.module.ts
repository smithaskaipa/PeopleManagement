import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from '../app.component';

import { PersonComponent } from '../components/person/person.component';
import { routing }  from '../routes/app.routes';
import {HTTPAPIService } from  '../services/httpApi.service';
import { HttpModule } from '@angular/http';
import { FormsModule } from '@angular/forms';
import {ErrorService } from '../services/error.service';
import { LoginComponent } from '../components/login/login.component';
import { MyInfoComponent } from '../components/myinfo/myinfo.component';
import { CoolStorageModule} from 'angular2-cool-storage';



@NgModule({
  declarations: [
    AppComponent,
    PersonComponent,
    LoginComponent,
    MyInfoComponent
  ],
  imports: [
    BrowserModule,
    routing,
HttpModule,
FormsModule,
CoolStorageModule
  ],
  providers: [HTTPAPIService,ErrorService],
  bootstrap: [AppComponent]
})
export class AppModule { }
