package com.phddigital.quarto.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class Quarto {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private Double valorDiaria;
    private boolean hidromassagem;
    private boolean arcondicionado;
    private boolean alugado;
    @Enumerated(EnumType.STRING)
    private TipoDeQuarto tipoDeQuarto;
    @OneToMany(mappedBy = "quarto",cascade = {CascadeType.REFRESH,CascadeType.ALL})
    private List<Aluguel> aluguel;
    private int numero;

}
