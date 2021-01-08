package com.phddigital.quarto.validation;

import org.junit.jupiter.api.Test;

import java.nio.charset.Charset;

import static org.junit.jupiter.api.Assertions.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CPFValidedTest {


    @Test
    void isValid() {
        String value = "1346065373";
        String cpf = "13517458759";
        CPFValided cpfValided = new CPFValided();
        assertTrue(cpfValided.isValid(value, null));

    }
}