package com.garage.poc.cassandra.repository;

import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.garage.poc.cassandra.domain.CassandraCustomer;
import com.garage.poc.cassandra.domain.CassandraCustomerKey;


@Repository
public interface CustomerCassandraRepository extends CassandraRepository<CassandraCustomer, CassandraCustomerKey> {
}
