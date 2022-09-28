import { Component, OnInit } from '@angular/core';
// tslint:disable-next-line:import-spacing
import { Title }     from '@angular/platform-browser';
import {Agence} from '../../model/agence';
import {AgenceService} from '../../agence.service';
import { HttpErrorResponse } from '@angular/common/http';
import { NgForm } from '@angular/forms';
import {ContentAgences} from '../../model/contentAgences';


@Component({
  selector: 'app-root',
  templateUrl: './agence.component.html',
  styleUrls: ['./agence.component.css']
})
export class AgenceComponent {
  public agences: Agence[];
  public editAgence: Agence;
  public deleteAgence: Agence;
  public constructor(private titleService: Title, private agenceService: AgenceService ) {
    this.agenceService = agenceService;
  }
  public setTitle( newTitle: string) {
    this.titleService.setTitle( newTitle );
  }

  // tslint:disable-next-line:use-lifecycle-interface typedef
  ngOnInit() {
    this.setTitle('BNA Bank');
    this.getAgences();
  }
  // tslint:disable-next-line:typedef
  register(registerForm: NgForm) {
    this.agenceService.registerAgence(registerForm.value).subscribe(
      (resp) => {
        console.log(resp);
        registerForm.reset();
        this.getAgences();
      },
      (err) => {
        console.log(err);
      }
    );
  }
  public getAgences(): void {
    this.agenceService.getAgences().subscribe(
      (response: ContentAgences) => {
        this.agences = response.content;
        console.log(this.agences);
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
  }
  public onAddAgence(addForm: NgForm): void {
    document.getElementById('add-agence-form').click();
    this.agenceService.addAgence(addForm.value).subscribe(
      (response: Agence) => {
        console.log(response);
        this.getAgences();
        addForm.reset();
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
        addForm.reset();
      }
    );
  }

  public onUpdateAgence(agence: Agence): void {
    this.agenceService.updateAgence(agence).subscribe(
      (response: Agence) => {
        console.log(response);
        this.getAgences();
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
  }

  public onDeleteAgence(agenceId: number): void {
    this.agenceService.deleteAgence(agenceId).subscribe(
      (response: void) => {
        console.log(response);
        this.getAgences();
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
  }

  public searchAgences(key: string): void {
    console.log(key);
    const results: Agence[] = [];
    for (const agence of this.agences) {
      if (agence.nom.toLowerCase().indexOf(key.toLowerCase()) !== -1
        || agence.description.toLowerCase().indexOf(key.toLowerCase()) !== -1) {
        results.push(agence);
      }
    }
    this.agences = results;
    if (results.length === 0 || !key) {
      this.getAgences();
    }
  }

  public onOpenModal(agence: Agence, mode: string): void {
    const container = document.getElementById('main-container');
    const button = document.createElement('button');
    button.type = 'button';
    button.style.display = 'none';
    button.setAttribute('data-toggle', 'modal');
    if (mode === 'add') {
      button.setAttribute('data-target', '#addAgenceModal');
    }
    if (mode === 'edit') {
      this.editAgence = agence;
      button.setAttribute('data-target', '#updateAgenceModal');
    }
    if (mode === 'delete') {
      this.deleteAgence = agence;
      button.setAttribute('data-target', '#deleteAgenceModal');
    }
    container.appendChild(button);
    button.click();
  }
}
