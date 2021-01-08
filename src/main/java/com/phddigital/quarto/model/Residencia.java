package com.phddigital.quarto.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalTime;
import java.util.List;
@Data
@Entity
public class Residencia implements ModelDao {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Integer id ;
    public String nome ;
    public Endereco endereco;
    @OneToOne
    public Contato contato;
    @OneToMany
    private List<Quarto> quartos ;
    @OneToMany
    private List<Cliente> clientes ;
    private LocalTime horaLimiteDiaria;
}
