package com.wmoreira.javadevn1.presentation.service.filter;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.wmoreira.api.core.exception.UnprocessableEntityException;
import org.wmoreira.api.core.exception.handler.APIViolation;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.mockito.Mockito.*;

/**
 * @author wellington.362@gmail.com
 */

public class ConstraintViolationFilterUnitTest {

    ConstraintViolationFilter instance = new ConstraintViolationFilter();
    FilterChain filterChain = mock(FilterChain.class);

    @Before public void setUp() {

    }

    @Test
    public void testDoFilterHasViolations()
                    throws IOException, ServletException {
        //Given
        String[] messages = {"violation1", "violation2", "violation3", "violation4", "violation5"};
        Set<ConstraintViolation<?>> violations = buildConstraintViolations(messages);

        ConstraintViolationException exc = new ConstraintViolationException(violations);

        doThrow(exc).when(filterChain).doFilter(any(), any());

        //When
        try {
            instance.doFilter(null, null, filterChain);
        } catch (ConstraintViolationException cve) {
            //Then
            Assert.assertEquals(violations.size(), cve.getConstraintViolations().size());
        }
    }

    @Test
    public void testDoFilterHasNoViolations()
                    throws IOException, ServletException {
        //When
        instance.doFilter(null, null, filterChain);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testDoFilterUnexpectedException()
                    throws IOException, ServletException {
        //Given
        doThrow(IllegalArgumentException.class).when(filterChain).doFilter(any(), any());

        //When
        instance.doFilter(null, null, filterChain);
    }

    @Test
    public void testBuildAPIViolationsSuccess() {
        //Given
        String[] messages = {"violation1", "violation2", "violation3", "violation4", "violation5"};
        Set<ConstraintViolation<?>> violations = buildConstraintViolations(messages);

        //When
        List<APIViolation> violationList = instance.buildAPIViolations(violations);

        //Then
        Assert.assertEquals(violations.size(), violationList.size());

        for (String message : messages) {
            Assert.assertTrue(violationList
                                    .stream()
                                    .anyMatch(violation -> message.equals(violation.getMessage())));
        }
    }

    Set<ConstraintViolation<?>> buildConstraintViolations(String[] messages) {

        Set<ConstraintViolation<?>> violations = new HashSet<>();

        for (String message : messages) {
            ConstraintViolation violation = mock(ConstraintViolation.class);
            when(violation.getMessage()).thenReturn(message);
            violations.add(violation);
        }
        return violations;
    }
}
