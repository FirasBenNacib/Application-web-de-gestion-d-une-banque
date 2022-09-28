import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import {LoginServiceService} from '../../login-service.service';
import {Router} from '@angular/router';

@Component({
  selector: 'app-bank-login',
  templateUrl: './bank-login.component.html',
  styleUrls: ['./bank-login.component.css']
})
export class BankLoginComponent implements OnInit {
  username:string="";
  password:string="";

  constructor(private loginService: LoginServiceService, private _router: Router) { }

  ngOnInit(): void {
  }

  onSubmit() {
    this.loginService.login(this.username, this.password).subscribe((result) => {

      this._router.navigate(['/agences']);
    }, () => {
      console.log('login failed');
    });
  }

  reloadCurrentRoute() {
    const currentUrl = this._router.url;
    this._router.navigateByUrl('/', { skipLocationChange: true }).then(() => {
      this._router.navigate([currentUrl]);
    });
  }
}
