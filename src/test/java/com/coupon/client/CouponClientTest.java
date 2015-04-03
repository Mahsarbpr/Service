package com.coupon.client;

import org.junit.Test;

import com.coupon.cclient.CouponClient;

import static org.junit.Assert.*;
public class CouponClientTest {

	@Test
	public void testGetPromotion() {
		CouponClient client = new CouponClient();
		String S = client.get("10");
		System.out.println(S);
		assertNotNull(S);
	}

}
