package com.coupon;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
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

	//@GET
	//@Path("/CreateCoupon/{CouponID}/{Discount}")
	//@Produces({MediaType.TEXT_PLAIN, MediaType.APPLICATION_JSON})
	@POST
	@Path("CreateCoupon")
	@Produces(MediaType.TEXT_HTML)
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public void CreateCoupon(@FormParam("ID") String id,
			@FormParam("discount") String discount,
			@FormParam("type") String type,
		//	@FormParam("time1") Date time1,
		//	@FormParam("time2") Date time2,
			@Context HttpServletResponse servletResponse) throws IOException {
		Coupon C= new Coupon();
		C.setCouponID(Integer.parseInt(id));
		C.setDiscount(Integer.parseInt(discount));
		C.setCouponType(Integer.parseInt(type));
		//C.setValidTime1(time1);
		//C.setValidTime2(time2);
		Statement stmt = null;
		DB database = new DB();
		try{
		Connection c=database.connect();
		stmt=(Statement) c.createStatement();
		String query = "INSERT INTO coupon VALUES ("+C.CouponID+","+C.Discount+","+C.CouponType+")";
		stmt.executeUpdate(query);
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@GET
    @Produces({MediaType.TEXT_PLAIN, MediaType.APPLICATION_JSON})
    public String getIt() {
        return "Got it!";
    }
//////////////////////////////////////////////////////////////////////////////////////////
    @POST
    @Path("readcoupon")
    @Produces({MediaType.TEXT_PLAIN, MediaType.APPLICATION_JSON})   
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public void ReadCoupon(@FormParam ("ID") String id){
    	Statement stmt = null;
		ResultSet rs = null;
    	DB database = new DB();
    	int IC=Integer.parseInt(id);
    	try {
    		Connection c= database.connect();
			stmt = (Statement) c.createStatement();
//			String query = "SELECT Promotion FROM coupon where id="+IC;
			rs = (ResultSet) stmt.executeQuery("SELECT discount , type from coupon where id="+IC);
			while (rs.next()) {
				int discount = rs.getInt("discount");
				int type = rs.getInt("type");
				System.out.println("The discount is "+ discount+ "type is"+ type);
//				String firstName = rs.getString("first_name");
//				String lastName = rs.getString("last_name");
//				System.out.println("ID: " + id + ", First Name: " + firstName
//						+ ", Last Name: " + lastName);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	}
	//SELECT discount , type from coupon where id=12 
    ///////////////////////////////////////////////////////////////////////////////////////
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
