/*
 * package com.garage.poc.controller;
 * 
 * import java.time.LocalDateTime;
 * 
 * import org.springframework.web.bind.annotation.GetMapping; import
 * org.springframework.web.bind.annotation.RequestParam; import
 * org.springframework.web.bind.annotation.RestController;
 * 
 * import com.garage.poc.mongo.domain.MongoCustomer; import
 * com.garage.poc.mongo.domain.MongoCustomerKey; import
 * com.garage.poc.mongo.repository.CustomerMongoRepository;
 * 
 * import lombok.RequiredArgsConstructor; import lombok.extern.slf4j.Slf4j;
 * 
 * @Slf4j
 * 
 * @RequiredArgsConstructor
 * 
 * @RestController public class MongoController {
 * 
 * private final CustomerMongoRepository mongoRepository;
 * 
 * //
 * http://localhost:8080/mongo/save?eventId=20010900&phoneNo=01012345679&name=
 * ABC
 * 
 * @GetMapping("/mongo/save") public String save(@RequestParam String eventId,
 * 
 * @RequestParam String phoneNo,
 * 
 * @RequestParam String name) {
 * 
 * MongoCustomerKey key = new MongoCustomerKey(phoneNo, eventId);
 * 
 * log.info(">>>>>>> [save] Customer{" + phoneNo + " eventId=" + eventId +
 * " name=" + name + '}');
 * 
 * 
 * 
 * log.info(">>>>>>> [save] key=" + key); final MongoCustomer cust = new
 * MongoCustomer(key, name, LocalDateTime.now());
 * log.info(">>>>>>> [save] cust=" + cust); MongoCustomer c =
 * mongoRepository.save(cust);
 * 
 * log.info(">>>>>>> [save] cust={}", cust); log.info(">>>>>>> [save] cust={}",
 * c);
 * 
 * return cust.toString(); //return cust; }
 * 
 * // http://localhost:8080/cache/get?eventId=20010900&phoneNo=01012345678
 * 
 * @GetMapping("/mongo/get") public String get(@RequestParam String
 * phoneNo, @RequestParam String eventId) {
 * 
 * log.info(">>>>>>> [get] Customer{" + phoneNo + " eventId=" + eventId);
 * 
 * final MongoCustomerKey key = new MongoCustomerKey(phoneNo, eventId);
 * 
 * log.info(">>>>>>> [get] key=" + key);
 * 
 * final MongoCustomer cust = mongoRepository.findById(key).get();
 * 
 * log.info(">>>>>>> [get] cust={}", cust);
 * 
 * 
 * return cust.toString(); //return cust; } }
 * 
 * // :set nohints // config set stop-writes-on-bgsave-error no
 */