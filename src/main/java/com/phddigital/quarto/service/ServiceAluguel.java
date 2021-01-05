package com.phddigital.quarto.service;

import com.phddigital.quarto.model.Aluguel;
import com.phddigital.quarto.model.Cliente;
import com.phddigital.quarto.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
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
     */
    public Long calculaDiaria(LocalDateTime entrada, LocalDateTime saida, Integer horaCorte) {
        Long hora = ChronoUnit.HOURS.between(entrada, saida);
        Long days= (hora/24);
        if(days==0){
            days=1L;
        }
        else if(hora>horaCorte){
            days++;
        }


        return days;
    }
    public Double calcularValor(Aluguel aluguel){
        LocalDateTime dataEntrada = aluguel.getDataEntrada();
        LocalDateTime dataSaida = aluguel.getDataSaida();
        Double valorDiaria = aluguel.getQuarto().getValorDiaria();
        Double valor = calculaDiaria(dataEntrada,dataSaida,12)*valorDiaria;
        return valor;
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
