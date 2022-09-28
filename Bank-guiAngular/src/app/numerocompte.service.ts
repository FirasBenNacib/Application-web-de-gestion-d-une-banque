import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Numerocompte } from './model/numerocompte';
import { environment } from 'src/environments/environment';
import {ContentNumerocomptes} from './model/contentNumerocomptes';
import {ContentAgences} from './model/contentAgences';
import {Agence} from './model/agence';



@Injectable({
  providedIn: 'root'
})
export class NumerocompteService {
  private apiServerUrl = environment.apiBaseUrl;
  constructor(private http: HttpClient) {}
  public getNumerocomptes( agenceId: number): Observable<ContentNumerocomptes> {
    return this.http.get<ContentNumerocomptes>(`${this.apiServerUrl}/agences/` + agenceId + `/numerocomptes`);
  }

  public addNumerocompte(numerocompte: Numerocompte): Observable<Numerocompte> {
    return this.http.post<Numerocompte>(`${this.apiServerUrl}/agences/{agenceId}/numerocomptes`, numerocompte);
  }

  public updateNumerocompte(numerocompte: Numerocompte): Observable<Numerocompte> {
    return this.http.put<Numerocompte>(`${this.apiServerUrl}/agences/{agenceId}/numercomptes/{numercompteId`, numerocompte);
  }

  public deleteNumerocompte(numerocompteId: number): Observable<void> {
    return this.http.delete<void>(`${this.apiServerUrl}/{agenceId}/numerocomptes/{numerocompteId}`);
  }
}
