package com.wmoreira.javadevn1.business.validator;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author wellington.362@gmail.com
 */

public class ZipCodeValidatorResolverUnitTest {

    @Test
    public void testValidateCaseValid() {
        String[] zipCodes = {"02377210", "03450050", "06040500", "03266060", "04935000", "03278090", "04822190"};

        for(String zipCode : zipCodes) {
            assertTrue(ZipCodeValidator.validate(zipCode));
        }
    }

    @Test
    public void testValidateCaseInvalid() {
        String[] zipCodes = {"02370-710", "3450050", "060405000", "-3266060", "049350--", "0--78090", "004822190"};

        for(String zipCode : zipCodes) {
            assertFalse(ZipCodeValidator.validate(zipCode));
        }
    }

}
