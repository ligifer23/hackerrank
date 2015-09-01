package com.wmoreira.javadevn1.business.validator;

import com.wmoreira.javadevn1.exception.BadRequestException;

import java.util.regex.Pattern;

/**
 * @author wellington.362@gmail.com
 */

public class ZipCodeValidator {

    public static boolean validate(String zipCode) {
        Pattern zipPattern = Pattern.compile("^[0-9]{8}");
        return zipPattern.matcher(zipCode).matches();
    }
}
