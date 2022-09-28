import { Injectable } from '@angular/core';
import {environment} from '../environments/environment';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {ContentAgences} from './model/contentAgences';
import {Agence} from './model/agence';
import {ContentTransactions} from './model/contenentTransactions';
import {Transaction} from './model/transaction';

@Injectable({
  providedIn: 'root'
})
export class TransactionService {
  private apiServerUrl = environment.apiBaseUrl;

  constructor(private http: HttpClient) {
  }

  // tslint:disable-next-line:typedef
  public registerTransaction(transactionData: any) {
    return this.http.post(`${this.apiServerUrl}/registertransactions`, transactionData);
  }
  public getTransactions(numerocompteId: number): Observable<ContentTransactions> {
    return this.http.get<ContentTransactions>(`${this.apiServerUrl}/numerocomptes/` + numerocompteId + `/transactions`);
  }

  public addTransaction(transaction: Transaction, numerocompteId: number): Observable<Transaction> {
    return this.http.post<Transaction>(`${this.apiServerUrl}/numerocomptes/` + numerocompteId + `/transactions`, transaction);
  }

  public updateTransaction(transaction: Transaction, numerocompteId: number, transactionId: number ): Observable<Transaction> {
    return this.http.put<Transaction>(`${this.apiServerUrl}/numerocomptes/` + numerocompteId + `/transactions` +
      transactionId , transaction);
  }

  public deleteTransaction(numerocompteId: number, transactionId: number): Observable<void> {
    return this.http.delete<void>(`${this.apiServerUrl}/numerocomptes/` + numerocompteId + `/transactions` + transactionId);
  }

  public getTransactionById(transactionId: number): Observable<Transaction> {
    return this.http.get<Transaction>(`${this.apiServerUrl}/transactions` + transactionId );
  }
}
