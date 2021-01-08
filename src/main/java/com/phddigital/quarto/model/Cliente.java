package com.phddigital.quarto.model;

import com.phddigital.quarto.validation.CPF;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Cliente implements ModelDao {
    @Id
    @GeneratedValue
    private Integer id;
    public String nome;
    @Column(unique = true)
    @CPF(messsage = "CPF inválido ")
    public String cpf;
    @OneToOne(cascade = CascadeType.MERGE)
    public Endereco endereco;
    @OneToOne(cascade = CascadeType.MERGE)
    public Contato contato;
}
