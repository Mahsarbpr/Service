package couponModel;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;

import com.coupon.Coupon;

/**
 * Servlet implementation class ValidationCheck
 */
public class ValidationCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ValidationCheck() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	String vId= request.getParameter("VC");
	Date date = new Date();
	
	DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	//PrintWriter out2 = response.getWriter();
	//if(Cdate1 != null && Cdate2 != null){
	//out2.println(date);
	if (vId != null && vId!="" && date!= null){
	int iVId= Integer.parseInt(vId);
	Client client= ClientBuilder.newClient();
	Coupon vcc=client.target("http://localhost:8080/coupon-service/webapi/myresource/gettime").queryParam("var",iVId).request().get(Coupon.class);
	
	Date Cdate1= vcc.getValidTime1();
	Date Cdate2= vcc.getValidTime2();
	PrintWriter out = response.getWriter();
	//if(Cdate1 != null && Cdate2 != null){
	//out.println(date);
	//out.println(Cdate1.compareTo(date));
	//out.println(Cdate2.compareTo(date));
	if((Cdate1.compareTo(date)<=0) && (Cdate2.compareTo(date)>=0) ){
		request.setAttribute("coid", vId);
		request.setAttribute("message", "valid"); // Will be available as ${message}
		request.setAttribute("expiration", Cdate2);//dateFormat.format(Cdate2));
		request.getRequestDispatcher("validation.jsp").forward(request,response);
		
		//out.println("valid coupon");
	}
	else{
		request.setAttribute("coid", vId);
		request.setAttribute("message", "Expired"); // Will be available as ${message}
		request.setAttribute("expiration", Cdate2);
		request.getRequestDispatcher("validation.jsp").forward(request,response);
//		out.println("not valid coupon");
	}
	}
	else{
		System.out.println("errooor");
	}	
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
