package com.garage.poc.redis.repository;

import org.springframework.data.repository.CrudRepository;

import com.garage.poc.redis.domain.Customer;

public interface CustomerRedisRepository extends CrudRepository<Customer, String> {
}
