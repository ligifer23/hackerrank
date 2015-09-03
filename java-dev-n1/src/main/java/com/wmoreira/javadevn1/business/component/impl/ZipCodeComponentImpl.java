package com.wmoreira.javadevn1.business.component.impl;

import com.wmoreira.javadevn1.business.component.ZipCodeComponent;
import com.wmoreira.javadevn1.business.entity.ZipCode;
import com.wmoreira.javadevn1.business.validator.ZipCodeValidator;
import com.wmoreira.javadevn1.integration.repository.ZipCodeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.wmoreira.api.core.exception.BadRequestException;
import org.wmoreira.api.core.exception.NotFoundException;

import java.util.Optional;

/**
 * @author wellington.362@gmail.com
 */

@Component
class ZipCodeComponentImpl implements ZipCodeComponent {

    private ZipCodeRepository zipCodeRepository;

    @Autowired
    void setZipCodeRepository(ZipCodeRepository zipCodeRepository) {
        this.zipCodeRepository = zipCodeRepository;
    }

    @Override
    public ZipCode find(String zipCode) {
        if (!ZipCodeValidator.validate(zipCode)) {
            throw new BadRequestException("CEP inválido. O mesmo deverá ser numérico e possuir 8 dígitos.");
        }

        Optional<ZipCode> optZip = Optional.ofNullable(zipCodeRepository.findById(zipCode));

        if (!optZip.isPresent()) {
            throw new NotFoundException("CEP não encontrado!");
        }

        return optZip.get();
    }

    public ZipCode lookup(String zipCode) {
        StringBuilder auxZip = new StringBuilder(zipCode);

        for (int i = auxZip.length()-1; i >= 0; i--) {
            try {
                return find(auxZip.toString());
            } catch (NotFoundException nfe) {
                auxZip.setCharAt(i, '0');
            }
        }

        return find(auxZip.toString());
    }
}
