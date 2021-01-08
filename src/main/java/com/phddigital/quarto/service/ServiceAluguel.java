package com.phddigital.quarto.service;

import com.phddigital.quarto.model.Aluguel;
import com.phddigital.quarto.model.Cliente;
import com.phddigital.quarto.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;
import java.time.chrono.ChronoLocalDateTime;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalField;
import java.util.List;
import java.util.Optional;

@Service
public class ServiceAluguel implements ServiceDao {
    private ClienteRepository repository;
    private Aluguel aluguel;

    @Autowired
    public ServiceAluguel(ClienteRepository repository) {
        this.repository = repository;
    }

    /**
     *
     */
    public Integer calculaDiaria(LocalDateTime data_entrada, LocalDateTime data_saida, LocalTime limiteDiaria) {
        int dayIncrement = 0;
        int intervalo = Period.between(data_entrada.toLocalDate(), data_saida.toLocalDate()).getDays();
        if ((data_entrada.toLocalTime().isBefore(limiteDiaria)
                && data_saida.toLocalTime().isAfter(limiteDiaria))
                || (data_saida.toLocalTime().isAfter(limiteDiaria) && data_entrada.isBefore(data_saida))) {

            dayIncrement++;
        }
        return (intervalo == 0) ? 1 + dayIncrement : intervalo + dayIncrement;

    }
    public Integer calculaDiaria(Aluguel aluguel,LocalTime limiteHoraDiaria){
        return calculaDiaria(aluguel.getDataEntrada(),aluguel.getDataSaida(),limiteHoraDiaria);
    }

    public Double calcularValor(Integer diaria, Double valorDiaria) {
        return diaria * valorDiaria;
    }

    public Double calcularValor(LocalDateTime data_entrada, LocalDateTime data_saida, LocalTime horaLimite, Double valorDiaria) {
        return calculaDiaria(data_entrada, data_saida, horaLimite) * valorDiaria;
    }

    public Double calcularValor(Aluguel aluguel, LocalTime horaLimite) {
        return calcularValor(aluguel.getDataEntrada(), aluguel.getDataSaida(), horaLimite, aluguel.getQuarto().getValorDiaria());
    }

    public Double calculaValor(Aluguel aluguel) {
        return calcularValor(aluguel, LocalTime.of(12, 00));
    }

    public Cliente save(Cliente entity) {
        Optional<Cliente> cliente = save(repository, entity);
        return cliente.orElseThrow(() -> new ResponseStatusException(HttpStatus.NO_CONTENT));
    }

    public List<Cliente> select() {
        Optional<List> select = select(repository);
        return select.orElseThrow(() -> new ResponseStatusException(HttpStatus.NO_CONTENT));
    }
}
