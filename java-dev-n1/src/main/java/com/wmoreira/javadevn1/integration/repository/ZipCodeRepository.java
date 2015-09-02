package com.wmoreira.javadevn1.integration.repository;

import com.wmoreira.javadevn1.business.entity.ZipCode;
import org.springframework.data.repository.Repository;

/**
 * @author wellington.362@gmail.com
 */

public interface ZipCodeRepository extends Repository<ZipCode, String>{
    ZipCode findById(String zipCode);
}
