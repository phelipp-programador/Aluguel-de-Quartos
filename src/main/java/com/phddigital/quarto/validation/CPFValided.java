package com.phddigital.quarto.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.nio.charset.Charset;

public class CPFValided implements ConstraintValidator<CPF, String> {
    private String value;

    private String geraDigitoVerificardo(String value, boolean isJ) {
        int result = 0;
        int constanteAux = (isJ) ? value.length() - 1 : value.length();
        for (int i = 0, constante = constanteAux; constante >= 2; i++, constante--) {
            char v = value.charAt(i);
            String resultado = String.valueOf(v);
            result += Integer.parseInt(resultado) * constante;

        }
        int resto = result % 11;
        if (resto == 0 || resto == 1) {
            result = 0;
        } else {
            result = 11 - resto;
        }
        return String.valueOf(result);
    }

    @Override
    public void initialize(CPF constraintAnnotation) {
        this.value = constraintAnnotation.value();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {
        if (value.length() != 11) return false;
        String j = geraDigitoVerificardo(value, true);
        String jValue = String.valueOf(value.charAt(9));
        if (!j.equals(jValue)) return false;
        String k = geraDigitoVerificardo(value, false);
        String kValue = String.valueOf(value.charAt(10));
        return k.equals(kValue);

    }
}
