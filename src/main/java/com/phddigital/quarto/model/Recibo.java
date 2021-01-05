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
    private Cliente cliente;
    @ManyToOne
    private Aluguel aluguel;
    private Double valorTotal;
    private Double diarias;
    @OneToOne
    private Residencia residencia;

}
