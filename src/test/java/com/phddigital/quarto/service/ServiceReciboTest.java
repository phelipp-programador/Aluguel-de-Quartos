package com.phddigital.quarto.service;

import com.phddigital.quarto.model.*;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class ServiceReciboTest {

    private Recibo initRecibo() {
        Residencia residencia = new Residencia();
        Contato contato = new Contato();
        Telefone telefone = new Telefone();
        telefone.setDdd("21");
        telefone.setNumero("971601574");
        contato.setTelefones(new ArrayList<>());
        contato.getTelefones().add(telefone);
        residencia.setId(1);
        residencia.setContato(contato);
        residencia.setNome("Tempo mais");
        Aluguel aluguel = new Aluguel();
        Cliente cliente = new Cliente();
        aluguel.setDataSaida(LocalDateTime.now());
        Recibo recibo = new Recibo();
        recibo.setResidencia(residencia);
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