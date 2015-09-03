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

@WebServlet("/computeprice2")
public class ComputePrice2 extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	response.getWriter().write("Hellooooo");
	String Sitem= request.getParameter("itm1");
	String Sitem2= request.getParameter("itm2");
	String Spitem1= request.getParameter("pitm1");
	String Spitem2= request.getParameter("pitm2");
	
	if(Sitem != null && Sitem !="" && Sitem2 != null && Sitem2 !="" && Spitem1 != null && Spitem1 !="" && Spitem2 != null && Spitem2 !=""){
		int Iitem= Integer.parseInt(Sitem); //error handling if ID is null, how to?
		int Iitem2= Integer.parseInt(Sitem2);
		int Ipitem1= Integer.parseInt(Spitem1);
		int Ipitem2= Integer.parseInt(Spitem2);

		PrintWriter out = response.getWriter();//chi kar mikone?
		Client client= ClientBuilder.newClient();
		Coupon cc=client.target("http://localhost:8080/coupon-service/webapi/myresource/get").queryParam("var",Iitem).request().get(Coupon.class);
		Coupon cc2=client.target("http://localhost:8080/coupon-service/webapi/myresource/get").queryParam("var",Iitem2).request().get(Coupon.class);
		
		int totalprice= Ipitem1*cc.Discount + Ipitem2*cc2.Discount;
		String Stp= Integer.toString(totalprice);
		out.println("hellloooooo");
		//	request.setAttribute("tp", Stp);
	//	request.getRequestDispatcher("Cart1.jsp").forward(request, response); 
				}   
	else{
		response.sendRedirect("Cart1.jsp");
	}
}
