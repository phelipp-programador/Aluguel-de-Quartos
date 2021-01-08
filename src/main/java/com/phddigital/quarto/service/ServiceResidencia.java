package com.phddigital.quarto.service;

import com.phddigital.quarto.model.Cliente;
import com.phddigital.quarto.model.Residencia;
import com.phddigital.quarto.repository.ClienteRepository;
import com.phddigital.quarto.repository.ResidenciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class ServiceResidencia implements ServiceDao{
    private ResidenciaRepository repository ;
    @Autowired
    private boolean contemResidencia;
    @Autowired
    public ServiceResidencia(ResidenciaRepository repository, boolean contemResidencia) {
        this.repository = repository;
        this.contemResidencia=contemResidencia;
    }

    public Residencia save(Residencia entity){
        if(!contemResidencia){
            Optional<Residencia> residencia = save(repository, entity);
        }

        return residencia.orElseThrow(()->new ResponseStatusException(HttpStatus.NO_CONTENT));
    }
    public List<Cliente> select(){
        Optional<List> select = select(repository);
        return select.orElseThrow(()->new ResponseStatusException(HttpStatus.NO_CONTENT));
    }
    p

}
