package com.phddigital.quarto.model;

import lombok.Getter;

@Getter
public enum TipoDeQuarto {
    CASAL("Casal"),SOLTEIRO("Solteiro");
    private final String value;
    TipoDeQuarto(String value){
        this.value=value;
    }
}
