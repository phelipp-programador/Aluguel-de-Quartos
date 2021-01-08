package com.phddigital.quarto.service;

import com.phddigital.quarto.model.Aluguel;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.Period;

class ServiceAluguelTest {

    @Test
    void calculaDiaria() {
        ServiceAluguel service = new ServiceAluguel(null);
        LocalDateTime data_entrada = LocalDateTime.of(2021, Month.JANUARY, 7, 11, 00);
        LocalDateTime data_saida = LocalDateTime.of(2021, Month.JANUARY, 8, 11, 00);
        LocalTime limite = LocalTime.of(10, 00);

        Assertions.assertEquals(2, service.calculaDiaria(data_entrada, data_saida, limite));
    }



}