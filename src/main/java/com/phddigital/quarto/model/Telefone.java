package com.phddigital.quarto.model;

import lombok.Data;
import org.dom4j.rule.Mode;

import javax.persistence.*;

@Entity
@Data
public class Telefone implements ModelDao {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(length = 3)
    private String ddd;
    private String numero;

}
