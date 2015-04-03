package com.coupon.cclient;

import static org.junit.Assert.*;

import org.junit.Test;

public class CouponClientTest {

	@Test
	public void testGet() {
		CouponClient client = new CouponClient();
		String Coupon= client.get("10");
		System.out.println(Coupon);
		assertNotNull(Coupon);
	}

}
