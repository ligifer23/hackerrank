package com.wmoreira.javadevn1.business.component;

import com.wmoreira.javadevn1.business.entity.Address;

/**
 * @author wellington.362@gmail.com
 */

public interface AdressComponent {
    Address find(Long id);
    Address create(Address address);
    void delete(long id);
    void update(Address address);
}
