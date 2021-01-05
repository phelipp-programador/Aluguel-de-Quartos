package com.phddigital.quarto.service;

import com.phddigital.quarto.model.Cliente;
import com.phddigital.quarto.repository.ClienteRepository;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class ServiceCliente implements ServiceDao{
    private ClienteRepository repository ;

    @Autowired
    public ServiceCliente(ClienteRepository repository) {
        this.repository = repository;
    }

    public Cliente save(Cliente entity){
        Optional<Cliente> cliente = save(repository, entity);
        return cliente.orElseThrow(()->new ResponseStatusException(HttpStatus.NO_CONTENT));
    }
    public List<Cliente> select(){
        Optional<List> select = select(repository);
        return select.orElseThrow(()->new ResponseStatusException(HttpStatus.NO_CONTENT));
    }
}
