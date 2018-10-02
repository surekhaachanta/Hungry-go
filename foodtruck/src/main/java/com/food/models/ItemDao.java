package com.food.models;

import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;

@Transactional
public interface ItemDao extends CrudRepository<Item, Long> {

    /**
     * Return the user having the passed email or null if no user is found.
     *
     * @param email the user email.
     */
   // User findByEmail(String email);

}
