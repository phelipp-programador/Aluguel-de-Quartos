package com.phddigital.quarto.service;

import com.phddigital.quarto.model.Aluguel;
import com.phddigital.quarto.model.Cliente;
import com.phddigital.quarto.model.Recibo;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class ServiceReciboTest {

    private Recibo initRecibo() {
        Aluguel aluguel = new Aluguel();
        Cliente cliente = new Cliente();
        aluguel.setDataSaida(LocalDateTime.now());
        Recibo recibo = new Recibo();
        recibo.setId(1);
        recibo.setAluguel(aluguel);
        recibo.setCliente(cliente);
        return recibo;
    }

    @Test
    void gerarPdf() throws IOException {
        ServiceRecibo serviceRecibo = new ServiceRecibo(null);
        Recibo recibo = initRecibo();
        serviceRecibo.gerarPdf(recibo);
    }
}