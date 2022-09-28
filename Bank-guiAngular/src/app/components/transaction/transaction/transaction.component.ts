import { Component, OnInit } from '@angular/core';
import {Agence} from '../../../model/agence';
import {Title} from '@angular/platform-browser';
import {AgenceService} from '../../../agence.service';
import {NgForm} from '@angular/forms';
import {ContentAgences} from '../../../model/contentAgences';
import {HttpErrorResponse} from '@angular/common/http';
import {Transaction} from '../../../model/transaction';
import {TransactionService} from '../../../transaction.service';
import {ContentTransactions} from '../../../model/contenentTransactions';
import {Numerocompte} from '../../../model/numerocompte';

@Component({
  selector: 'app-transaction',
  templateUrl: './transaction.component.html',
  styleUrls: ['./transaction.component.css']
})
export class TransactionComponent {

  public transactions: Transaction[];
  public editTransaction: Transaction;
  public deleteTransaction: Transaction;
  public numerocompteId: Numerocompte['id'];
  public transactionId: Transaction['id'];
  public constructor(private titleService: Title, private transactionService: TransactionService ) {
    this.transactionService = transactionService;
  }
  public setTitle( newTitle: string) {
    this.titleService.setTitle( newTitle );
  }

  // tslint:disable-next-line:use-lifecycle-interface typedef
  ngOnInit() {
    this.setTitle('BNA Bank');
    this.getTransactions(this.numerocompteId);
  }
  // tslint:disable-next-line:typedef
  register(registerForm: NgForm) {
    this.transactionService.registerTransaction(registerForm.value).subscribe(
      (resp) => {
        console.log(resp);
        registerForm.reset();
        this.getTransactions(this.numerocompteId);
      },
      (err) => {
        console.log(err);
      }
    );
  }
  public getTransactions(numerocompteId: number): void {
    this.transactionService.getTransactions(this.numerocompteId).subscribe(
      (response: ContentTransactions) => {
        this.transactions = response.content;
        console.log(this.transactions);
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
  }
  public onAddTransaction(addForm: NgForm): void {
    document.getElementById('add-transaction-form').click();
    this.transactionService.addTransaction(addForm.value, this.numerocompteId).subscribe(
      (response: Transaction) => {
        console.log(response);
        this.getTransactions(this.numerocompteId);
        addForm.reset();
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
        addForm.reset();
      }
    );
  }

  public onUpdateTransaction(transaction: Transaction): void {
    this.transactionService.updateTransaction(transaction, this.numerocompteId, this.transactionId ).subscribe(
      (response: Transaction) => {
        console.log(response);
        this.getTransactions(this.numerocompteId);
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
  }

  public onDeleteTransaction(numerocompteId: number , transactionId: number): void {
    this.transactionService.deleteTransaction(this.numerocompteId, this.transactionId).subscribe(
      (response: void) => {
        console.log(response);
        this.getTransactions(this.transactionId);
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
  }

  public searchTransactions(key: string): void {
    console.log(key);
    const results: Transaction[] = [];
    for (const transaction of this.transactions) {
      if (transaction.libelle.toLowerCase().indexOf(key.toLowerCase()) !== -1
        || transaction.montant !== -1
        || (transaction.date_operation.toLowerCase().indexOf(key.toLowerCase()) !== -1))
      {
        results.push(transaction);
      }
    }
    this.transactions = results;
    if (results.length === 0 || !key) {
      this.getTransactions(this.transactionId);
    }
  }

  public onOpenModal(transaction: Transaction, mode: string): void {
    const container = document.getElementById('main-container');
    const button = document.createElement('button');
    button.type = 'button';
    button.style.display = 'none';
    button.setAttribute('data-toggle', 'modal');
    if (mode === 'add') {
      button.setAttribute('data-target', '#addTransactionModal');
    }
    if (mode === 'edit') {
      this.editTransaction = transaction;
      button.setAttribute('data-target', '#updateTransactionModal');
    }
    if (mode === 'delete') {
      this.deleteTransaction = transaction;
      button.setAttribute('data-target', '#deleteTransactionModal');
    }
    container.appendChild(button);
    button.click();
  }
}
