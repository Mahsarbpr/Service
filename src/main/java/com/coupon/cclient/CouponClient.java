package com.coupon.cclient;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;

public class CouponClient {

	private Client client;
	public CouponClient () {
		client = ClientBuilder.newClient();
	}
	public String get (String CouponID){
		
	WebTarget target= client.target("http://localhost:8080/coupon-service/webapi/");	
	String response = target.path("coupons/"+ CouponID).request().get(String.class);
	return response;
	}
	
}
