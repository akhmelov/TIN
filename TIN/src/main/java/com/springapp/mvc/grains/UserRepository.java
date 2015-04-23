package com.springapp.mvc.grains;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author asmolik
 */
@Repository
public interface UserRepository extends CrudRepository<User, Long>
{
    List<User> findByMail(String mail);
}
