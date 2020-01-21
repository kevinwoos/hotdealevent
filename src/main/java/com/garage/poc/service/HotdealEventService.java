package com.garage.poc.service;

import com.garage.poc.redis.domain.Customer;
import com.garage.poc.redis.repository.CustomerRedisRepository;

public interface HotdealEventService {
	public boolean existCustomer(CustomerRedisRepository redis, String key);
	public Customer getCustomer(CustomerRedisRepository redis, String key);
	public Customer upsertCustomer(CustomerRedisRepository redis, String key, String value);
	public boolean insertCustomer(CustomerRedisRepository redis, String key, String value);
}
