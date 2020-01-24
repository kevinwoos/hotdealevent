package com.garage.poc.kafka.domain;

import java.time.LocalDateTime;

public class KafkaCustomer {

    public String getEventId() {
		return eventId;
	}
	public void setEventId(String eventId) {
		this.eventId = eventId;
	}
	public String getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public LocalDateTime getRefreshTime() {
		return refreshTime;
	}
	public void setRefreshTime(LocalDateTime refreshTime) {
		this.refreshTime = refreshTime;
	}
	private String eventId; // YYMMDD[00]
    private String phoneNo;    
    private String name;
    private LocalDateTime refreshTime;

    public KafkaCustomer() {
    	super();
    }
    public KafkaCustomer(String eventId, String phoneNo, String name, LocalDateTime refreshTime) {
    	super();
        this.eventId = eventId;
        this.phoneNo = phoneNo;
        this.name = name;
        this.refreshTime = refreshTime;
    }
    
    @Override
    public String toString() {
      return "KafkaCustomer [eventId=" + eventId + ", phoneNo=" + phoneNo + ", name=" + name + ", refreshTime=" + refreshTime + "]";
    }
}
