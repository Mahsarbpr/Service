package com.coupon.client;
import com.coupon.*;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/home")
public class SimpleServlet extends HttpServlet
{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		String name=req.getParameter("name");  //home?name=kevin
		if(name != null){
		resp.getWriter().printf("Hello %s", name);}
		else{
		resp.getWriter().write("enter name!");}
		//resp.setContentType("text/xml");
		//resp.getWriter().write("Hello hjhWorld!");		
	}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		String ID=req.getParameter("ID");  //home?name=kevin
		if(ID != null){// && name != ""){
		Check("ID");
			resp.getWriter().printf("the promotion code is %s", ID);}
		else{
			//resp.sendRedirect("index.jsp");}
		resp.getWriter().write("Hello World!");		
	}
	}
}
