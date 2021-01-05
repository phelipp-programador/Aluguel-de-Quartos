package com.phddigital.quarto.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Recibo implements ModelDao {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @ManyToOne
    public Cliente cliente;
    @ManyToOne
    public Aluguel aluguel;
    public Double valorTotal;
    public Double diarias;
}
