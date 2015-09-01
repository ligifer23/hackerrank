package com.wmoreira.javadevn1.integration.repository.impl;

import com.wmoreira.javadevn1.business.entity.ZipCode;
import com.wmoreira.javadevn1.integration.repository.ZipCodeRepository;
import org.springframework.stereotype.Repository;

/**
 * @author wellington.362@gmail.com
 */
//@Repository
class ZipCodeDAO implements ZipCodeRepository {
    public ZipCode findById(String zipCode) {
	    return new ZipCode(zipCode, "Rua Vasco da Rocha Leao", "City Bussocaba", "Osasco", "SP");
    }
}
