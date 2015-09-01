package com.wmoreira.javadevn1.presentation.service;

import com.wmoreira.javadevn1.business.component.ZipCodeComponent;
import com.wmoreira.javadevn1.exception.APIException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wellington.362@gmail.com
 */
@RestController
public class ZipCodeService {

    @Autowired
    ZipCodeComponent zipCodeComponent;

    @RequestMapping(value = "/cep/{ID}",
                    method = RequestMethod.GET,
                    produces = "application/json")
    public ResponseEntity findById(@PathVariable("ID") String id) {
        try {
            return ResponseEntity.ok(zipCodeComponent.findById(id));
        } catch (APIException aex) {
            return ResponseEntity.status(aex.getStatus()).build();
        } catch (Exception exc) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

}
