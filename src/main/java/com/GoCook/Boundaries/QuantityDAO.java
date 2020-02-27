package com.GoCook.Boundaries;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import com.GoCook.Entities.Quantity;

@Component
public interface QuantityDAO extends CrudRepository<Quantity, Integer> {

	@Query("SELECT q FROM Quantity q WHERE q.active = true")
	Iterable<Quantity> getQuantities();
}
