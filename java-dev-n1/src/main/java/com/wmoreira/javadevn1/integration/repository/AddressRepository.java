package com.wmoreira.javadevn1.integration.repository;

import com.wmoreira.javadevn1.business.entity.Address;
import com.wmoreira.javadevn1.business.entity.ZipCode;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;

/**
 * @author wellington.362@gmail.com
 */

public interface AddressRepository extends CrudRepository<Address, Long> {
}
