import { NgModule } from '@angular/core';
import { BrowserModule, Title } from '@angular/platform-browser';

import { NgModel, FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClient } from '@angular/common/http';
import { HttpClientModule } from '@angular/common/http';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HeaderComponent } from './components/header/header.component';
import { HomeComponent } from './components/home/home.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { ToastrModule } from 'ngx-toastr';
import { MatToolbarModule } from '@angular/material/toolbar';
import { MatIconModule } from '@angular/material/icon';
import { MatTabsModule } from '@angular/material/tabs';
import { BackgroundComponent } from './components/background/background.component';
import { FooterComponent } from './components/footer/footer.component';
import { MatMenuModule } from '@angular/material/menu';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { NavbarComponent } from './components/navbar/navbar.component';

import { BankLoginComponent } from './components/bank-login/bank-login.component';
import { AboutComponent } from './components/about/about.component';
import { ServiceComponent } from './components/service/service.component';
import { ContectComponent } from './components/contect/contect.component';
import { MatProgressBarModule } from '@angular/material/progress-bar';
import {LoginComponent} from './components/login/login.component';
import {AgenceService } from './agence.service';
import {AgenceComponent} from './components/agence/agence.component';
import { NumerocompteComponent } from './components/numerocompte/numerocompte/numerocompte.component';
import {NumerocompteService} from './numerocompte.service';
import { TransactionComponent } from './components/transaction/transaction/transaction.component';
import {TransactionService} from './transaction.service';




@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    HomeComponent,
    BackgroundComponent,
    FooterComponent,
    NavbarComponent,
    BankLoginComponent,
    AboutComponent,
    // NotifierModule,
    ServiceComponent,
    ContectComponent,
    LoginComponent,
    AgenceComponent,
    NumerocompteComponent,
    TransactionComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    ReactiveFormsModule,
    FormsModule,
    HttpClientModule,
    MatToolbarModule,
    MatIconModule,
    MatTabsModule,
    MatMenuModule,
    MatProgressBarModule,
    NgbModule,
    ToastrModule.forRoot()
  ],
  providers: [HttpClient, NgModel, Title, AgenceService, NumerocompteService, TransactionService],
  bootstrap: [AppComponent]
})
export class AppModule { }
