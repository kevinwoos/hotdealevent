/*
 * package com.garage.poc.mongo.domain;
 * 
 * import java.io.Serializable;
 * 
 * import javax.persistence.Embeddable;
 * 
 * import lombok.AllArgsConstructor; import lombok.Data;
 * 
 * @Data
 * 
 * @Embeddable
 * 
 * @AllArgsConstructor public class MongoCustomerKey implements Serializable {
 * 
 * private String phoneNo; private String eventId;
 * 
 * 
 * public MongoCustomerKey(final String phoneNo, final String eventId) {
 * this.phoneNo = phoneNo; this.eventId = eventId; }
 * 
 * public String getPhoneNo() { return phoneNo; }
 * 
 * public void setPhoneNo(String phoneNo) { this.phoneNo = phoneNo; }
 * 
 * public String getEventId() { return eventId; }
 * 
 * public void setEventId(String eventId) { this.eventId = eventId; }
 * 
 * @Override public String toString() { return "CustomerKey{" + "phoneNo='" +
 * phoneNo + '\'' + ", eventId=" + eventId + '}'; }
 * 
 * @Override public boolean equals(Object o) { if (this == o) return true; if (o
 * == null || getClass() != o.getClass()) return false;
 * 
 * MongoCustomerKey customerKey = (MongoCustomerKey) o;
 * 
 * if (phoneNo != null ? !phoneNo.equals(customerKey.phoneNo) :
 * customerKey.phoneNo != null) return false; return eventId != null ?
 * !eventId.equals(customerKey.eventId) : customerKey.eventId != null; }
 * 
 * @Override public int hashCode() { int result = phoneNo != null ?
 * phoneNo.hashCode() : 0; result = 31 * result + (eventId != null ?
 * eventId.hashCode() : 0);
 * 
 * return result; }
 * 
 * }
 */