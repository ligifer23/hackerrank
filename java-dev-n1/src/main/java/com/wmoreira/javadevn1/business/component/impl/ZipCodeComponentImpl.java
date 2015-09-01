package com.wmoreira.javadevn1.business.component.impl;

import com.wmoreira.javadevn1.business.validator.ZipCodeValidator;
import com.wmoreira.javadevn1.business.component.ZipCodeComponent;
import com.wmoreira.javadevn1.business.entity.ZipCode;
import com.wmoreira.javadevn1.exception.NotFoundException;
import com.wmoreira.javadevn1.integration.repository.ZipCodeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author wellington.362@gmail.com
 */
@Component
class ZipCodeComponentImpl implements ZipCodeComponent {

    @Autowired
    private ZipCodeRepository zipCodeRepository;

    public ZipCode findById(String zipCode) {
        ZipCodeValidator.unmaskAndValidate(zipCode);
        StringBuilder auxZip = new StringBuilder(zipCode);

        for (int i = auxZip.length(); i > 0; i--) {
            ZipCode zip = zipCodeRepository.findById(auxZip.toString());

            if (zip != null) {
                return zip;
            }

            auxZip.setCharAt(i-1, '0');
        }

        throw new NotFoundException();
    }

    void setZipCodeRepository(ZipCodeRepository zipCodeRepository) {
        this.zipCodeRepository = zipCodeRepository;
    }
}
