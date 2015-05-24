package com.coupon.cclient;
import com.coupon.*;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

public class CouponClient {

	private Client client;
	public CouponClient () {
		client = ClientBuilder.newClient();
	}
	public int get (String CouponID){
		
	WebTarget target= client.target("http://localhost:8080/coupon-service/webapi/myresource/");	
	Coupon response = target.path(CouponID).request(MediaType.TEXT_PLAIN).get(Coupon.class);
	return response.Discount;
	}
	
}
