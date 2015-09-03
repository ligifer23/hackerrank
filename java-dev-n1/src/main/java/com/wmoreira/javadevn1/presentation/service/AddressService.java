package com.wmoreira.javadevn1.presentation.service;

import com.wmoreira.javadevn1.business.component.AddressComponent;
import com.wmoreira.javadevn1.business.entity.Address;
import com.wmoreira.javadevn1.presentation.service.tool.ServiceUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.net.URI;
import java.net.URISyntaxException;

/**
 * @author wellington.362@gmail.com
 */

@RestController
public class AddressService {

    AddressComponent addressComponent;

    @Autowired
    void setAddressComponent(AddressComponent addressComponent) {
        this.addressComponent = addressComponent;
    }

    @RequestMapping(value = "/endereco/{ID}",
                    method = RequestMethod.GET,
                    produces = "application/json")
    public Address find(@PathVariable("ID") long id) {
        return addressComponent.find(id);
    }

    @RequestMapping(value = "/endereco",
                    method = RequestMethod.POST,
                    produces = "application/json")
    public ResponseEntity<Address> create(HttpServletRequest request, @RequestBody Address address) throws URISyntaxException {
        address.setId(null);
        Address newAddress = addressComponent.save(address);
        String location = new StringBuilder(ServiceUtils.buildLocationFromRequest(request))
                                .append("/endereco/")
                                .append(newAddress.getId())
                                .toString();

        return ResponseEntity.created(new URI(location))
                             .body(newAddress);
    }

    @RequestMapping(value = "/endereco/{ID}",
                    method = RequestMethod.PUT,
                    produces = "application/json")
    public Address update(@PathVariable("ID") long id, @RequestBody Address address) {
        address.setId(id);
        return addressComponent.save(address);
    }

    @RequestMapping(value = "/endereco/{ID}",
                    method = RequestMethod.DELETE,
                    produces = "application/json")
    public void delete(@PathVariable("ID") long id) {
        addressComponent.delete(id);
    }
}
