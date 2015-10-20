package couponModel;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

import com.coupon.Coupon;

/**
 * Servlet implementation class AddSingleCoupon
 */
public class AddSingleCoupon extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddSingleCoupon() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String s1=request.getParameter("AddID");
		String s2=request.getParameter("Adddiscount");
		String s3=request.getParameter("Addtype");
		String s4=request.getParameter("AddItmnm");
		String s5=request.getParameter("AddItmid");
		String s6=request.getParameter("Addtime1");
		String s7=request.getParameter("Addtime2");
		
		if(s1 != null && s1 !="" && s2 != null && s2 !="" && s3 != null && s3 !="" && s4 != null && s4 !="" && s5 != null && s5 !="" && s6 != null && s6 !="" && s7 != null && s7 !="" ){
			int is1=Integer.parseInt(s1);
			Double ds2=Double.parseDouble(s2);
			int is3=Integer.parseInt(s3);
			int is5=Integer.parseInt(s5);

			Date datevar=null;
			Date datevarp=null;
			java.sql.Date datevar1=null;
			java.sql.Date datevar2=null;
			
			try {
				System.out.println(datevar+"this this this");
				datevar = new SimpleDateFormat("yyyy-MM-dd").parse(s6);
				datevarp=new SimpleDateFormat("yyyy-MM-dd").parse(s7);
				datevar1 = new java.sql.Date(datevar.getTime());
				datevar2 = new java.sql.Date(datevarp.getTime());
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				System.out.println("date date date error");
				e1.printStackTrace();
			}
			Coupon C=new Coupon();
			C.CouponID=is1;
			C.Discount=ds2;
			C.CouponType=is3;
			C.setItemname(s4);
			C.setItemID(is5);
			C.setValidTime1(datevar1);
			C.setValidTime2(datevar2);
			
			//int IID= Integer.parseInt(request.getParameter("ID")); //error handling if ID is null, how to?
		//	PrintWriter out = response.getWriter();//chi kar mikone?
			Client client= ClientBuilder.newClient();
			WebTarget target = client.target("http://localhost:8080/coupon-service/webapi/myresource/CreateCoupons");//.queryParam("varID",s1).queryParam("vardiscount",s2).queryParam("vartype",s3).queryParam("varItmnm",s4).queryParam("varItmid",s5).queryParam("vartime1",s6).queryParam("vartime2",s7);
			Response response2 = target.request().//.buildPost(Entity.entity(C, MediaType.APPLICATION_XML)).invoke();
			System.out.println(response.getLocation().getPath());
			//client.target("http://localhost:8080/coupon-service/webapi/myresource/CreateCoupons").queryParam("varID",s1).queryParam("vardiscount",s2).queryParam("vartype",s3).queryParam("varItmnm",s4).queryParam("varItmid",s5).queryParam("vartime1",s6).queryParam("vartime2",s7).request().post(null);

		}
	}

}
