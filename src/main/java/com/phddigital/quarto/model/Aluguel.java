package com.phddigital.quarto.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
@Data
@Entity
public class Aluguel implements ModelDao{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private LocalDateTime dataEntrada;
    private LocalDateTime dataSaida;
    @OneToOne
    private Quarto quarto;
    @OneToOne
    private Cliente cliente;
}
