import { Component, OnInit, inject } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ServiceListarProveedoresService } from '../services/service-listar-proveedores.service';

@Component({
  selector: 'app-listar-proveedores',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './listar-proveedores.component.html',
  styleUrls: ['./listar-proveedores.component.css']
})
export class ListarProveedoresComponent implements OnInit {
  private proveedorService = inject(ServiceListarProveedoresService);
  proveedores: any[] = [];

  ngOnInit(): void {
    this.proveedorService.listarProveedores().subscribe((proveedores: any) => {
      this.proveedores = proveedores;
    });
  }

  downloadPdf(): void {
    this.proveedorService.descargarPdf().subscribe(
      (response) => {
        const blob = response.body;
        if (blob) {
          const url = window.URL.createObjectURL(blob);
          const a = document.createElement('a');
          a.href = url;
          a.download = 'proveedores.pdf';
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