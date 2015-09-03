package com.wmoreira.javadevn1.presentation.service;

import com.wmoreira.javadevn1.business.component.ZipCodeComponent;
import com.wmoreira.javadevn1.business.entity.ZipCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wellington.362@gmail.com
 */

@RestController
public class ZipCodeService {

    ZipCodeComponent zipCodeComponent;

    @Autowired
    void setZipCodeComponent(ZipCodeComponent zipCodeComponent) {
        this.zipCodeComponent = zipCodeComponent;
    }

    @RequestMapping(value = "/cep/{ID}",
                    method = RequestMethod.GET,
                    produces = "application/json")
    public ZipCode find(@PathVariable("ID") String id) {
        return zipCodeComponent.find(id);
    }
}
