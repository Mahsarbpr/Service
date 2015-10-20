package couponModel;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.GenericType;

import com.coupon.Coupon;

/**
 * Servlet implementation class ComputePrice
 */
public class ComputePrice extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ComputePrice() {
        super();
        // TODO Auto-generated constructor stub
    }
//private FindBestDiscount
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
   // @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	String Sitem= request.getParameter("itm1");
	String Sitem2= request.getParameter("itm2");
	String Spitem1= request.getParameter("pitm1");
	String Spitem2= request.getParameter("pitm2");
	
	if(Sitem != null && Sitem !="" && Sitem2 != null && Sitem2 !="" && Spitem1 != null && Spitem1 !="" && Spitem2 != null && Spitem2 !=""){
		int Ipitem1= Integer.parseInt(Spitem1);
		int Ipitem2= Integer.parseInt(Spitem2);
		
		try{
			PrintWriter out = response.getWriter();//chi kar mikone?
		Client client= ClientBuilder.newClient();
		List<Coupon> cc=client.target("http://localhost:8080/coupon-service/webapi/myresource/FindCouponForItem").queryParam("var",Sitem).request().get(new GenericType<List<Coupon>>(){});
		List<Coupon> cc2=client.target("http://localhost:8080/coupon-service/webapi/myresource/FindCouponForItem").queryParam("var",Sitem2).request().get(new GenericType<List<Coupon>>(){});
		
		Double DM1=null;
		int i=0;
		List<Coupon> cc1=cc;
		while(cc1.iterator().hasNext()){
			if(cc1.get(i).getDiscount()<DM1){
				DM1=cc1.get(i).getDiscount();
				i++;
			}
		}
		out.println(DM1);
		
		double totalprice= Ipitem1*cc.get(0).Discount + Ipitem2*cc2.get(0).Discount;
		String Stp= Double.toString(totalprice);
		request.setAttribute("itm1", Sitem);
		request.setAttribute("pitm1", Ipitem1);
		request.setAttribute("itm2", Sitem2);
		request.setAttribute("pitm2", Ipitem2);
		request.setAttribute("tp", Stp);
		request.getRequestDispatcher("Cart1.jsp").forward(request, response); 
		}
		finally{
			System.out.println("blablablaaaa");
		}
		}   
	else{
		response.sendRedirect("Cart1.jsp");
	}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
