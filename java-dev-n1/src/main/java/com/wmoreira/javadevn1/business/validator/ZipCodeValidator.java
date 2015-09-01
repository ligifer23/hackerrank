package com.wmoreira.javadevn1.business.validator;

import com.wmoreira.javadevn1.exception.BadRequestException;

import java.util.regex.Pattern;

/**
 * @author wellington.362@gmail.com
 */

public class ZipCodeValidator {

    public static void unmaskAndValidate(String zipCode) {
        Pattern zipPattern = Pattern.compile("^[0-9]{8}");
        boolean matches = zipPattern.matcher(zipCode).matches();

        if (!matches) {
            throw new BadRequestException("CEP inválido. O mesmo deverá ser numérico e possuir 8 dígitos.");
        }
    }
}
