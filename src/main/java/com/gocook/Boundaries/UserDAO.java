package com.GoCook.Boundaries;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import com.GoCook.Entities.User;

@Component
public interface UserDAO extends CrudRepository<User, Integer> {

	@Query("SELECT u FROM User u ORDER BY u.id ASC")
	Iterable<User> getAllUsers();
}
