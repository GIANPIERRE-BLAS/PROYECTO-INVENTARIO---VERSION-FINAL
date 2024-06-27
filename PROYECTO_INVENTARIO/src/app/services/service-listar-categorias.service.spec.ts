import { TestBed } from '@angular/core/testing';

import { ServiceListarCategoriasService } from './service-listar-categorias.service';

describe('ServiceListarCategoriasService', () => {
  let service: ServiceListarCategoriasService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ServiceListarCategoriasService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
