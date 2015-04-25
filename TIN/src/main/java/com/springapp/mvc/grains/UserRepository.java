package com.springapp.mvc.grains;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * @author asmolik
 */
public interface UserRepository extends CrudRepository<User, Long>
{
    List<User> findByMail(String mail);
}
