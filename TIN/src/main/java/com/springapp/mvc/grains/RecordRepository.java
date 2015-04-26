package com.springapp.mvc.grains;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * @author asmolik
 */
public interface RecordRepository extends CrudRepository<Record, Long> {
    List<Record> findByBasket(Basket basket);
}
