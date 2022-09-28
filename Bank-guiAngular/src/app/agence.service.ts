import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Agence } from './model/agence';
import { environment } from 'src/environments/environment';
import {ContentAgences} from './model/contentAgences';

@Injectable({providedIn: 'root'})
export class AgenceService {
  private apiServerUrl = environment.apiBaseUrl;

  constructor(private http: HttpClient) {
  }

  // tslint:disable-next-line:typedef
  public registerAgence(agenceData: any) {
    return this.http.post(`${this.apiServerUrl}/registeragences`, agenceData);
  }
  public getAgences(): Observable<ContentAgences> {
    return this.http.get<ContentAgences>(`${this.apiServerUrl}/agences`);
  }

  public addAgence(agence: Agence): Observable<Agence> {
    return this.http.post<Agence>(`${this.apiServerUrl}/agences`, agence);
  }

  public updateAgence(agence: Agence): Observable<Agence> {
    return this.http.put<Agence>(`${this.apiServerUrl}/agences`, agence);
  }

  public deleteAgence(agenceId: number): Observable<void> {
    return this.http.delete<void>(`${this.apiServerUrl}/agences${agenceId}`);
  }

  public getAgenceById(agenceId: number): Observable<Agence> {
    return this.http.get<Agence>(`${this.apiServerUrl}/agences/` + agenceId + `/numerocomptes`);
  }
}
