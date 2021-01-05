package com.phddigital.quarto.service;


import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfReader;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.property.Property;
import com.itextpdf.layout.splitting.DefaultSplitCharacters;
import com.phddigital.quarto.model.Recibo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;

@Service
public class ServiceRecibo implements ServiceDao {
    private ServiceAluguel serviceAluguel;
    @Autowired
    public ServiceRecibo(ServiceAluguel serviceAluguel) {
        this.serviceAluguel = serviceAluguel;
    }
    public void gerarPdf(Recibo recibo) throws IOException {
        PdfDocument pdfDoc = new PdfDocument(new PdfWriter("/home/phelipp/Recibo_"+recibo.getId()+".pdf"));
        Document doc = new Document(pdfDoc);
        Table table = new Table(3);
        float tableWidth = doc.getPdfDocument().getDefaultPageSize().getWidth()
                - (doc.getLeftMargin() + doc.getRightMargin());
        table.setWidth(tableWidth);
        table.setWidth(tableWidth);
        Cell cell1 = new Cell();
        Paragraph p = new Paragraph("1");
        p.setProperty(Property.SPLIT_CHARACTERS, new DefaultSplitCharacters());
        cell1.add(p);
        table.addCell(cell1);
        doc.add(table);
        doc.close();
    }
}
