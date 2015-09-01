package com.wmoreira.javadevn1.presentation.service;

import com.wmoreira.javadevn1.business.component.ZipCodeComponent;
import com.wmoreira.javadevn1.business.entity.ZipCode;
import com.wmoreira.javadevn1.exception.BadRequestException;
import com.wmoreira.javadevn1.exception.InternalServerErrorException;
import com.wmoreira.javadevn1.exception.NotFoundException;
import com.wmoreira.javadevn1.presentation.service.error.APIError;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Matchers;
import org.mockito.Mockito;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

/**
 * @author wellington.362@gmail.com
 */

public class ZipCodeServiceUnitTest {

    ZipCodeService   instance  = new ZipCodeService();
    ZipCodeComponent component = Mockito.mock(ZipCodeComponent.class);

    @Before
    public void setUp() {
	instance.setZipCodeComponent(component);
    }

    @Test
    public void testFindByIdSuccess() {
        //Given
        String zip = "01254600";
        ZipCode zipCode = new ZipCode("01254600","street", "district", "city", "state");
        Mockito.when(component.findById(zip)).thenReturn(zipCode);

        //When
        ResponseEntity<ZipCode> response = instance.findById(zip);

        //Then
        Assert.assertEquals(HttpStatus.OK, response.getStatusCode());
        Assert.assertEquals(zipCode, response.getBody());
    }

    @Test
    public void testFindByIdCaseNotFound() {
        //Given
        String excMessage = "not found...";
        NotFoundException notFound = new NotFoundException(excMessage);
        APIError expectedError = APIError.of(notFound.getStatus(), excMessage);

        Mockito.when(component.findById(Matchers.anyString())).thenThrow(notFound);

        //When
        ResponseEntity<APIError> response = instance.findById("01254600");

        //Then
        Assert.assertEquals(HttpStatus.valueOf(notFound.getStatus()), response.getStatusCode());
        Assert.assertEquals(expectedError, response.getBody());
    }

    @Test
    public void testFindByIdCaseBadRequest() {
        //Given
        String excMessage = "bad request...";
        BadRequestException badRequest = new BadRequestException(excMessage);
        APIError expectedError = APIError.of(badRequest.getStatus(), excMessage);

        Mockito.when(component.findById(Matchers.anyString())).thenThrow(badRequest);

        //When
        ResponseEntity<APIError> response = instance.findById("01254600");

        //Then
        Assert.assertEquals(HttpStatus.valueOf(badRequest.getStatus()), response.getStatusCode());
        Assert.assertEquals(expectedError, response.getBody());
    }

    @Test
    public void testFindByIdCaseKnownInternalServerError() {
        //Given
        String excMessage = "internal server error...";
        InternalServerErrorException internalServerError = new InternalServerErrorException(excMessage);
        APIError expectedError = APIError.of(internalServerError.getStatus(), excMessage);

        Mockito.when(component.findById(Matchers.anyString())).thenThrow(internalServerError);

        //When
        ResponseEntity<APIError> response = instance.findById("01254600");

        //Then
        Assert.assertEquals(HttpStatus.valueOf(internalServerError.getStatus()), response.getStatusCode());
        Assert.assertEquals(expectedError, response.getBody());
    }

    @Test
    public void testFindByIdCaseUnknownInternalServerError() {
        //Given
        InternalServerErrorException internalServerErrorException = new InternalServerErrorException();
        APIError expectedError = APIError.of(internalServerErrorException.getStatus());

        Mockito.when(component.findById(Matchers.anyString())).thenThrow(new InternalServerErrorException());

        //When
        ResponseEntity<APIError> response = instance.findById("01254600");

        //Then
        Assert.assertEquals(HttpStatus.valueOf(internalServerErrorException.getStatus()), response.getStatusCode());
        Assert.assertEquals(expectedError, response.getBody());
    }
}
