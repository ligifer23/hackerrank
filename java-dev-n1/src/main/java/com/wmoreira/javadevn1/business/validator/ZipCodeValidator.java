package com.wmoreira.javadevn1.business.validator;

import java.util.regex.Pattern;

/**
 * @author wellington.362@gmail.com
 */

public class ZipCodeValidator {

    public static boolean validate(String zipCode) {
        Pattern zipPattern = Pattern.compile("^[0-9]{8}");
        return zipCode == null ? false : zipPattern.matcher(zipCode).matches();
    }
}
