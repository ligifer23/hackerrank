package com.wmoreira.javadevn1.business.component.impl;

import com.wmoreira.javadevn1.business.component.ZipCodeComponent;
import com.wmoreira.javadevn1.business.entity.Address;
import com.wmoreira.javadevn1.business.entity.ZipCode;
import com.wmoreira.javadevn1.integration.repository.AddressRepository;
import org.junit.Before;
import org.junit.Test;
import org.wmoreira.api.core.exception.NotFoundException;
import org.wmoreira.api.core.exception.UnprocessableEntityException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * @author wellington.362@gmail.com
 */

public class AddressComponentImplUnitTest {

    AddressComponentImpl instance          = new AddressComponentImpl();
    ZipCodeComponent     zipCodeComponent = mock(ZipCodeComponent.class);
    AddressRepository    addressRepository = mock(AddressRepository.class);

    @Before
    public void setUp() {
        instance.setZipCodeComponent(zipCodeComponent);
        instance.setAddressRepository(addressRepository);
    }

    @Test
    public void testFindSuccess() {
        //Given
        Long id = 1l;
        Address address = new Address();
        address.setId(id);

        when(addressRepository.findOne(id)).thenReturn(address);

        //When
        Address response = instance.find(id);

        //Then
        assertEquals(address, response);
    }

    @Test(expected = NotFoundException.class)
    public void testFindErrorCaseNotFound() {
        //Given
        Long id = 1l;

        when(addressRepository.findOne(id)).thenReturn(null);

        //When
        instance.find(id);
    }

    @Test
    public void testCreateSuccess() {
        //Given
        String zip = "00000000";
        String addressZip = "00000010";
        ZipCode zipCode = new ZipCode();
        zipCode.setId(zip);
        Address address = new Address();
        address.setZipCode(addressZip);

        when(zipCodeComponent.lookup(addressZip)).thenReturn(zipCode);
        when(addressRepository.save(address)).thenReturn(address);

        //When
        Address response = instance.save(address);

        //Then
        assertNotNull(response);
        assertEquals(zip, response.getZipCode());
    }

    @Test(expected = UnprocessableEntityException.class)
    public void testCreateErrorCaseZipNotFound() {
        //Given

        String addressZip = "00000010";
        Address address = new Address();
        address.setZipCode(addressZip);

        when(zipCodeComponent.lookup(addressZip)).thenThrow(NotFoundException.class);
        when(addressRepository.save(address)).thenReturn(address);

        //When
        instance.save(address);
    }

    @Test
    public void testUpdateSuccess() {
        //Given
        String zip = "00000000";
        String addressZip = "00000010";
        ZipCode zipCode = new ZipCode();
        zipCode.setId(zip);
        Long id = 1l;
        Address address = new Address();
        address.setZipCode(addressZip);
        address.setId(id);

        when(addressRepository.findOne(1l)).thenReturn(address);
        when(zipCodeComponent.lookup(addressZip)).thenReturn(zipCode);
        when(addressRepository.save(address)).thenReturn(address);

        //When
        Address response = instance.save(address);

        //Then
        assertNotNull(response);
        assertEquals(zip, response.getZipCode());
    }

    @Test(expected = NotFoundException.class)
    public void testUpdateErrorCaseNotFound() {
        //Given
        Address address = new Address();
        address.setId(1l);

        when(addressRepository.save(address)).thenReturn(address);

        //When
        instance.save(address);
    }

    @Test(expected = UnprocessableEntityException.class)
    public void testUpdateErrorCaseZipNotFound() {
        //Given

        String addressZip = "00000010";
        Long id = 1l;
        Address address = new Address();
        address.setZipCode(addressZip);
        address.setId(id);

        when(addressRepository.findOne(id)).thenReturn(address);
        when(zipCodeComponent.lookup(addressZip)).thenThrow(NotFoundException.class);
        when(addressRepository.save(address)).thenReturn(address);

        //When
        instance.save(address);
    }
}
