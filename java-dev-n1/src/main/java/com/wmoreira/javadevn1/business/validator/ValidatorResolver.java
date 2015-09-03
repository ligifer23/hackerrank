package com.wmoreira.javadevn1.business.validator;

/**
 * @author wellington.362@gmail.com
 */

public interface ValidatorResolver {
    <T> void validate(T obj);
}
