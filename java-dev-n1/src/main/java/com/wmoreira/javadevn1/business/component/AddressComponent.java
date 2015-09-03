package com.wmoreira.javadevn1.business.component;

import com.wmoreira.javadevn1.business.entity.Address;

/**
 * @author wellington.362@gmail.com
 */

public interface AddressComponent {
    Address find(long id);
    Address save(Address address);
    void delete(long id);
}
