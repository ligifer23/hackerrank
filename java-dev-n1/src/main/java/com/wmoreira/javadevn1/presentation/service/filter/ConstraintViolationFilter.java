package com.wmoreira.javadevn1.presentation.service.filter;

import org.wmoreira.api.core.exception.UnprocessableEntityException;
import org.wmoreira.api.core.exception.handler.APIViolation;

import javax.servlet.*;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * @author wellington.362@gmail.com
 */

public class ConstraintViolationFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
	try {
	    filterChain.doFilter(servletRequest, servletResponse);
	} catch (Exception exc) {
	    if (exc.getCause() instanceof ConstraintViolationException) {
	        ConstraintViolationException cve = (ConstraintViolationException) exc.getCause();
	        throw new UnprocessableEntityException(buildAPIViolations(cve.getConstraintViolations()));
	    }
	    throw exc;
	}
    }

    List<APIViolation> buildAPIViolations(Set<ConstraintViolation<?>> constraintViolations) {
	List<APIViolation> violations = new ArrayList<>();
	for (ConstraintViolation violation : constraintViolations) {

	    violations.add(APIViolation.of(violation.getMessage()));
	}
	return violations;
    }

    @Override
    public void destroy() {

    }
}