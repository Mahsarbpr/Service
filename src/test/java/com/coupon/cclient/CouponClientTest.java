package com.coupon.cclient;
import javax.ws.rs.*;
import org.junit.Test;

import com.coupon.*;
import static org.junit.Assert.*;

public class CouponClientTest {

	@Test
	public void testGet() {
	CouponClient client = new CouponClient();
	//Coupon coupon
	int d = client.get("10");
	System.out.println(d);//coupon.Discount);
	assertNotNull(d);//coupon);
	}

}
