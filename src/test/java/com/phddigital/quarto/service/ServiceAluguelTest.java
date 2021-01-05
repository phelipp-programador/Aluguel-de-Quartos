package com.phddigital.quarto.service;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.Month;

class ServiceAluguelTest {

    @Test
    void calculaDiaria() {
        ServiceAluguel serviceDao = new ServiceAluguel(null);
        LocalDateTime hoje = LocalDateTime.now();
        LocalDateTime saida = LocalDateTime.of(2021, Month.JANUARY, 7,13,0);
        System.out.println(serviceDao.calculaDiaria(hoje,saida,14));
    }
}