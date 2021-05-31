package com.example.management.controller;

import com.example.management.service.PdfService;
import com.itextpdf.text.DocumentException;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileNotFoundException;

@RestController
@RequestMapping("/api/pdf")
@AllArgsConstructor
public class PdfController {

    private final PdfService pdfService;

    @GetMapping("/generate")
    public void generatePDF() throws DocumentException, FileNotFoundException {
        pdfService.generatePdf();
    }
}
