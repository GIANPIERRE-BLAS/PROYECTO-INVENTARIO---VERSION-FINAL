import { Component, inject, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ServiceListarCategoriasService } from '../services/service-listar-categorias.service';

@Component({
  selector: 'app-listar-categorias',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './listar-categorias.component.html',
  styleUrls: ['./listar-categorias.component.css']
})
export class ListarCategoriasComponent implements OnInit {
  private categoriasService = inject(ServiceListarCategoriasService);
  categorias: any[] = [];

  ngOnInit(): void {
    this.categoriasService.listarCategorias().subscribe((categorias: any) => {
      this.categorias = categorias;
    });
  }

  descargarCategoriasPdf(): void {
    this.categoriasService.descargarPdf().subscribe(
      (response) => {
        const blob = response.body;
        if (blob) {
          const url = window.URL.createObjectURL(blob);
          const a = document.createElement('a');
          a.href = url;
          a.download = 'categorias.pdf';
          a.click();
          window.URL.revokeObjectURL(url);
        }
      },
      (error) => {
        console.error('Error al descargar el PDF de categorías:', error);
      }
    );
  }
}
