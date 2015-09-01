package com.wmoreira.javadevn1.business.component.impl;

import com.wmoreira.javadevn1.business.component.ZipCodeComponent;
import com.wmoreira.javadevn1.business.entity.ZipCode;
import com.wmoreira.javadevn1.business.validator.ZipCodeValidator;
import com.wmoreira.javadevn1.exception.BadRequestException;
import com.wmoreira.javadevn1.exception.NotFoundException;
import com.wmoreira.javadevn1.integration.repository.ZipCodeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * @author wellington.362@gmail.com
 */

@Component
class ZipCodeComponentImpl implements ZipCodeComponent {

    @Autowired
    private ZipCodeRepository zipCodeRepository;

    public ZipCode findById(String zipCode) {

        if (!ZipCodeValidator.validate(zipCode)) {
            throw new BadRequestException("CEP inválido. O mesmo deverá ser numérico e possuir 8 dígitos.");
        }

        StringBuilder auxZip = new StringBuilder(zipCode);

        for (int i = auxZip.length()-1; i >= 0; i--) {
            Optional<ZipCode> optZip = Optional.ofNullable(zipCodeRepository.findById(auxZip.toString()));

            if (optZip.isPresent()) {
                return optZip.get();
            }

            auxZip.setCharAt(i, '0');
        }

        Optional<ZipCode> lastOptZip = Optional.ofNullable(zipCodeRepository.findById(auxZip.toString()));

        if (lastOptZip.isPresent()) {
            return lastOptZip.get();
        }

        throw new NotFoundException();
    }

    void setZipCodeRepository(ZipCodeRepository zipCodeRepository) {
        this.zipCodeRepository = zipCodeRepository;
    }
}
