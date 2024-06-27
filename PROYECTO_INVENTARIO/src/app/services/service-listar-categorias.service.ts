import { Injectable, inject } from '@angular/core';
import { HttpClient, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ServiceListarCategoriasService {
  private http = inject(HttpClient);
  private baseUrl = 'http://localhost:8096/api/categorias'; // URL base de la API en Backend para categorías

  constructor() {}

  listarCategorias(): Observable<any> {
    return this.http.get(`${this.baseUrl}`);
  }
  descargarPdf(): Observable<HttpResponse<Blob>> {
    return this.http.get(`${this.baseUrl}/pdf`, {
      responseType: 'blob',
      observe: 'response'
    });
  }
}
