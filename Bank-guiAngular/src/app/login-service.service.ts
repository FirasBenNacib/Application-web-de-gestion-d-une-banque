import { Injectable } from '@angular/core';
import {Observable} from 'rxjs';
import { map } from 'rxjs/operators';
import {HttpClient} from '@angular/common/http';
import {environment} from '../environments/environment';
interface AuthenticationRequest{
  username: string;
  password: string;
}
@Injectable({
  providedIn: 'root'
})
export class LoginServiceService {
  authenticationRequest: AuthenticationRequest = {username: '', password: ''};


  apiServerUrl = environment.apiBaseUrl;


  constructor(private http: HttpClient) {
  }
  public  login(username: string, password: string ): Observable<any>{
    this.authenticationRequest.username = username;
    this.authenticationRequest.password = password;
    console.log(this.authenticationRequest.username);
    return this.http.post<AuthenticationRequest>(this.apiServerUrl + `/login`, this.authenticationRequest).pipe(map((res: any) => {
      localStorage.setItem('token', res.jwt);

    }));
  }
}
