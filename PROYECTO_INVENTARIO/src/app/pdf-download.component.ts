import { Component } from '@angular/core';
import { PdfService } from './services/pdf.service';

@Component({
  selector: 'app-pdf-download',
  templateUrl: './pdf-download.component.html',
  styleUrls: ['./pdf-download.component.css']
})
export class PdfDownloadComponent {

    constructor(private pdfService: PdfService) { }

    downloadPdf(): void {
      this.pdfService.downloadPdf().subscribe(response => {
        if (response && response.body) {
          this.saveFile(response.body);
        } else {
          console.error('La respuesta del servidor es nula o no tiene cuerpo.');
        }
      }, error => {
        console.error('Ocurrió un error al descargar el PDF:', error);
      });
    }
  
    private saveFile(blobData: Blob): void {
      const blob = new Blob([blobData], { type: 'application/pdf' });
      const url = window.URL.createObjectURL(blob);
      window.open(url);
    }
  }