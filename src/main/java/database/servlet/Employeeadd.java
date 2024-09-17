package database.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class EmployeeAdd
 */
@WebServlet("/EmployeeAdd")
public class Employeeadd extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Employeeadd() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	  int empid =Integer.parseInt(request.getParameter("empid"));
	  String empname = request.getParameter("empname");
	  String empplace= request.getParameter("empplace");
	  String empaddress = request.getParameter("empaddress");
	  String username= "root";
	  String password="root";
	  String url ="jdbc:mysql://localhost:3306/vtech";
	  PrintWriter out= response.getWriter();
	  try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection(url, username, password);
		String sql="insert into employees(empid,empname,empplace,empaddress values(?,?,?,?)";
		PreparedStatement stmt=con.prepareStatement(sql);
		stmt.setInt(1, empid);
		stmt.setString(2,empname);
		stmt.setString(3,empplace);
		stmt.setString(4,empaddress);
		int data = stmt.executeUpdate();
		if(data>0) 
		{
			out.print("record added");
		}
		else 
		{	
			out.print("Error");
		}
		
		
	} 
	  catch (ClassNotFoundException | SQLException e)
	  {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}

}
