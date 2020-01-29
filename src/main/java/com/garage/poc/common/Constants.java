/*
 * Copyright ⓒ [2017] KTH corp.All rights reserved.
 *
 * This is a proprietary software of KTH corp, and you may not use this file except in
 * compliance with license with license agreement with KTH corp. Any redistribution or use of this
 * software, with or without modification shall be strictly prohibited without prior written
 * approval of KTH corp, and the copyright notice above does not evidence any actual or
 * intended publication of such software.
 */

package com.garage.poc.common;

/**
 * Project Property.
 *
 * @author <a href="mailto:ky.son@kt.com"><b>손근양</b></a>
 * @version 1.0.0
 * @since 8.0
 */
public class Constants {

	/**
	 * 선착순 Consumer Group ID
	 */
	public static final String KAFKA_CONSUMER_FCFS_GROUP_ID = "HOTDEAL_FCFS_GROUP";

	/**
	 * 응모형 Consumer Group ID
	 */
	public static final String KAFKA_CONSUMER_PICK_GROUP_ID = "HOTDEAL_PICK_GROUP";

	/**
	 * 선착순 Topic
	 */
	public static final String KAFKA_TOPIC_HOTDEALS = "HOTDEALS";

	/**
	 * 선착순 Topic
	 */
	public static final String KAFKA_TOPIC_HOTDEAL_FCFS = KAFKA_TOPIC_HOTDEALS + ".FCFS";

	/**
	 * 응모형 Topic
	 */
	public static final String KAFKA_TOPIC_HOTDEAL_PICK = KAFKA_TOPIC_HOTDEALS + ".PICK";

	private Constants() throws IllegalAccessException {
		throw new IllegalAccessException("access to class not allowed.");
	}

}
