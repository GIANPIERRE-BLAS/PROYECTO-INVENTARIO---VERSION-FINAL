import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class PdfService {

  private proveedoresUrl = 'http://localhost:8096/api/proveedores'; // URL para proveedores
  private productosUrl = 'http://localhost:8096/api/productos'; // URL para productos

  constructor(private http: HttpClient) { }

  downloadPdfProveedores(): Observable<HttpResponse<Blob>> {
    return this.http.get(`${this.proveedoresUrl}/pdf`, {
      responseType: 'blob',
      observe: 'response'
    });
  }

  downloadPdfProductos(): Observable<HttpResponse<Blob>> {
    return this.http.get(`${this.productosUrl}/pdf`, {
      responseType: 'blob',
      observe: 'response'
    });
  }
}
