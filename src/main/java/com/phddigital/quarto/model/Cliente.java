package com.phddigital.quarto.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
@Data
public class Cliente implements ModelDao {
    @Id
    @GeneratedValue
    private Integer id;
    public String nome;
    public String cpf;
    @OneToOne
    public Endereco endereco;
    @OneToOne
    public Contato contato;
}
