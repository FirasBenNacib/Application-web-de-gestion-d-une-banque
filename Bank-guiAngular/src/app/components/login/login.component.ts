import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';
import {LoginServiceService} from '../../login-service.service';


@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})

export class LoginComponent implements OnInit {
  username:string="";
  password:string="";

  constructor(private loginService: LoginServiceService, private _router: Router) { }

  ngOnInit(): void {
  }

  onSubmit() {
    this.loginService.login(this.username, this.password).subscribe((result) => {

      console.log('login works');
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


