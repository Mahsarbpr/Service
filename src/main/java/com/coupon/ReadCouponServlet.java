package com.coupon;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
//@WebServlet("/bla")
public class ReadCouponServlet extends HttpServlet{

	//@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String SID=request.getParameter("ID");
		if(SID != null && SID !=""){
		int IID= Integer.parseInt(request.getParameter("ID")); //error handling if ID is null, how to?
	//	PrintWriter out = response.getWriter();//chi kar mikone?
		Client client= ClientBuilder.newClient();
		Coupon cc=client.target("http://localhost:8080/coupon-service/webapi/myresource/getcoupons").queryParam("var1",IID).request().get(Coupon.class);
		request.setAttribute("id", SID);
//		request.setAttribute("message", "valid"); // Will be available as ${message}
		request.setAttribute("in",cc.Itemname);
		request.setAttribute("ti1", cc.getValidTime1());//dateFormat.format(Cdate2));
		request.setAttribute("ti2", cc.getValidTime2());
		request.getRequestDispatcher("ReadCoupon.jsp").forward(request,response);   
        
	}
		else {
	//response.getWriter().write("enter the ID");	
			response.sendRedirect("ReadCoupon.jsp");
	}
	}
	}
