package com.wmoreira.javadevn1.business.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.wmoreira.api.core.exception.UnprocessableEntityException;
import org.wmoreira.api.core.exception.handler.APIViolation;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class DefaultValidator implements ValidatorResolver {

    private Validator validator;

    @Autowired
    void setValidator(Validator newValidator) {
        validator = newValidator;
    }

    public <T> void validate(T obj) {
        Set<ConstraintViolation<T>> constraintViolations = validator.validate(obj);
        if (!constraintViolations.isEmpty()) {
            throw new UnprocessableEntityException(buildAPIViolations(obj, constraintViolations));
        }
    }

    <T> List<APIViolation> buildAPIViolations(T obj, Set<ConstraintViolation<T>> constraintViolations) {
        List<APIViolation> violations = new ArrayList<>();
        for (ConstraintViolation violation : constraintViolations) {

            violations.add(APIViolation.of(violation.getMessage()));
        }
        return violations;
    }
}
