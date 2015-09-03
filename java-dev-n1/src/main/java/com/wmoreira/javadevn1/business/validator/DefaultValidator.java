package com.wmoreira.javadevn1.business.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.wmoreira.api.core.exception.UnprocessableEntityException;
import org.wmoreira.api.core.exception.handler.APIViolation;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.ArrayList;
import java.util.Set;
import java.util.List;

public class DefaultValidator {

    @Autowired
    private Validator validator;

    public <T> void validate(T obj) {
        Set<ConstraintViolation<T>> constraintViolations = validator.validate(obj);
        if (!constraintViolations.isEmpty()) {
            throw new UnprocessableEntityException(buildAPIViolations(obj, constraintViolations));
        }
    }

    void setValidator(Validator newValidator) {
        validator = newValidator;
    }

    <T> List<APIViolation> buildAPIViolations(T obj, Set<ConstraintViolation<T>> constraintViolations) {
        List<APIViolation> violations = new ArrayList<>();
        for (ConstraintViolation violation : constraintViolations) {

            violations.add(APIViolation.of(violation.getMessage()));
        }
        return violations;
    }
}
