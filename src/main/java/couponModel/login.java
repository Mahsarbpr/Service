package couponModel;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.PreparedStatement;

import db.DB;

/**
 * Servlet implementation class login
 */
public class login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public login() {
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
		String u= request.getParameter("username");
		String p= request.getParameter("password");
		Connection c=null;
		//if( u!=null && p!=null){
			try {
			PreparedStatement stmt = null;
			ResultSet rs = null;
			DB database = new DB();
			c= database.connect();
			String sql="SELECT DISTINCT username, password, UOrAOrC FROM user WHERE username=? AND password=?";
			stmt = (PreparedStatement) c.prepareStatement(sql);
			stmt.setString(1, u);
			stmt.setString(2, p);
			if(stmt.executeQuery()!=null)
			{
				rs=stmt.executeQuery();
			//rs = (ResultSet) stmt.executeQuery("SELECT DISTINCT username, password, UOrAOrC FROM user WHERE username=? AND password=?");
				if(rs.next()){
					if(rs.getString("UOrAOrC")=="U"){
						response.sendRedirect("CustomerPage.jsp");	
					}
					else{
						if(rs.getString("UOrAOrC")=="A")
							response.sendRedirect("CRUD.jsp");
						if(rs.getString("UOrAOrC")=="C")
							response.sendRedirect("UserPage.jsp");
					}
					}
			}
			else{
				response.sendRedirect("HomeCoupon.jsp");}
			}
			catch(Exception e) {
			    System.out.println("validateLogon: Error while validating password: "+e.getMessage());
			  } 
	}

}
