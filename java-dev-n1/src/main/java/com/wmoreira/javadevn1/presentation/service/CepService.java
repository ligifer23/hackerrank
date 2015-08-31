package com.wmoreira.javadevn1.presentation.service;

import com.wmoreira.javadevn1.business.component.CepComponent;
import com.wmoreira.javadevn1.business.entity.Cep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by welingtonmoreira on 31/08/15.
 */
@RestController
public class CepService {

    @Autowired
    CepComponent cepComponent;

    @RequestMapping(value = "/cep/{ID}",
                    method = RequestMethod.GET,
                    produces = "application/json")
    public ResponseEntity<Cep> findById(@PathVariable("ID") Integer id) {
        return ResponseEntity.ok(cepComponent.findById(id));
    }

}
