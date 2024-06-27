package com.crud.proveedor.controlador;

import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import com.crud.proveedor.modelo.Proveedor;
import com.crud.proveedor.servicio.IProveedorServicio;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
@RequestMapping("/api/proveedores")
@CrossOrigin
public class ProveedorRestController {

    @Autowired
    private IProveedorServicio proveedorServicio;

    @GetMapping
    public List<Proveedor> listarProveedores() {
        return proveedorServicio.listarProveedores();
    }

    @GetMapping("/pdf")
    public ResponseEntity<InputStreamResource> generarPDF() throws IOException {
        List<Proveedor> proveedores = proveedorServicio.listarProveedores();
        
        // Creamos el documento PDF
        try (PDDocument document = new PDDocument()) {
            PDPage page = new PDPage();
            document.addPage(page);
            
            // Creamos el contenido del PDF
            try (PDPageContentStream contentStream = new PDPageContentStream(document, page)) {
                contentStream.beginText();
                contentStream.setFont(PDType1Font.HELVETICA_BOLD, 12);
                contentStream.newLineAtOffset(100, 700);
                contentStream.showText("Proveedores:");

                int y = 680;
                for (Proveedor proveedor : proveedores) {
                    y -= 20;
                    contentStream.setFont(PDType1Font.HELVETICA, 12);
                    contentStream.newLineAtOffset(0, -20);
                    contentStream.showText("Código: " + proveedor.getId() +
                            ", Nombre: " + proveedor.getNombre() +
                            ", Apellido: " + proveedor.getApellido());
                }
                contentStream.endText();
            }
            
            // Escribimos el PDF en un flujo de bytes
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            document.save(byteArrayOutputStream);
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
            
            // Devolvemos el PDF como un recurso de entrada de flujo
            HttpHeaders headers = new HttpHeaders();
            headers.add("Content-Disposition", "inline; filename=proveedores.pdf");
            return ResponseEntity
                    .ok()
                    .headers(headers)
                    .contentType(MediaType.APPLICATION_PDF)
                    .body(new InputStreamResource(byteArrayInputStream));
        }
    }
}
