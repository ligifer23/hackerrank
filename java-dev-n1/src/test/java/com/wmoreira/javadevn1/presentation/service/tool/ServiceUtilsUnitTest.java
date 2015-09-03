package com.wmoreira.javadevn1.presentation.service.tool;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import javax.servlet.http.HttpServletRequest;

/**
 * @author wellington.362@gmail.com
 */

public class ServiceUtilsUnitTest {

    @Test
    public void testBuildLocationFromRequestSuccess1() {
        String expected = "http://localhost:8080";

        HttpServletRequest request = Mockito.mock(HttpServletRequest.class);
        Mockito.when(request.getScheme()).thenReturn("http");
        Mockito.when(request.getServerName()).thenReturn("localhost");
        Mockito.when(request.getServerPort()).thenReturn(8080);

        Assert.assertEquals(expected, ServiceUtils.buildLocationFromRequest(request));
    }

    @Test
    public void testBuildLocationFromRequestSuccess2() {
        String expected = "https://domain.org:15672";

        HttpServletRequest request = Mockito.mock(HttpServletRequest.class);
        Mockito.when(request.getScheme()).thenReturn("https");
        Mockito.when(request.getServerName()).thenReturn("domain.org");
        Mockito.when(request.getServerPort()).thenReturn(15672);

        Assert.assertEquals(expected, ServiceUtils.buildLocationFromRequest(request));
    }
}
