import { Component } from '@angular/core';
import { RouterModule } from '@angular/router';
import { ListarProveedoresComponent } from './listar-proveedores/listar-proveedores.component';
import { ListarProductosComponent } from './listar-productos/listar-productos.component'; 
import { ListarCategoriasComponent } from './listar-categorias/listar-categorias.component';
@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
  standalone: true,
  imports: [RouterModule, ListarProveedoresComponent, ListarProductosComponent, ListarCategoriasComponent]
})
export class AppComponent {
  title = 'PROYECTO_INVENTARIO';
}