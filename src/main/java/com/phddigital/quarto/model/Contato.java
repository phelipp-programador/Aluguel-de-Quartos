package com.phddigital.quarto.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class Contato implements ModelDao {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String email;
    @OneToMany
    private List<Telefone> telefones;
}
