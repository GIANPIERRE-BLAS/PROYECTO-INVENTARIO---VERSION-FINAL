// src/app/models.ts
export interface Producto {
    codProducto: number;
    desProducto: string;
    codCategoria: number;
    desCategoria?: string;
  }
  
  export interface Categoria {
    codCategoria: number;
    desCategoria: string;
  }