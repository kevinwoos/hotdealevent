/*
 * package com.garage.poc.mongo.domain;
 * 
 * import java.io.Serializable; import java.time.LocalDateTime;
 * 
 * import javax.persistence.EmbeddedId; import javax.persistence.Entity;
 * 
 * import org.springframework.data.cassandra.core.mapping.Table;
 * 
 * import lombok.AllArgsConstructor; import lombok.Data;
 * 
 * @Data
 * 
 * @AllArgsConstructor
 * 
 * @Entity
 * 
 * @Table("customer") public class MongoCustomer implements Serializable {
 * 
 * @EmbeddedId private MongoCustomerKey key;
 * 
 * private String name;
 * 
 * private LocalDateTime refreshTime;
 * 
 * 
 * public MongoCustomer(MongoCustomerKey key, String name, LocalDateTime
 * refreshTime) { this.key = key; this.name = name; this.refreshTime =
 * refreshTime; }
 * 
 * 
 * 
 * @Override public String toString() { return "Customer{" + "key=" + key +
 * ", name=" + name + ", refreshTime=" + refreshTime + '}'; }
 * 
 * }
 */