package com.GoCook.Boundaries;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import com.GoCook.Entities.User;

/**
 * Extends CrudRepository for User Entity
 * @author 300300914
 *
 */
@Component
public interface UserDAO extends CrudRepository<User, Integer> {

	@Query("SELECT u FROM User u WHERE u.active = true ORDER BY u.firstName ASC")
	Iterable<User> getUsers();

}
