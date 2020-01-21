package com.garage.poc.cassandra.domain;

import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyClass;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;

import java.io.Serializable;
import java.time.LocalDateTime;

import static org.springframework.data.cassandra.core.cql.Ordering.DESCENDING;
import static org.springframework.data.cassandra.core.cql.PrimaryKeyType.PARTITIONED;

@PrimaryKeyClass
public class CassandraCustomerKey2 implements Serializable {

	@PrimaryKeyColumn(name = "phone_no", type = PARTITIONED)
	private String phoneNo;

	@PrimaryKeyColumn(name = "event_id", ordinal = 0)
	private String eventId;

	@Column(value = "refresh_time")
	private LocalDateTime refreshTime;

	public CassandraCustomerKey2(final String phoneNo, final String eventId, final LocalDateTime refreshTime) {
		this.phoneNo = phoneNo;
		this.eventId = eventId;
		this.refreshTime = refreshTime;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getEventId() {
		return eventId;
	}

	public void setEventId(String eventId) {
		this.eventId = eventId;
	}

	public LocalDateTime getRefreshTime() {
		return refreshTime;
	}

	public void setRefreshTime(LocalDateTime refreshTime) {
		this.refreshTime = refreshTime;
	}

	@Override
	public String toString() {
		return "CustomerKey{" + "phoneNo='" + phoneNo + '\'' + ", eventId=" + eventId + ", refreshTime=" + refreshTime
				+ '}';
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;

		CassandraCustomerKey2 customerKey = (CassandraCustomerKey2) o;

		if (phoneNo != null ? !phoneNo.equals(customerKey.phoneNo) : customerKey.phoneNo != null)
			return false;
		if (eventId != null ? !eventId.equals(customerKey.eventId) : customerKey.eventId != null)
			return false;
		return refreshTime != null ? refreshTime.equals(customerKey.refreshTime) : customerKey.refreshTime == null;
	}

	@Override
	public int hashCode() {
		int result = phoneNo != null ? phoneNo.hashCode() : 0;
		result = 31 * result + (eventId != null ? eventId.hashCode() : 0);
		result = 31 * result + (refreshTime != null ? refreshTime.hashCode() : 0);

		return result;
	}
}
