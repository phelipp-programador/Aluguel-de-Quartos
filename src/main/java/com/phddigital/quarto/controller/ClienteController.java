package com.phddigital.quarto.controller;

import com.phddigital.quarto.model.Cliente;
import com.phddigital.quarto.service.ServiceCliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/cliente/")
public class ClienteController {
    @Autowired
    private ServiceCliente serviceCliente;
    @GetMapping
    public Cliente save(Cliente cliente){
     return serviceCliente.save(cliente);
    }
}
