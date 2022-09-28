import { Component, OnInit } from '@angular/core';
// tslint:disable-next-line:import-spacing
import { Title }     from '@angular/platform-browser';
// tslint:disable-next-line:import-spacing
import {NumerocompteService} from  '../../../numerocompte.service';
import { Numerocompte } from '../../../model/numerocompte';
import { HttpErrorResponse } from '@angular/common/http';
import { NgForm } from '@angular/forms';
import {ContentNumerocomptes} from '../../../model/contentNumerocomptes';
import {Agence} from '../../../model/agence';

@Component({
  selector: 'app-numerocompte',
  templateUrl: './numerocompte.component.html',
  styleUrls: ['./numerocompte.component.css']
})
export class NumerocompteComponent {
  public numerocomptes: Numerocompte[];
  public editNumerocompte: Numerocompte;
  public deleteNumerocompte: Numerocompte;
  public agenceId: Agence['id'];

  public constructor(private titleService: Title, private numerocompteService: NumerocompteService ) {
    this.numerocompteService = numerocompteService;
  }
  // tslint:disable-next-line:typedef
  public setTitle( newTitle: string) {
    this.titleService.setTitle( newTitle );
  }

  // tslint:disable-next-line:use-lifecycle-interface typedef
  ngOnInit(agenceId: number) {
    this.setTitle('BNA Bank');
    this.getNumerocomptes(this.agenceId);
  }
  public getNumerocomptes(agenceId: number): void {
    this.numerocompteService.getNumerocomptes(agenceId).subscribe(
      (response: ContentNumerocomptes) => {
        this.numerocomptes = response.content;
        console.log(this.numerocomptes);
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
  }
  public onAddNumerocompte(addForm: NgForm): void {
    document.getElementById('add-numerocompte-form').click();
    this.numerocompteService.addNumerocompte(addForm.value).subscribe(
      (response: Numerocompte) => {
        console.log(response);
        // this.getNumerocomptes(agenceId);
        addForm.reset();
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
        addForm.reset();
      }
    );
  }

  public onUpdateNumerocompte(numerocompte: Numerocompte): void {
    this.numerocompteService.updateNumerocompte(numerocompte).subscribe(
      (response: Numerocompte) => {
        console.log(response);
       // this.getNumerocomptes();
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
  }

  public onDeleteNumerocompte(numerocompteId: number): void {
    this.numerocompteService.deleteNumerocompte(numerocompteId).subscribe(
      (response: void) => {
        console.log(response);
      //  this.getNumerocomptes();
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
  }

  public searchNumerocomptes(key: string): void {
    console.log(key);
    const results: Numerocompte[] = [];
    for (const numerocompte of this.numerocomptes) {
      if (numerocompte.numero.toLowerCase().indexOf(key.toLowerCase()) !== -1) {
        results.push(numerocompte);
      }
    }
    this.numerocomptes = results;
    if (results.length === 0 || !key) {
   //   this.getNumerocomptes();
    }
  }

  public onOpenModal(numerocompte: Numerocompte, mode: string): void {
    const container = document.getElementById('main-container');
    const button = document.createElement('button');
    button.type = 'button';
    button.style.display = 'none';
    button.setAttribute('data-toggle', 'modal');
    if (mode === 'add') {
      button.setAttribute('data-target', '#addNumerocompteModal');
    }
    if (mode === 'edit') {
      this.editNumerocompte = numerocompte;
      button.setAttribute('data-target', '#updateNumerocompteModal');
    }
    if (mode === 'delete') {
      this.deleteNumerocompte = numerocompte;
      button.setAttribute('data-target', '#deleteNumerocompteModal');
    }
    container.appendChild(button);
    button.click();
  }
}
