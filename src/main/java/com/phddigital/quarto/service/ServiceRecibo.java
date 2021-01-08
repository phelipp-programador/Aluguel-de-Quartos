package com.phddigital.quarto.service;


import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.property.Property;
import com.itextpdf.layout.splitting.DefaultSplitCharacters;
import com.phddigital.quarto.model.Recibo;
import com.phddigital.quarto.model.Residencia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.time.LocalTime;

@Service
public class ServiceRecibo implements ServiceDao {

    private ServiceAluguel serviceAluguel;

    @Autowired
    public ServiceRecibo(ServiceAluguel serviceAluguel) {
        this.serviceAluguel = serviceAluguel;
    }

    public Recibo init(Recibo recibo) {
        LocalTime horaLimiteDiaria = recibo.getResidencia().getHoraLimiteDiaria();
        Double valorTotal = serviceAluguel.calcularValor(recibo.getAluguel(), horaLimiteDiaria);
        Integer diarias = serviceAluguel.calculaDiaria(recibo.getAluguel(), horaLimiteDiaria);
        recibo.setDiarias(diarias);
        recibo.setValorTotal(valorTotal);
        return recibo;
    }

    public void gerarPdf(Recibo recibo) throws IOException {
        recibo = init(recibo);
        PdfDocument pdfDoc = new PdfDocument(new PdfWriter("./Recibo_" + recibo.getId() + ".pdf"));
        Document doc = new Document(pdfDoc);
        Table table = createCabecalho(recibo.getResidencia());
        float tableWidth = doc.getPdfDocument().getDefaultPageSize().getWidth()
                - (doc.getLeftMargin() + doc.getRightMargin());
        table.setWidth(tableWidth);
        
        doc.add(table);
        doc.close();
    }

    private Table createCabecalho(Residencia residencia) {
        Table table = new Table(3);
        Cell cell1 = createCell(residencia.getNome(), 150);
        Cell cell2 = createCell("Telefone : " + residencia.getContato().getTelefones().get(0), 70);
        Cell cell3 = createCell("e-mail" + residencia.getContato().getEmail(), 50);
        table.addCell(cell1);
        table.addCell(cell2);
        table.addCell(cell3);
        return table;
    }


    private Cell createCell(String text, Integer width) {
        Cell cell = new Cell();
        cell.setWidth(width);
        Paragraph p = new Paragraph(text);
        p.setFontSize(8);

        p.setProperty(Property.SPLIT_CHARACTERS, new DefaultSplitCharacters());
        cell.add(p);
        return cell;
    }
}
