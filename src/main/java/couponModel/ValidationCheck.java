package couponModel;

import java.io.IOException;
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
	if (vId != null && vId!=""){
	int iVId= Integer.parseInt(vId);
	Client client= ClientBuilder.newClient();
	Coupon vcc=client.target("http://localhost:8080/coupon-service/webapi/myresource/get").queryParam("var",iVId).request().get(Coupon.class);
	DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	Date date = new Date();
	
	//SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	Date date1 = dateFormat.parse("2009-12-31");
	Date date2 = dateFormat.parse("2010-01-31");

	System.out.println(sdf.format(date1));
	System.out.println(sdf.format(date2));
	
	if(date1.compareTo(date2)>0){
		System.out.println("Date1 is after Date2");
	}else if(date1.compareTo(date2)<0){
		System.out.println("Date1 is before Date2");
	}else if(date1.compareTo(date2)==0){
		System.out.println("Date1 is equal to Date2");
	}else{
		System.out.println("How to get here?");
	System.out.println(dateFormat.format(date));
			}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
