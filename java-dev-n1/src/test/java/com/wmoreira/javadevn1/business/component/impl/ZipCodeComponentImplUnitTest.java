package com.wmoreira.javadevn1.business.component.impl;

import com.wmoreira.javadevn1.business.entity.ZipCode;
import com.wmoreira.javadevn1.exception.NotFoundException;
import com.wmoreira.javadevn1.integration.repository.ZipCodeRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

/**
 * @author wellington.362@gmail.com
 */

public class ZipCodeComponentImplUnitTest {

    ZipCodeComponentImpl instance   = new ZipCodeComponentImpl();
    ZipCodeRepository    repository = Mockito.mock(ZipCodeRepository.class);

    @Before
    public void setUp() {
	instance.setZipCodeRepository(repository);
    }

    @Test
    public void testFindByIdSuccess() {
        //Given
        String zip = "12345678";
        ZipCode zipCode = new ZipCode(zip, "", "", "", "");

        //When
        Mockito.when(repository.findById(zip)).thenReturn(zipCode);

        //Then
        Assert.assertEquals(zipCode, instance.findById(zip));
    }

    @Test(expected = NotFoundException.class)
    public void testFindByIdCaseNotFound() {
        //Given
        String zip = "12345678";

        //Then
        instance.findById(zip);
    }

    @Test
    public void testFindByIdSuccessCaseLookup1() {
	//Given
        String lookupZip = "12345670";
	String zip = "12345678";
	ZipCode zipCode = new ZipCode(lookupZip, "", "", "", "");

	//When
	Mockito.when(repository.findById(lookupZip)).thenReturn(zipCode);

	//Then
	Assert.assertEquals(zipCode, instance.findById(zip));
    }

    @Test
    public void testFindByIdSuccessCaseLookup2() {
	//Given
	String lookupZip = "12345600";
	String zip = "12345678";
	ZipCode zipCode = new ZipCode(lookupZip, "", "", "", "");

	//When
	Mockito.when(repository.findById(lookupZip)).thenReturn(zipCode);

	//Then
	Assert.assertEquals(zipCode, instance.findById(zip));
    }

    @Test
    public void testFindByIdSuccessCaseLookup3() {
	//Given
	String lookupZip = "12345000";
	String zip = "12345678";
	ZipCode zipCode = new ZipCode(lookupZip, "", "", "", "");

	//When
	Mockito.when(repository.findById(lookupZip)).thenReturn(zipCode);

	//Then
	Assert.assertEquals(zipCode, instance.findById(zip));
    }

    @Test
    public void testFindByIdSuccessCaseLookup4() {
	//Given
	String lookupZip = "12340000";
	String zip = "12345678";
	ZipCode zipCode = new ZipCode(lookupZip, "", "", "", "");

	//When
	Mockito.when(repository.findById(lookupZip)).thenReturn(zipCode);

	//Then
	Assert.assertEquals(zipCode, instance.findById(zip));
    }

    @Test
    public void testFindByIdSuccessCaseLookup5() {
	//Given
	String lookupZip = "12300000";
	String zip = "12345678";
	ZipCode zipCode = new ZipCode(lookupZip, "", "", "", "");

	//When
	Mockito.when(repository.findById(lookupZip)).thenReturn(zipCode);

	//Then
	Assert.assertEquals(zipCode, instance.findById(zip));
    }

    @Test
    public void testFindByIdSuccessCaseLookup6() {
	//Given
	String lookupZip = "12000000";
	String zip = "12345678";
	ZipCode zipCode = new ZipCode(lookupZip, "", "", "", "");

	//When
	Mockito.when(repository.findById(lookupZip)).thenReturn(zipCode);

	//Then
	Assert.assertEquals(zipCode, instance.findById(zip));
    }

    @Test
    public void testFindByIdSuccessCaseLookup7() {
	//Given
	String lookupZip = "10000000";
	String zip = "12345678";
	ZipCode zipCode = new ZipCode(lookupZip, "", "", "", "");

	//When
	Mockito.when(repository.findById(lookupZip)).thenReturn(zipCode);

	//Then
	Assert.assertEquals(zipCode, instance.findById(zip));
    }

    @Test
    public void testFindByIdSuccessCaseLookup8() {
	//Given
	String lookupZip = "00000000";
	String zip = "12345678";
	ZipCode zipCode = new ZipCode(lookupZip, "", "", "", "");

	//When
	Mockito.when(repository.findById(lookupZip)).thenReturn(zipCode);

	//Then
	Assert.assertEquals(zipCode, instance.findById(zip));
    }
}
