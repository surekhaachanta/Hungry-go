package com.food.dao;
import com.food.models.Item;
import java.util.List;
public interface ItemDao {

    /**
     * Return the user having the passed email or null if no user is found.
     *
     * @param email the user email.
     */
	List<Item> findAllItems();


}
