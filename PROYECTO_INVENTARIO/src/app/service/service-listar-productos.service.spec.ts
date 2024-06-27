import { TestBed } from '@angular/core/testing';

import { ServiceListarProductosService } from './service-listar-productos.service';

describe('ServiceListarProductosService', () => {
  let service: ServiceListarProductosService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ServiceListarProductosService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
