import { TestBed, async } from '@angular/core/testing';
import { AgenceComponent } from './agence.component';

describe('AgenceComponent', () => {
  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [
        AgenceComponent
      ],
    }).compileComponents();
  }));

  it('should create the app', () => {
    const fixture = TestBed.createComponent(AgenceComponent);
    const app = fixture.componentInstance;
    expect(app).toBeTruthy();
  });

  it(`should have as title 'agencemanagerapp'`, () => {
    const fixture = TestBed.createComponent(AgenceComponent);
    const app = fixture.componentInstance;
    expect(app.title).toEqual('agencemanagerapp');
  });

  it('should render title', () => {
    const fixture = TestBed.createComponent(AgenceComponent);
    fixture.detectChanges();
    const compiled = fixture.nativeElement;
    expect(compiled.querySelector('.content span').textContent).toContain('agencemanagerapp app is running!');
  });
});
