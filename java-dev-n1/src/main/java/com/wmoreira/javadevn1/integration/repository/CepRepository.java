package com.wmoreira.javadevn1.integration.repository;

import com.wmoreira.javadevn1.business.entity.Cep;

/**
 * Created by welingtonmoreira on 31/08/15.
 */
public interface CepRepository {
    Cep findById(int id);
}
