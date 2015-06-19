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
@WebServlet("/bla")
public class ReadCouponServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int ID= Integer.parseInt(request.getParameter("ID"));
		PrintWriter out = response.getWriter();//chi kar mikone?
		Client client= ClientBuilder.newClient();
		Coupon cc=client.target("http://localhost:8080/coupon-service/webapi/myresource/get").queryParam("var",ID).request().get(Coupon.class);
		out.println (
                  "<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" +" +
                      "http://www.w3.org/TR/html4/loose.dtd\">\n" +
                  "<html> \n" +
                    "<head> \n" +
                      "<meta http-equiv=\"Content-Type\" content=\"text/html; " +
                        "charset=ISO-8859-1\"> \n" +
                      "<title> Crunchify.com JSP Servlet Example  </title> \n" +
                    "</head> \n" +
                    "<body> <div align='center'> \n" +
                      "<style= \"font-size=\"12px\" color='black'\"" + "\">" +
                        "Username: " + cc.CouponID + " <br> " + "Discount: "+cc.Discount+"<br>"+"Type: "+cc.CouponType+
                    "</font></body> \n" +
                  "</html>" 
                );      
        }
}
