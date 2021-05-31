package com.example.management.service;


import com.example.management.model.Employee;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfWriter;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.List;

@Service
@AllArgsConstructor
public class PdfService {

    public static final String PDF_FILE_PATH = "src/main/resources/static/myFirstA5pdf.pdf";

    private final EmployeeService employeeService;

    public void generatePdf() throws FileNotFoundException, DocumentException {
        Document document = new Document(PageSize.A5);
        PdfWriter.getInstance(document, new FileOutputStream(PDF_FILE_PATH));

        document.open();
        printOutInitialParagraph(document);
        printOutEmployeeData(document);


        document.close();
    }

    private void printOutInitialParagraph(Document document) throws DocumentException {
        Font font = FontFactory.getFont(FontFactory.HELVETICA, 16, BaseColor.BLUE);
        Paragraph firstParagraph = new Paragraph("Hello PDF World", font);
        document.add(firstParagraph);
    }

    private void printOutEmployeeData(Document document) throws DocumentException {
        List<Employee> employees = employeeService.getAllEmployees();
        int counter = 1;

        Paragraph employeeParagraph;
        for (Employee employee : employees) {
            String text = counter++ + ". " + employee.getFirstName() + " " + employee.getDepartment().getName();
            employeeParagraph = new Paragraph(text);
            document.add(employeeParagraph);
        }
    }
}
