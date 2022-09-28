import { Component, NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { AppComponent } from './app.component';
import { HomeComponent } from './components/home/home.component';
import { ServiceComponent } from './components/service/service.component';
import { AboutComponent } from './components/about/about.component';
import { ContectComponent } from './components/contect/contect.component';
import { LoginComponent } from './components/login/login.component';
import {BankLoginComponent} from './components/bank-login/bank-login.component';
import {AgenceComponent} from './components/agence/agence.component';
import {NumerocompteComponent} from './components/numerocompte/numerocompte/numerocompte.component';
import {TransactionComponent} from './components/transaction/transaction/transaction.component';


const routes: Routes = [
  // { path: '**', component: PageNotFoundComponent },
  // ,
  {
    path: '',
    component: HomeComponent,
    pathMatch: 'full'
  }
  ,
  {
    path: 'Home',
    component: HomeComponent,
    pathMatch: 'full'
  }
  ,
  {
    path: 'services',
    component: ServiceComponent,
    pathMatch: 'full'
  }
  ,
  {
    path: 'about',
    component: AboutComponent,
    pathMatch: 'full'
  }
  ,
  {
    path: 'contact',
    component: ContectComponent,
    pathMatch: 'full'
  },
  {
    path: 'adminlogin',
    component: BankLoginComponent,
    pathMatch: 'full'
  },
  {
    path: 'customerlogin',
    component: LoginComponent,
    pathMatch: 'full'
  },
  {
    path: 'agences',
    component: AgenceComponent,
    pathMatch: 'full'
  },
  {
    path: 'agences/:agenceId/:numerocomptes',
    component: NumerocompteComponent,
    pathMatch: 'full'
  },
  {
    path: 'numerocomptes/:numerocompteId/:transactions',
    component: TransactionComponent,
    pathMatch: 'full'
  }


];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {

}
