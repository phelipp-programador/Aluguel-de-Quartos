package com.phddigital.quarto.model;

import lombok.Data;

import javax.persistence.*;

@Data
public class Recibo {
    private Integer id;
    private Cliente cliente;
    private Aluguel aluguel;
    private Double valorTotal;
    private Integer diarias;
    private Residencia residencia;

}
