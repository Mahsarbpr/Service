package couponModel;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.GenericType;

import com.coupon.Coupon;

/**
 * Servlet implementation class AvailableCoupons
 */
public class AvailableCoupons extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AvailableCoupons() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String SDT=request.getParameter("DT");
		String SDAC=request.getParameter("DAC");
		String SCT=request.getParameter("CT");
		String SINC=request.getParameter("INC");
		Client client= ClientBuilder.newClient();
		
		if(SDT != null && SDT !="" && SDAC != null && SDAC !="" && SCT != null && SCT !="" && SINC != null && SINC !="" ){
			request.setAttribute("ati1", SDT);
			request.getRequestDispatcher("AvailableCoupons.jsp").forward(request, response); 
			PrintWriter out = response.getWriter();
			out.println("this is going to be available coupons table");
		//Client client= ClientBuilder.newClient();
			try{
				List<Coupon> CS2=client.target("http://localhost:8080/coupon-service/webapi/myresource/getcoupons2").queryParam("var1",SDT).queryParam("var2", SDAC).queryParam("var3", SCT).queryParam("var4", SINC).request().get(new GenericType<List<Coupon>>(){});    	
				//System.out.println( CS2.iterator().next().CouponID); 
				if(CS2.iterator().next()!=null){
					request.setAttribute("Avcoupons", CS2);
					request.getRequestDispatcher("AvailableCoupons2.jsp").forward(request, response);
	  //      return;
				}
				else
					System.out.println("No available coupon");
	    		}
			catch(Exception e){
				System.out.println("Erroooooooooor"+e);
	    		}
	    	} 
		if((SDT == null || SDT =="") && SDAC != null && SDAC !="" && SCT != null && SCT !="" && SINC != null && SINC !="" ){
			//request.setAttribute("ati1", SDT);
			//request.getRequestDispatcher("AvailableCoupons.jsp").forward(request, response); 
			PrintWriter out = response.getWriter();
			out.println("this is going to be available coupons table");
		//	Client client= ClientBuilder.newClient();
			try{
				List<Coupon> CS2=client.target("http://localhost:8080/coupon-service/webapi/myresource/getcoupons3").queryParam("var2", SDAC).queryParam("var3", SCT).queryParam("var4", SINC).request().get(new GenericType<List<Coupon>>(){});    	
				//System.out.println( CS2.iterator().next().CouponID); 
				if(CS2.iterator().next()!=null){
					request.setAttribute("Avcoupons", CS2);
					request.getRequestDispatcher("AvailableCoupons2.jsp").forward(request, response);
		  //      return;
					}
				else
					System.out.println("No available coupon");
		    	}
		    catch(Exception e){
		    	System.out.println("Erroooooooooor"+e);
		    	}
		}
		if(SDT != null && SDT !="" && (SDAC == null || SDAC =="") && SCT != null && SCT !="" && SINC != null && SINC !="" )
		{
			try{
				List<Coupon> CS2=client.target("http://localhost:8080/coupon-service/webapi/myresource/getcoupons4").queryParam("var1",SDT).queryParam("var3", SCT).queryParam("var4", SINC).request().get(new GenericType<List<Coupon>>(){});    	
				//System.out.println( CS2.iterator().next().CouponID); 
				if(CS2.iterator().next()!=null){
					request.setAttribute("Avcoupons", CS2);
					request.getRequestDispatcher("AvailableCoupons2.jsp").forward(request, response);
	  //      return;
				}
				else
					System.out.println("No available coupon");
	    		}
			catch(Exception e){
				System.out.println("Erroooooooooor"+e);
	    		}	
		}
		if(SDT != null && SDT !="" && SDAC != null && SDAC !="" && (SCT == null || SCT =="") && SINC != null && SINC !="" )
		{
			try{
				List<Coupon> CS2=client.target("http://localhost:8080/coupon-service/webapi/myresource/getcoupons5").queryParam("var1",SDT).queryParam("var2", SDAC).queryParam("var4", SINC).request().get(new GenericType<List<Coupon>>(){});    	
				//System.out.println( CS2.iterator().next().CouponID); 
				if(CS2.iterator().next()!=null){
					request.setAttribute("Avcoupons", CS2);
					request.getRequestDispatcher("AvailableCoupons2.jsp").forward(request, response);
	  //      return;
				}
				else
					System.out.println("No available coupon");
	    		}
			catch(Exception e){
				System.out.println("Erroooooooooor"+e);
	    		}

		}
		if(SDT != null && SDT !="" && SDAC != null && SDAC !="" && SCT != null && SCT !="" && (SINC == null || SINC ==""))
		{
			try{
				List<Coupon> CS2=client.target("http://localhost:8080/coupon-service/webapi/myresource/getcoupons6").queryParam("var1",SDT).queryParam("var2", SDAC).queryParam("var3", SCT).request().get(new GenericType<List<Coupon>>(){});    	
				//System.out.println( CS2.iterator().next().CouponID); 
				if(CS2.iterator().next()!=null){
					request.setAttribute("Avcoupons", CS2);
					request.getRequestDispatcher("AvailableCoupons2.jsp").forward(request, response);
	  //      return;
				}
				else
					System.out.println("No available coupon");
	    		}
			catch(Exception e){
				System.out.println("Erroooooooooor"+e);
	    		}

		}
		if((SDT == null || SDT =="") && (SDAC == null || SDAC =="") && SCT != null && SCT !="" && SINC != null && SINC !="" )
		{
			try{
				List<Coupon> CS2=client.target("http://localhost:8080/coupon-service/webapi/myresource/getcoupons7").queryParam("var3", SCT).queryParam("var4", SINC).request().get(new GenericType<List<Coupon>>(){});    	
				//System.out.println( CS2.iterator().next().CouponID); 
				if(CS2.iterator().next()!=null){
					request.setAttribute("Avcoupons", CS2);
					request.getRequestDispatcher("AvailableCoupons2.jsp").forward(request, response);
	  //      return;
				}
				else
					System.out.println("No available coupon");
	    		}
			catch(Exception e){
				System.out.println("Erroooooooooor"+e);
	    		}

		}
		if((SDT == null || SDT =="") && SDAC != null && SDAC !="" && (SCT == null || SCT =="") && SINC != null && SINC !="" )
		{
			try{
				List<Coupon> CS2=client.target("http://localhost:8080/coupon-service/webapi/myresource/getcoupons8").queryParam("var2", SDAC).queryParam("var4", SINC).request().get(new GenericType<List<Coupon>>(){});    	
				//System.out.println( CS2.iterator().next().CouponID); 
				if(CS2.iterator().next()!=null){
					request.setAttribute("Avcoupons", CS2);
					request.getRequestDispatcher("AvailableCoupons2.jsp").forward(request, response);
	  //      return;
				}
				else
					System.out.println("No available coupon");
	    		}
			catch(Exception e){
				System.out.println("Erroooooooooor"+e);
	    		}

		}
		if((SDT == null || SDT =="") && SDAC != null && SDAC !="" && SCT != null && SCT !="" && (SINC == null || SINC =="")){try{
			List<Coupon> CS2=client.target("http://localhost:8080/coupon-service/webapi/myresource/getcoupons9").queryParam("var2", SDAC).queryParam("var3", SCT).request().get(new GenericType<List<Coupon>>(){});    	
			//System.out.println( CS2.iterator().next().CouponID); 
			if(CS2.iterator().next()!=null){
				request.setAttribute("Avcoupons", CS2);
				request.getRequestDispatcher("AvailableCoupons2.jsp").forward(request, response);
  //      return;
			}
			else
				System.out.println("No available coupon");
    		}
		catch(Exception e){
			System.out.println("Erroooooooooor"+e);
    		}
}
		if(SDT != null && SDT !="" && (SDAC == null || SDAC =="") && (SCT == null || SCT =="") && SINC != null && SINC !="" )
		{
			try{
				List<Coupon> CS2=client.target("http://localhost:8080/coupon-service/webapi/myresource/getcoupons10").queryParam("var1",SDT).queryParam("var4", SINC).request().get(new GenericType<List<Coupon>>(){});    	
				//System.out.println( CS2.iterator().next().CouponID); 
				if(CS2.iterator().next()!=null){
					request.setAttribute("Avcoupons", CS2);
					request.getRequestDispatcher("AvailableCoupons2.jsp").forward(request, response);
	  //      return;
				}
				else
					System.out.println("No available coupon");
	    		}
			catch(Exception e){
				System.out.println("Erroooooooooor"+e);
	    		}

		}
		if(SDT != null && SDT !="" && (SDAC == null || SDAC =="") && SCT != null && SCT !="" && (SINC == null || SINC ==""))
		{
			try{
				List<Coupon> CS2=client.target("http://localhost:8080/coupon-service/webapi/myresource/getcoupons11").queryParam("var1",SDT).queryParam("var3", SCT).request().get(new GenericType<List<Coupon>>(){});    	
				//System.out.println( CS2.iterator().next().CouponID); 
				if(CS2.iterator().next()!=null){
					request.setAttribute("Avcoupons", CS2);
					request.getRequestDispatcher("AvailableCoupons2.jsp").forward(request, response);
	  //      return;
				}
				else
					System.out.println("No available coupon");
	    		}
			catch(Exception e){
				System.out.println("Erroooooooooor"+e);
	    		}
		}
		if(SDT != null && SDT !="" && SDAC != null && SDAC !="" && (SCT == null || SCT =="") && (SINC == null || SINC ==""))
		{
			try{
				List<Coupon> CS2=client.target("http://localhost:8080/coupon-service/webapi/myresource/getcoupons12").queryParam("var1",SDT).queryParam("var2", SDAC).request().get(new GenericType<List<Coupon>>(){});    	
				//System.out.println( CS2.iterator().next().CouponID); 
				if(CS2.iterator().next()!=null){
					request.setAttribute("Avcoupons", CS2);
					request.getRequestDispatcher("AvailableCoupons2.jsp").forward(request, response);
	  //      return;
				}
				else
					System.out.println("No available coupon");
	    		}
			catch(Exception e){
				System.out.println("Erroooooooooor"+e);
	    		}
	
		}
		if((SDT == null || SDT =="") && (SDAC == null || SDAC =="") && (SCT == null || SCT =="") && SINC != null && SINC !="")
		{
			try{
				List<Coupon> CS2=client.target("http://localhost:8080/coupon-service/webapi/myresource/getcoupons13").queryParam("var4", SINC).request().get(new GenericType<List<Coupon>>(){});    	
				//System.out.println( CS2.iterator().next().CouponID); 
				if(CS2.iterator().next()!=null){
					request.setAttribute("Avcoupons", CS2);
					request.getRequestDispatcher("AvailableCoupons2.jsp").forward(request, response);
	  //      return;
				}
				else
					System.out.println("No available coupon");
	    		}
			catch(Exception e){
				System.out.println("Erroooooooooor"+e);
	    		}
		}
		if((SDT == null || SDT =="") && (SDAC == null || SDAC =="") && SCT != null && SCT !="" && (SINC == null || SINC ==""))
		{
			try{
				List<Coupon> CS2=client.target("http://localhost:8080/coupon-service/webapi/myresource/getcoupons14").queryParam("var3", SCT).request().get(new GenericType<List<Coupon>>(){});    	
				//System.out.println( CS2.iterator().next().CouponID); 
				if(CS2.iterator().next()!=null){
					request.setAttribute("Avcoupons", CS2);
					request.getRequestDispatcher("AvailableCoupons2.jsp").forward(request, response);
	  //      return;
				}
				else
					System.out.println("No available coupon");
	    		}
			catch(Exception e){
				System.out.println("Erroooooooooor"+e);
	    		}
		}
		if((SDT == null || SDT =="") && SDAC != null && SDAC !="" && (SCT == null || SCT =="") && (SINC == null || SINC ==""))
		{
			try{
				List<Coupon> CS2=client.target("http://localhost:8080/coupon-service/webapi/myresource/getcoupons15").queryParam("var2", SDAC).request().get(new GenericType<List<Coupon>>(){});    	
				//System.out.println( CS2.iterator().next().CouponID); 
				if(CS2.iterator().next()!=null){
					request.setAttribute("Avcoupons", CS2);
					request.getRequestDispatcher("AvailableCoupons2.jsp").forward(request, response);
	  //      return;
				}
				else
					System.out.println("No available coupon");
	    		}
			catch(Exception e){
				System.out.println("Erroooooooooor"+e);
	    		}

		}
		if(SDT != null && SDT !="" && (SDAC == null || SDAC =="") && (SCT == null || SCT =="") && (SINC == null || SINC ==""))
		{
			try{
				List<Coupon> CS2=client.target("http://localhost:8080/coupon-service/webapi/myresource/getcoupons16").queryParam("var1",SDT).request().get(new GenericType<List<Coupon>>(){});    	
				//System.out.println( CS2.iterator().next().CouponID); 
				if(CS2.iterator().next()!=null){
					request.setAttribute("Avcoupons", CS2);
					request.getRequestDispatcher("AvailableCoupons2.jsp").forward(request, response);
	  //      return;
				}
				else
					System.out.println("No available coupon");
	    		}
			catch(Exception e){
				System.out.println("Erroooooooooor"+e);
	    		}
		}
		//we have to not let the customer to have the option for not entering any information, because if so, all the coupons will be shown!! :|
		else
		{
			
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
