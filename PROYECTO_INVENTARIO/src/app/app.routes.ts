import { Routes } from '@angular/router';
import { ListarProveedoresComponent } from './listar-proveedores/listar-proveedores.component';
import { ListarProductosComponent } from './listar-productos/listar-productos.component';
import { ListarCategoriasComponent } from './listar-categorias/listar-categorias.component';

export const routes: Routes = [
  { path: 'proveedores', component: ListarProveedoresComponent },
  { path: 'productos', component: ListarProductosComponent },
  { path: 'categorias', component: ListarCategoriasComponent }, 
  { path: '', component: ListarProveedoresComponent },
]; 