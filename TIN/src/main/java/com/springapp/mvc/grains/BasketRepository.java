package com.springapp.mvc.grains;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * @author asmolik
 */
public interface BasketRepository extends CrudRepository<Basket, Long> {
    List<Basket> findByUser(User user);
}
