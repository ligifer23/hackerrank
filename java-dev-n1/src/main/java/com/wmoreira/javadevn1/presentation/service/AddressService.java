package com.wmoreira.javadevn1.presentation.service;

import com.wmoreira.javadevn1.business.component.AdressComponent;
import com.wmoreira.javadevn1.business.component.ZipCodeComponent;
import com.wmoreira.javadevn1.business.entity.Address;
import com.wmoreira.javadevn1.exception.APIException;
import com.wmoreira.javadevn1.presentation.service.error.APIError;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author wellington.362@gmail.com
 */

@RestController
public class AddressService {

    @Autowired
    AdressComponent addressComponent;

    @RequestMapping(value = "/address/{ID}",
                    method = RequestMethod.GET,
                    produces = "application/json")
    public ResponseEntity find(@PathVariable("ID") long id) {
        try {
            return ResponseEntity.ok(addressComponent.find(id));
        } catch (APIException aex) {
            return ResponseEntity.status(aex.getStatus()).body(APIError.of(aex.getStatus(), aex.getMessage()));
        } catch (Exception exc) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(APIError.of(HttpStatus.INTERNAL_SERVER_ERROR.value()));
        }
    }

    @RequestMapping(value = "/address",
            method = RequestMethod.POST,
            produces = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity create(@RequestBody Address address) {
        try {
            return ResponseEntity.ok(addressComponent.create(address));
        } catch (APIException aex) {
            return ResponseEntity.status(aex.getStatus()).body(APIError.of(aex.getStatus(), aex.getMessage()));
        } catch (Exception exc) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(APIError.of(HttpStatus.INTERNAL_SERVER_ERROR.value()));
        }
    }

    @RequestMapping(value = "/address/{ID}",
            method = RequestMethod.PUT,
            produces = "application/json")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity update(@PathVariable("ID") long id, @RequestBody Address address) {
        try {
            //TODO: setId
            addressComponent.update(address);
            return ResponseEntity.ok().build();
        } catch (APIException aex) {
            return ResponseEntity.status(aex.getStatus()).body(APIError.of(aex.getStatus(), aex.getMessage()));
        } catch (Exception exc) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(APIError.of(HttpStatus.INTERNAL_SERVER_ERROR.value()));
        }
    }

    @RequestMapping(value = "/address/{ID}",
            method = RequestMethod.DELETE,
            produces = "application/json")
    public ResponseEntity delete(@PathVariable("ID") long id) {
        try {
            addressComponent.delete(id);
            return ResponseEntity.ok().build();
        } catch (APIException aex) {
            return ResponseEntity.status(aex.getStatus()).body(APIError.of(aex.getStatus(), aex.getMessage()));
        } catch (Exception exc) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(APIError.of(HttpStatus.INTERNAL_SERVER_ERROR.value()));
        }
    }

    void setAddressComponent(AdressComponent addressComponent) {
        this.addressComponent = addressComponent;
    }
}
