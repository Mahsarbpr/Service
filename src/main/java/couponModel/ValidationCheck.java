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
	
	Date date = new Date();
	DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	//SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	//Date date1 = dateFormat.parse(vcc.Valid);
	//Date date2 = dateFormat.parse("2010-01-31");
	//String currentdate = dateFormat.format(date);
	
	Date Cdate1= vcc.getValidTime1();
	Date Cdate2= vcc.getValidTime2();
	
	
	if(Cdate1.compareTo(date)<=0 && Cdate2.compareTo(date)>=0 ){
		System.out.println("valid coupon");
	}
	else{
		System.out.println("not valid coupon");
	}
	}
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
