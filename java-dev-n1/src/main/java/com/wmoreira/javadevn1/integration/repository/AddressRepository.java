package com.wmoreira.javadevn1.integration.repository;

import com.wmoreira.javadevn1.business.entity.Address;
import org.springframework.data.repository.CrudRepository;

/**
 * @author wellington.362@gmail.com
 */

public interface AddressRepository extends CrudRepository<Address, Long> {
}
