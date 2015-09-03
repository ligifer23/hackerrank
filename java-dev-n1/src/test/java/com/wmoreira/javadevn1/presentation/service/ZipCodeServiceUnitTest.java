package com.wmoreira.javadevn1.presentation.service;

import com.wmoreira.javadevn1.business.component.ZipCodeComponent;
import com.wmoreira.javadevn1.business.entity.ZipCode;
import com.wmoreira.javadevn1.presentation.service.error.APIError;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Matchers;
import org.mockito.Mockito;
import org.wmoreira.api.core.exception.BadRequestException;
import org.wmoreira.api.core.exception.InternalServerErrorException;
import org.wmoreira.api.core.exception.NotFoundException;

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
        Mockito.when(component.find(zip)).thenReturn(zipCode);

        //When
        ZipCode response = instance.find(zip);

        //Then
        Assert.assertEquals(zipCode, response);
    }

    @Test(expected = NotFoundException.class)
    public void testFindByIdCaseNotFound() {
        //Given
        String excMessage = "not found...";
        NotFoundException notFound = new NotFoundException(excMessage);
        APIError expectedError = APIError.of(notFound.getStatus(), excMessage);

        Mockito.when(component.find(Matchers.anyString())).thenThrow(notFound);

        //When
        instance.find("01254600");
    }

    @Test(expected = BadRequestException.class)
    public void testFindByIdCaseBadRequest() {
        //Given
        String excMessage = "bad request...";
        BadRequestException badRequest = new BadRequestException(excMessage);
        APIError expectedError = APIError.of(badRequest.getStatus(), excMessage);

        Mockito.when(component.find(Matchers.anyString())).thenThrow(badRequest);

        //When
        instance.find("01254600");
    }

    @Test(expected = InternalServerErrorException.class)
    public void testFindByIdCaseInternalServerError() {
        //Given
        Mockito.when(component.find(Matchers.anyString())).thenThrow(new InternalServerErrorException());

        //When
        instance.find("01254600");
    }
}
