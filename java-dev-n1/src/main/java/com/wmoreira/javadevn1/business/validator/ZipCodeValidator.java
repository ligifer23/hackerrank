package com.wmoreira.javadevn1.business.validator;

import com.wmoreira.javadevn1.exception.BadRequestException;

import java.util.regex.Pattern;

/**
 * @author wellington.362@gmail.com
 */

public class ZipCodeValidator {

    public static String unmaskAndValidate(String zipCode) {
        String zipUnmasked = zipCode.replace("-", "");
        Pattern zipPattern = Pattern.compile("^[0-9]{8}");
        boolean matches = zipPattern.matcher(zipUnmasked).matches();

        if (!matches) {
            throw new BadRequestException("Invalid zip code! Allowed formats: 00000-000|00000000");
        }

        return zipUnmasked;
    }
}
