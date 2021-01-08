package com.phddigital.quarto.model;

import lombok.Data;
import lombok.ToString;
import org.dom4j.rule.Mode;

import javax.persistence.*;

@Entity
@Data
@ToString(callSuper = false, includeFieldNames = false)
public class Telefone implements ModelDao {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @ToString.Exclude
    private Integer id;
    @Column(length = 3)
    private String ddd;
    private String numero;

    @Override
    public String toString() {
        ddd=ddd.trim();
        numero=numero.trim();
        if (ddd.length() < 3) {
            ddd = "0" + ddd;
        }
        String primeiroNumero = numero.substring(0, 4);
        String segundoNumero = numero.substring(4);
        numero = primeiroNumero + "-" + segundoNumero;

        return "(" + ddd + ") " + numero;
    }


}
