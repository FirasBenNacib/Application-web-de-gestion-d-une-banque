import { Component, OnInit } from '@angular/core';
// tslint:disable-next-line:import-spacing
import { Title }     from '@angular/platform-browser';


@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {


  public constructor(private titleService: Title, ) {

  }
  // tslint:disable-next-line:typedef
  public setTitle( newTitle: string) {
    this.titleService.setTitle( newTitle );
  }

  // tslint:disable-next-line:use-lifecycle-interface typedef
  ngOnInit() {
    this.setTitle('BNA Bank');
  }
}
