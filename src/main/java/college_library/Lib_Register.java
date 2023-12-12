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
import java.sql.*;

/**
 *
 * @author Chaitanya
 */
public class Lib_Register extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
      
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

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
       String lname=request.getParameter("lname");
       String ledu=request.getParameter("ledu");
       String laddress=request.getParameter("laddress");
       String lmob=request.getParameter("lmob");
       String lpos=request.getParameter("lpos");
       String lpassword=request.getParameter("lpassword");
       String AlphaNumericStr = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvxyz0123456789";
       PrintWriter out=response.getWriter();

 // creating a StringBuffer size of AlphaNumericStr

 StringBuilder s = new StringBuilder(6);

 int i;

 for ( i=0; i<6; i++) {

   //generating a random number using math.random()

   int ch = (int)(AlphaNumericStr.length() * Math.random());

   //adding Random character one by one at the end of s

   s.append(AlphaNumericStr.charAt(ch));

  }

    String lid= s.toString();
    Connection con;
        try{
        Class.forName("com.mysql.cj.jdbc.Driver");
        con=DriverManager.getConnection("jdbc:mysql://localhost:3306/library_management","root","admin2");
        PreparedStatement ps=con.prepareStatement("insert into librarian values(?,?,?,?,?,?,?)");
        ps.setString(1, lid);
ps.setString(2,lname);
ps.setString(3, ledu);
ps.setString(4,laddress);
ps.setString(5, lmob);
ps.setString(6, lpos);
ps.setString(7,lpassword);
        int ii=ps.executeUpdate();
if(ii>=1)
{
    out.println("<script type=\"text/javascript\">");
		        out.println("alert('Registration Sucess');");
		        out.println("location='lib_reg.html';");
		        out.println("</script>");
}
else
{
     out.println("<script type=\"text/javascript\">");
		        out.println("alert('Registration Fails');");
		        out.println("location='lib_reg.html';");
		        out.println("</script>");
}
        }
        catch(Exception e)
        {
            System.out.print(e);
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
