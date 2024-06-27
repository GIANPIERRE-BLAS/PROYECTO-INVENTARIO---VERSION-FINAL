import { Injectable } from '@angular/core';
import { HttpClient, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class ServiceListarProductosService {
  private baseUrl = 'http://localhost:8096/api/productos'; // URL base de la API en Backend

  constructor(private http: HttpClient) {}

  listarProductos(): Observable<{ codProducto: string, desProducto: string, desCategoria: string }[]> {
    return this.http.get<any[]>(this.baseUrl).pipe(
      map((productos: any[]) => {
        return productos.map((producto: any) => {
          return {
            codProducto: producto.codProducto,
            desProducto: producto.desProducto,
            desCategoria: producto.categoria.desCategoria
          };
        });
      })
    );
  }

  descargarPdf(): Observable<HttpResponse<Blob>> {
    return this.http.get(`${this.baseUrl}/pdf`, {
      responseType: 'blob',
      observe: 'response'
    });
  }
}
