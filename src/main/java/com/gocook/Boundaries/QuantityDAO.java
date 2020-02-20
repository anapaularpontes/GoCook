package com.GoCook.Boundaries;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import com.GoCook.Entities.Quantity;

@Component
public interface QuantityDAO extends CrudRepository<Quantity, Integer> {


}
