package com.wmoreira.javadevn1.business.validator;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Matchers;
import org.mockito.Mockito;
import org.wmoreira.api.core.exception.UnprocessableEntityException;
import org.wmoreira.api.core.exception.handler.APIViolation;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import javax.validation.constraints.NotNull;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.List;

/**
 * @author wellington.362@gmail.com
 */

public class DefaultValidatorUnitTest {

    DefaultValidator instance = new DefaultValidator();
    Validator validator = Mockito.mock(Validator.class);

    @Test
    public void testValidateNoViolations() {
        //Given
        instance.setValidator(validator);

        Mockito.when(validator.validate(Matchers.any())).thenReturn(new HashSet<ConstraintViolation<Object>>());

        //When
        instance.validate(new Object());
    }

    @Test
    public void testValidateHasViolations() {
        //Given
        instance.setValidator(validator);
        HashSet<ConstraintViolation<Object>> violations = new HashSet<>();
        violations.add(Mockito.mock(ConstraintViolation.class));

        Mockito.when(validator.validate(Matchers.any())).thenReturn(violations);

        try {
            //When
            instance.validate(new Object());
        } catch (UnprocessableEntityException exc) {
            //Then
            Assert.assertEquals(1, exc.getViolations().size());
        }
    }

    @Test
    public void testBuildAPIViolationsSuccess() {
        //Given
        String[] messages = {"violation1", "violation2", "violation3", "violation4", "violation5"};
        Set<ConstraintViolation<Object>> violations = new HashSet<>();

        for (String message : messages) {
            ConstraintViolation violation = Mockito.mock(ConstraintViolation.class);
            Mockito.when(violation.getMessage()).thenReturn(message);
            violations.add(violation);
        }

        //When
        List<APIViolation> violationList = instance.buildAPIViolations(new Object(), violations);

        //Then
        Assert.assertEquals(messages.length, violationList.size());

        for (String message : messages) {
            Assert.assertTrue(violationList
                                    .stream()
                                    .anyMatch(violation -> message.equals(violation.getMessage())));
        }
    }
}
