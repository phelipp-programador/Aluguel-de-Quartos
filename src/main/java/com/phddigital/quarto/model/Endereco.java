package com.phddigital.quarto.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity
public class Endereco implements ModelDao{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    public String cep ;
    public String logradouro ;
    public String complemento;
    public String bairro;
    public String localidade ;
    public String uf ;
    public String unidade;
    public String ibge ;
    public String gia;
    public String numero;
    }
