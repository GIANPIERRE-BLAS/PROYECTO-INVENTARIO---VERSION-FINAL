import { Component, OnInit, inject} from '@angular/core';
import { CommonModule } from '@angular/common';
import { ServiceListarProductosService } from '../service/service-listar-productos.service';

@Component({
  selector: 'app-listar-productos',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './listar-productos.component.html',
  styleUrls: ['./listar-productos.component.css']
})
export class ListarProductosComponent implements OnInit {
  private productoService = inject(ServiceListarProductosService);
  productos: any[] = [];

  ngOnInit(): void {
    this.productoService.listarProductos().subscribe((productos: any) => {
      this.productos = productos;
    });
  }

  descargarProductospdf(): void {
    this.productoService.descargarPdf().subscribe(
      (response) => {
        const blob = response.body;
        if (blob) {
          const url = window.URL.createObjectURL(blob);
          const a = document.createElement('a');
          a.href = url;
          a.download = 'productos.pdf';
          a.click();
          window.URL.revokeObjectURL(url);
        }
      },
      (error) => {
        console.error('Error al descargar el PDF:', error);
      }
    );
  }
}
