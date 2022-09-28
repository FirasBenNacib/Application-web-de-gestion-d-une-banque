import { TestBed } from '@angular/core/testing';

import { NumerocompteService } from './numerocompte.service';

describe('NumerocompteService', () => {
  let service: NumerocompteService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(NumerocompteService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
