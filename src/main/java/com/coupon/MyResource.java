package com.coupon;


import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.xml.bind.annotation.XmlRootElement;

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
	
	@POST
	@Path("CreateCoupon")
	@Produces(MediaType.TEXT_HTML)
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public void CreateCoupon(@FormParam("ID") int CouponID, @FormParam("discount") double Discount,
			@FormParam("type") int CouponType,@FormParam("Itmnm") String Itemname,@FormParam("Itmid") int ItemID, @FormParam("Addtime1") Date ValidTime1, @FormParam("Addtime2") Date ValidTime2, 
			@Context HttpServletResponse servletResponse) throws IOException{
		
		Coupon C= new Coupon();
		C.setCouponID(CouponID);
		C.setDiscount(Discount);
		C.setCouponType(CouponType);
		C.setItemname(Itemname);
		C.setValidTime1(ValidTime1);
		C.setValidTime2(ValidTime2);
		Statement stmt = null;
    	DB database = new DB();
    	try {
    		Connection c= database.connect();
			stmt = (Statement) c.createStatement();
			String query = "INSERT INTO coupon Values ("+C.CouponID+","+C.Discount+","+C.CouponType+","+C.Itemname+","+C.ItemID+","+C.getValidTime1()+","+C.getValidTime2()+")";
			stmt.executeUpdate(query);
			//stmt.close();
    	}
    	catch(SQLException e)
    	{
    		e.printStackTrace();
    	} 
	}
	
	@GET
    @Produces({MediaType.TEXT_PLAIN, MediaType.APPLICATION_JSON})
    public String getIt() {
        return "Got it!";
    }
