/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package college_library;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.regex.Pattern;
import java.sql.*;

/**
 *
 * @author Chaitanya
 */
public class Registration extends HttpServlet {
    
 

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */


    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */


    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Connection con;
        try{
        Class.forName("com.mysql.cj.jdbc.Driver");
        con=DriverManager.getConnection("jdbc:mysql://localhost:3306/library_management","root","admin2");
         
        
        String email = request.getParameter("email");
		String remail = request.getParameter("remail");
		String prnno = request.getParameter("prn");
		String rprnno = request.getParameter("rprn");
		String name = request.getParameter("Name");
		String mobno = request.getParameter("mobno");
		String street = request.getParameter("address");
		String state = request.getParameter("state");
                String branch=request.getParameter("branch");
		String gender = request.getParameter("gender");
		String bd = request.getParameter("birthdate");
		String bm = request.getParameter("birthmonth");
		String by = request.getParameter("birthyear");
		String Nationality = request.getParameter("Nationality");
		String disability = request.getParameter("disability");
                String terms[]=new String[10];
                String year;
		terms = request.getParameterValues("terms");
                year = request.getParameter("year");
                String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."+
                            "[a-zA-Z0-9_+&*-]+)*@" +
                            "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
                            "A-Z]{2,7}$";
                String address=street+" ,"+state;
                Pattern pat = Pattern.compile(emailRegex);
		 response.setContentType("text/html");
	        PrintWriter out = response.getWriter();
                System.out.print(terms);
//		 if(terms[0]=="")
//		 {
//			 out.println("<script type=\"text/javascript\">");
//		        out.println("alert('Please Accept Terms and Condition');");
//		        out.println("location='registration.html';");
//		        out.println("</script>");
//			 
//		 }
//                 else{
//                     if(name=="")
//		 {
//			 out.println("<script type=\"text/javascript\">");
//		        out.println("alert('Please Accept Terms and Condition');");
//		        out.println("location='registration.html';");
//		        out.println("</script>");
//			 
//		 }
//                    if(email==null&&pat.matcher(email).matches()){
//                          out.println("<script type=\"text/javascript\">");
//		        out.println("alert('Please Accept Terms and Condition');");
//		        out.println("location='registration.html';");
//		        out.println("</script>");
//                         
//                     }
//                     
//                 }
System.out.print("Name  "+name);
PreparedStatement ps=con.prepareStatement("insert into student values(?,?,?,?,?,?,?,?,?)");
ps.setString(1, prnno);
ps.setString(2,name);
ps.setString(3, mobno);
ps.setString(4,email);
ps.setString(5, branch);
ps.setString(6, address);
ps.setString(7,year);
ps.setString(8, gender);
ps.setInt(9, 0);
int i=ps.executeUpdate();
if(i>=1)
{
    out.println("<script type=\"text/javascript\">");
		        out.println("alert('Registration Sucess');");
		        out.println("location='registration.html';");
		        out.println("</script>");
}
else
{
     out.println("<script type=\"text/javascript\">");
		        out.println("alert('Registration Fails');");
		        out.println("location='registration.html';");
		        out.println("</script>");
}
}
        catch(Exception e)
        {
            System.out.println("Exception "+e);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
