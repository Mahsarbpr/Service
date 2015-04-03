package couponModel;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.xml.bind.annotation.XmlRootElement;
@XmlRootElement
/**
 * Root resource (exposed at "checkcoupon" path)
 */
@Path("checkcoupon")
public class CheckCoupon {

    /**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "text/plain" media type.
     *
     * @return String that will be returned as a text/plain response.
     */
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getItt() {
        return "hello!";
    }
}








/*
package couponModel;

//import javax.websocket.server.PathParam;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.xml.bind.annotation.XmlRootElement;
@XmlRootElement

@Path("checkcoupon")
public class CheckCoupon {

//@Path("{CouponId}")
@GET
@Produces(MediaType.TEXT_PLAIN)
public String CheckC(){//(@PathParam ("CouponId") String CouponId){
	//int IC=Integer.parseInt(CouponId);
	//int num=123;
	//if (IC==num)
		return "True";
	//else 
		//return "False";
}

}
*/