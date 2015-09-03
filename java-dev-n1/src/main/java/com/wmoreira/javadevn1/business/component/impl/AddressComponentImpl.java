package com.wmoreira.javadevn1.business.component.impl;

import com.wmoreira.javadevn1.business.component.AddressComponent;
import com.wmoreira.javadevn1.business.component.ZipCodeComponent;
import com.wmoreira.javadevn1.business.entity.Address;
import com.wmoreira.javadevn1.integration.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.wmoreira.api.core.exception.APIException;
import org.wmoreira.api.core.exception.NotFoundException;
import org.wmoreira.api.core.exception.UnprocessableEntityException;
import org.wmoreira.api.core.exception.handler.APIViolation;

import java.util.Arrays;

/**
 * @author wellington.362@gmail.com
 */

@Component
class AddressComponentImpl implements AddressComponent {

    ZipCodeComponent zipCodeComponent;
    AddressRepository addressRepository;

    @Autowired
    void setZipCodeComponent(ZipCodeComponent zipCodeComponent) {
        this.zipCodeComponent = zipCodeComponent;
    }

    @Autowired
    void setAddressRepository(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    @Override
    public Address find(long id) {
        Address address = addressRepository.findOne(id);

        if (address == null) {
            throw new NotFoundException("Endereço não encontrado!");
        }

        return address;
    }

    @Override
    public Address save(Address address) {
        if (address.getId() != null) {
            find(address.getId());
        }

        try {
            zipCodeComponent.find(address.getZipCode());
        } catch (APIException aex) {
            throw new UnprocessableEntityException(Arrays.asList(APIViolation.of(aex.getMessage())));
        }


        return addressRepository.save(address);
    }

    @Override
    public void delete(long id) {
        addressRepository.delete(id);
    }
}
