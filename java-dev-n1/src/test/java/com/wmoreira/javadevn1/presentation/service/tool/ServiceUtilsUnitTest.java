package com.wmoreira.javadevn1.presentation.service.tool;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import javax.servlet.http.HttpServletRequest;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

/**
 * @author wellington.362@gmail.com
 */

public class ServiceUtilsUnitTest {

    @Test
    public void testBuildLocationFromRequestSuccess1() {
        String expected = "http://localhost:8080";

        HttpServletRequest request = mock(HttpServletRequest.class);
        when(request.getScheme()).thenReturn("http");
        when(request.getServerName()).thenReturn("localhost");
        when(request.getServerPort()).thenReturn(8080);

        assertEquals(expected, ServiceUtils.buildLocationFromRequest(request));
    }

    @Test
    public void testBuildLocationFromRequestSuccess2() {
        String expected = "https://domain.org:15672";

        HttpServletRequest request = mock(HttpServletRequest.class);
        when(request.getScheme()).thenReturn("https");
        when(request.getServerName()).thenReturn("domain.org");
        when(request.getServerPort()).thenReturn(15672);

        assertEquals(expected, ServiceUtils.buildLocationFromRequest(request));
    }
}
