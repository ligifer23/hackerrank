package com.wmoreira.javadevn1.business.component.impl;

import com.wmoreira.javadevn1.business.component.CepComponent;
import com.wmoreira.javadevn1.business.entity.Cep;
import com.wmoreira.javadevn1.integration.repository.CepRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by welingtonmoreira on 31/08/15.
 */
@Component
class CepComponentImpl implements CepComponent{

    @Autowired
    private CepRepository cepRepository;

    public Cep findById(Integer id) {
	return cepRepository.findById(id);
    }
}
