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
        PdfDocument pdfDoc = new PdfDocument(new PdfWriter("./Recibo_"+recibo.getId()+".pdf"));
        Document doc = new Document(pdfDoc);
        Table table = new Table(3);
        float tableWidth = doc.getPdfDocument().getDefaultPageSize().getWidth()
                - (doc.getLeftMargin() + doc.getRightMargin());
        table.setWidth(tableWidth);
        Cell cell1 = createCell("Numero : " + recibo.getId(), 40);
        Cell cell2 = createCell("Dias : " + recibo.getDiarias(), 100);
        Cell cell3 = createCell("Valor : " + recibo.getValorTotal(), 100);

        table.addCell(cell1);
        table.addCell(cell2);
        table.addCell(cell3);

        doc.add(table);
        doc.close();
    }
    private Cell createCell(String text,Integer width){
        Cell cell = new Cell();
        cell.setWidth(width);
        Paragraph p = new Paragraph(text);


        p.setProperty(Property.SPLIT_CHARACTERS, new DefaultSplitCharacters());
        cell.add(p);
        return cell;
    }
}
