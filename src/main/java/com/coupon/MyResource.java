package com.coupon;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.xml.bind.annotation.XmlRootElement;

import com.sun.glass.ui.Application;

import java.io.*;

import db.DB;
@XmlRootElement
/**
 * Root resource (exposed at "myresource" path)
 */
@Path("myresource")
public class MyResource {

    /**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "text/plain" media type.
     *
     * @return String that will be returned as a text/plain response.
     */

	@GET
	@Path("/CreateCoupon/{CouponID}/{Discount}")
	@Produces({MediaType.TEXT_PLAIN, MediaType.APPLICATION_JSON})
	public String CreateCoupon(@PathParam("CouponID") int CouponID, @PathParam("Discount") int Discount){
		Coupon C= new Coupon();
		C.setCouponID(CouponID);
		C.setDiscount(Discount);
		
		Statement stmt = null;
		DB database = new DB();
		try{
		Connection c=database.connect();
		stmt=(Statement) c.createStatement();
		String query = "INSERT INTO coupon VALUES ("+C.CouponID+","+C.Discount+")";
		stmt.executeUpdate(query);
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	@GET
    @Produces({MediaType.TEXT_PLAIN, MediaType.APPLICATION_JSON})
    public String getIt() {
        return "Got it!";
    }
    
    @GET
    @Produces({MediaType.TEXT_PLAIN, MediaType.APPLICATION_JSON})
    @Path("{salam}")
    public String Check(@PathParam ("salam") String salam){
    	Statement stmt = null;
		ResultSet rs = null;
    	DB database = new DB();
    	int IC=Integer.parseInt(salam);
    	try {
    		Connection c= database.connect();
			stmt = (Statement) c.createStatement();
			String query = "SELECT Promotion FROM coupon where id="+IC;
			rs = (ResultSet) stmt.executeQuery("SELECT Promotion FROM coupon where id="+IC);
			while (rs.next()) {
				String Promotion = rs.getString("Promotion");
				return "The Promotion is "+ Promotion;
//				String firstName = rs.getString("first_name");
//				String lastName = rs.getString("last_name");
//				System.out.println("ID: " + id + ", First Name: " + firstName
//						+ ", Last Name: " + lastName);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	return "END OF THE FUNCTION";
//    	 	int num=123;
//    	if (IC==num)
//    		return "True";
//    	else 
//    		return "False";
    }
    
}