//////////////////////////////////////////////////////////////////////////////////////////
   // @POST
    @GET
	@Path("readcoupon/{ID}")
    @Produces({MediaType.TEXT_XML, MediaType.APPLICATION_JSON})   
  //  @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public Coupon ReadCoupon(@PathParam ("ID") String id){
    	Coupon co=new Coupon();	
    	Statement stmt = null;
		ResultSet rs = null;
    	DB database = new DB();
    	int IC=Integer.parseInt(id);
    	co.CouponID=IC;
    	try {
    		Connection c= database.connect();
			stmt = (Statement) c.createStatement();
//			String query = "SELECT Promotion FROM coupon where id="+IC;
			rs = (ResultSet) stmt.executeQuery("SELECT discount , type from coupon where id="+IC);
			while (rs.next()) {
				co.Discount = rs.getDouble("discount");
				co.CouponType = rs.getInt("type");
				//return co;
				//System.out.println("The discount is "+ discount+ "type is"+ type);
//				String firstName = rs.getString("first_name");
//				String lastName = rs.getString("last_name");
//				System.out.println("ID: " + id + ", First Name: " + firstName
//						+ ", Last Name: " + lastName);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return co;
    	}
	//SELECT discount , type from coupon where id=12 
    ///////////////////////////////////////////////////////////////////////////////////////
	@GET
    @Produces({MediaType.TEXT_PLAIN, MediaType.APPLICATION_JSON})
    @Path("{salam}")
    public String Check1(@PathParam ("salam") String salam){
    	Statement stmt = null;
		ResultSet rs = null;
    	DB database = new DB();
    	Coupon C2 = new Coupon();
    	int IC=Integer.parseInt(salam);
    	try {
    		Connection c= database.connect();
			stmt = (Statement) c.createStatement();
			String query = "SELECT Promotion FROM coupon where id="+IC;
			rs = (ResultSet) stmt.executeQuery("SELECT Promotion FROM coupon where id="+IC);
			while (rs.next()) {
				C2.Discount = Double.parseDouble(rs.getString("Promotion"));
				return "The Promotion is "+ C2.Discount;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	return "END OF THE FUNCTION";
    }
    
//////////////////////////////////////////////////////////////////////////////////////////
@GET
@Produces({MediaType.TEXT_XML, MediaType.APPLICATION_JSON})
@Path("get")
public Coupon Check2(){
	Statement stmt = null;
	ResultSet rs = null;
	DB database = new DB();
	Coupon C2 = new Coupon();
	C2.CouponID = 11;
	int IC=11;
	try {
		Connection c= database.connect();
		stmt = (Statement) c.createStatement();
		String query = "SELECT discount FROM coupon where id="+IC;
		rs = (ResultSet) stmt.executeQuery("SELECT discount , type from coupon where id="+IC);
		while (rs.next()) {
			C2.Discount = Double.parseDouble(rs.getString("Discount"));
			C2.CouponType =Integer.parseInt(rs.getString("Type"));
			return C2;
		}
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	return C2;
}

//////////////////////////////////////////////////////////////////////////////////////////
@GET
@Produces(MediaType.APPLICATION_JSON)//{MediaType.TEXT_XML,
@Path("get/{var}")
public Coupon Check3(@PathParam("var") int var ){
	Statement stmt = null;
	ResultSet rs = null;
	DB database = new DB();
	Coupon C2 = new Coupon();
	C2.CouponID = var;
	int IC=var;
	try {
		Connection c= database.connect();
		stmt = (Statement) c.createStatement();
		//String query = "SELECT Promotion FROM coupon where id="+IC;
		rs = (ResultSet) stmt.executeQuery("SELECT discount , type from coupon where id="+IC);
		while (rs.next()) {
			C2.Discount = Double.parseDouble(rs.getString("discount"));
			C2.CouponType =Integer.parseInt(rs.getString("type"));
			return C2;
		}
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	return C2;
}
///////////////////////////////////////////////////////////////////////////////////////
@GET
@Consumes(MediaType.TEXT_PLAIN)
@Produces(MediaType.APPLICATION_JSON)
@Path("get")
public Coupon Check4(@QueryParam("var") int var ){
	Statement stmt = null;
	ResultSet rs = null;
	DB database = new DB();
	Coupon C2 = new Coupon();
	C2.CouponID = var;
	int IC=var;
	try {
		Connection c= database.connect();
		stmt = (Statement) c.createStatement();
		//String query = "SELECT Promotion FROM coupon where id="+IC;
		rs = (ResultSet) stmt.executeQuery("SELECT discount , type from coupon where id="+IC);
		while (rs.next()) {
			C2.Discount = Double.parseDouble(rs.getString("discount"));
			C2.CouponType =Integer.parseInt(rs.getString("type"));
			return C2;
		}
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	return C2;
}
@GET
@Consumes(MediaType.TEXT_PLAIN)
@Produces(MediaType.APPLICATION_JSON)
@Path("gettime")
public Coupon Checktime(@QueryParam("var") int var ){
	Statement stmt = null;
	ResultSet rs = null;
	DB database = new DB();
	Coupon C2 = new Coupon();
	C2.CouponID = var;
	int IC=var;
	try {
		Connection c= database.connect();
		stmt = (Statement) c.createStatement();
		//String query = "SELECT Promotion FROM coupon where id="+IC;
		rs = (ResultSet) stmt.executeQuery("SELECT time1 , time2 from coupon where id="+IC);
		while (rs.next()) {
			C2.setValidTime1(rs.getDate("time1"));
			C2.setValidTime2(rs.getDate("time2"));
			//C2.Discount = Double.parseDouble(rs.getString("discount"));
			//C2.CouponType =Integer.parseInt(rs.getString("type"));
			return C2;
		}
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	return C2;
}
@GET
@Consumes(MediaType.TEXT_PLAIN)
@Produces(MediaType.APPLICATION_JSON)
@Path("getcoupons")
public Coupon Checkcoupons(@QueryParam("var1") int var1){
	Statement stmt = null;
	ResultSet rs = null;
	DB database = new DB();
	Coupon C2 = new Coupon();
	//C2.CouponID = var;
	//int IC=var;
	try {
		Connection c= database.connect();
		stmt = (Statement) c.createStatement();
		//String query = "SELECT Promotion FROM coupon where id="+IC;
		rs = (ResultSet) stmt.executeQuery("SELECT discount , Iname , time1 , time2 from coupon where id="+var1);
		while (rs.next()) {
			C2.Discount=rs.getDouble("discount");
			C2.Itemname=rs.getString("Iname");
			C2.setValidTime1(rs.getDate("time1"));
			C2.setValidTime2(rs.getDate("time2"));
			//C2.Discount = Double.parseDouble(rs.getString("discount"));
			//C2.CouponType =Integer.parseInt(rs.getString("type"));
			return C2;
		}
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	return C2;
}

@GET
@Consumes(MediaType.TEXT_PLAIN)
@Produces(MediaType.APPLICATION_JSON)
@Path("getcoupons2")
public List<Coupon> Checkcoupons2(@QueryParam("var1") String var1){
	Statement stmt = null;
	ResultSet rs = null;
	DB database = new DB();
	List<Coupon> C2 = new ArrayList<Coupon>();
	//SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	
	
	Date datevar1=null;
	try {
		datevar1 = new SimpleDateFormat("yyyy-MM-dd").parse(var1);
	} catch (ParseException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
	 System.out.print(datevar1);
	try {
		Connection c= database.connect();
		stmt = (Statement) c.createStatement();
		rs = (ResultSet) stmt.executeQuery("SELECT ID , discount , type , Iname , time1 , time2 from coupon where coupon.time1 <="+datevar1+"and coupon.time2 >="+datevar1);
		while (rs.next()) {
			Coupon Cpn= new Coupon();
			Cpn.setCouponID(rs.getInt("ID"));
			System.out.println(rs.getInt("ID"));
			Cpn.setDiscount(rs.getDouble("discount"));
			Cpn.setCouponType(rs.getInt("type"));
			Cpn.setItemname(rs.getString("Iname"));
			Cpn.setValidTime1(rs.getDate("time1"));
			Cpn.setValidTime2(rs.getDate("time2"));
			C2.add(Cpn);
		}	
		return C2;
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return C2;
}
}
/////////////////////////////////////////////////////////////////////////////////////////////