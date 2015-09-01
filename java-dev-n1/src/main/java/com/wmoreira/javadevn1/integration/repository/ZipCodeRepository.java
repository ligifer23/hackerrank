package com.wmoreira.javadevn1.integration.repository;

import com.wmoreira.javadevn1.business.entity.ZipCode;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

/**
 * @author wellington.362@gmail.com
 */

public interface ZipCodeRepository extends Repository<ZipCode, String>{
    @Query(value = "SELECT * FROM vw_zipcode WHERE id = ?", nativeQuery = true)
    ZipCode findById(String zipCode);
}
