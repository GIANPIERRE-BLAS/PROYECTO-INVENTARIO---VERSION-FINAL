import { TestBed } from '@angular/core/testing';

import { ServiceListarProveedoresService } from './service-listar-proveedores.service';

describe('ServiceListarProveedoresService', () => {
  let service: ServiceListarProveedoresService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ServiceListarProveedoresService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
