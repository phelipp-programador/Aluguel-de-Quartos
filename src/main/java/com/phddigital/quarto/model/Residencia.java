package com.phddigital.quarto.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;
@Data
@Entity
public class Residencia {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int id ;
    public String nome ;
    public Endereco endereco ;
    @OneToOne
    public Contato contato;
    @OneToMany
    private List<Quarto> quartos ;
    @OneToMany
    private List<Cliente> clientes ;
}
