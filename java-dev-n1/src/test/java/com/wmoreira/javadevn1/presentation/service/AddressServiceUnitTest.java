package com.wmoreira.javadevn1.presentation.service;

import com.wmoreira.javadevn1.business.component.AddressComponent;
import com.wmoreira.javadevn1.business.entity.Address;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Matchers;
import org.mockito.Mockito;
import org.wmoreira.api.core.exception.InternalServerErrorException;
import org.wmoreira.api.core.exception.NotFoundException;

import javax.servlet.http.HttpServletRequest;
import java.net.URISyntaxException;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

/**
 * @author wellington.362@gmail.com
 */

public class AddressServiceUnitTest {

    AddressService     instance  = new AddressService();
    AddressComponent   component = mock(AddressComponent.class);
    HttpServletRequest request   = mock(HttpServletRequest.class);

    @Before public void setUp() {
        instance.setAddressComponent(component);
        when(request.getScheme()).thenReturn("http");
        when(request.getServerName()).thenReturn("127.0.0.1");
        when(request.getServerPort()).thenReturn(8080);
    }

    @Test public void testFindSuccess() {
        //Given
        long id = 1l;
        Address address = new Address();
        address.setId(id);
        when(component.find(id)).thenReturn(address);

        //When
        Address response = instance.find(id);

        //Then
        assertEquals(address, response);
    }

    @Test(expected = NotFoundException.class)
    public void testFindCaseNotFound() {
        //Given
        NotFoundException notFound = new NotFoundException();

        when(component.find(Matchers.anyLong())).thenThrow(notFound);

        //When
        instance.find(1l);
    }

    @Test(expected = InternalServerErrorException.class)
    public void testFindCaseInternalServerError() {
        //Given
        when(component.find(Matchers.anyLong())).thenThrow(new InternalServerErrorException());

        //When
        instance.find(1l);
    }

    @Test
    public void testDeleteSuccess() {
        //Given
        long id = 1l;
        Address address = new Address();
        address.setId(id);

        //When
        instance.delete(id);
    }

    @Test(expected = NotFoundException.class)
    public void testDeleteCaseNotFound() {
        //Given
        NotFoundException notFound = new NotFoundException();
        doThrow(notFound).when(component).delete(Matchers.anyLong());

        //When
        instance.delete(1l);
    }

    @Test(expected = InternalServerErrorException.class)
    public void testDeleteCaseInternalServerError() {
        //Given
        doThrow(new InternalServerErrorException()).when(component).delete(Matchers.anyLong());

        //When
        instance.delete(1l);
    }

    @Test
    public void testCreateSuccess() throws URISyntaxException {
        //Given
        long id = 1l;
        String street = "Rua teste";
        String city = "Sao Paulo";
        String state = "SP";
        Address address = new Address();
        address.setId(id);
        address.setStreet(street);
        address.setCity(city);
        address.setState(state);
        when(component.save(Matchers.any(Address.class))).thenReturn(address);

        //When
        Address response = instance.create(request, address).getBody();

        //Then
        assertEquals(address, response);
        assertNull(address.getId());
    }

    @Test(expected = InternalServerErrorException.class)
    public void testCreateCaseInternalServerError()
                    throws URISyntaxException {
        //Given
        when(component.save(Matchers.any(Address.class))).thenThrow(new InternalServerErrorException());

        //When
        instance.create(request, new Address());
    }

    @Test
    public void testUpdateSuccess() throws URISyntaxException {
        //Given
        long id = 1l;
        Long uriId = 2l;
        String street = "Rua teste";
        String city = "Sao Paulo";
        String state = "SP";
        Address address = new Address();
        address.setId(id);
        address.setStreet(street);
        address.setCity(city);
        address.setState(state);
        when(component.save(Matchers.any(Address.class))).thenReturn(address);

        //When
        Address response = instance.update(uriId, address);

        //Then
        assertEquals(address, response);
        assertEquals(uriId, address.getId());
    }

    @Test(expected = NotFoundException.class)
    public void testUpdateCaseNotFound() throws URISyntaxException {
        //Given
        when(component.save(Matchers.any(Address.class))).thenThrow(new NotFoundException());

        //When
        instance.update(1l, new Address());
    }

    @Test(expected = InternalServerErrorException.class)
    public void testUpdateCaseInternalServerError() throws URISyntaxException {
        //Given
        when(component.save(Matchers.any(Address.class))).thenThrow(new InternalServerErrorException());

        //When
        instance.update(1l, new Address());
    }
}
