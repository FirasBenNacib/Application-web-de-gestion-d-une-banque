import { ComponentFixture, TestBed } from '@angular/core/testing';

import { NumerocompteComponent } from './numerocompte.component';

describe('NumerocompteComponent', () => {
  let component: NumerocompteComponent;
  let fixture: ComponentFixture<NumerocompteComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ NumerocompteComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(NumerocompteComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
