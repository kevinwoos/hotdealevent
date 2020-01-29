package com.garage.poc.cassandra.repository;

import java.util.List;

import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.cassandra.repository.Query;
import org.springframework.stereotype.Repository;

import com.garage.poc.cassandra.domain.CassandraCustomer;
import com.garage.poc.cassandra.domain.CassandraCustomerKey;

@Repository
public interface CustomerCassandraRepository extends CassandraRepository<CassandraCustomer, CassandraCustomerKey> {
	@Query("SELECT * FROM Customer WHERE phone_no = ?0 ALLOW FILTERING")
	List<CassandraCustomer> findByPhoneNo(String phoneNo);
}
