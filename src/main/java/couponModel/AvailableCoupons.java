package couponModel;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
		// SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		// Date convertedCurrentDate = sdf.parse(SDT);
		////java.util.Date date=null;
		 //String date=null;
		if(SDT != null && SDT !=""){
		////try {
			////date=new SimpleDateFormat("yyyy-MM-dd").parse(SDT);
			//date = sdf.format(sdf.parse(SDT));
		////} catch (ParseException e1) {
			// TODO Auto-generated catch block
			//e1.printStackTrace();
			    // Show error message to enduser about the wrong format and forward back to the JSP with the form.
			////    request.setAttribute("error", "Invalid format, please enter yyyy-MM-dd");
			   //// request.getRequestDispatcher("AvailableCoupons.jsp").forward(request, response);
			    ////return;
	
		////}
		 ////System.out.println(date);
		request.setAttribute("ati1", SDT);
		 request.getRequestDispatcher("AvailableCoupons.jsp").forward(request, response); 
		 PrintWriter out = response.getWriter();
		 out.println("this is going to be available coupons table");
	////	out.println(date);
		//Date Adate = null;
		//String SAdate=null;
		//List<Coupon> CS2= new LinkedList<Coupon>();
		//if(SDT != null && SDT !=""){
			//SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			//try {
			//	Adate = (Date) format.parse(SDT);
			//} catch (ParseException e) {
				// TODO Auto-generated catch block
				//e.printStackTrace();
			//}
				//SAdate=format.format(Adate);
				//System.out.println(format.format(Adate));
		//	request.setAttribute("ati1", Adate);
		//	java.sql.Date sqlDate = new java.sql.Date();
		//	sqlDate = Adate;
		//	PreparedStatement pst = connection.prepareStatement(sql);
		//	pst.setDate(1, sqlDate);
			Client client= ClientBuilder.newClient();
			try{
			List<Coupon> CS2=client.target("http://localhost:8080/coupon-service/webapi/myresource/getcoupons2").queryParam("var1",SDT).request().get(new GenericType<List<Coupon>>(){});
	    	
	    	request.setAttribute("Avcoupons", CS2);
	        request.getRequestDispatcher("AvailableCoupons.jsp").forward(request, response);           
	    	}
	    	catch(Exception e){
	    		System.out.println("Erroooooooooor");
	    	}
	    	}
		else {
	//response.getWriter().write("enter the ID");	
			response.sendRedirect("AvailableCoupons.jsp");
	}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
