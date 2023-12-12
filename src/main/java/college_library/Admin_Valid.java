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
public class Admin_Valid extends HttpServlet {

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
         String username = request.getParameter("username");
	    String password = request.getParameter("password");
            boolean flag=false;
	    System.out.println("UserName "+username);
            response.setContentType("text/html");
	        PrintWriter out = response.getWriter();
 try{
     Connection con;
 
        Class.forName("com.mysql.cj.jdbc.Driver");
        con=DriverManager.getConnection("jdbc:mysql://localhost:3306/library_management","root","admin2");
        Statement stmt=con.createStatement();
        ResultSet rs=stmt.executeQuery("select * from admin");
        
 if (username == null || username.isEmpty() || password == null || password.isEmpty()) {
	        // Invalid input
	        
	        out.println("<script type=\"text/javascript\">");
	        out.println("alert('Please fill all fields');");
	        out.println("location='login.html';");
	        out.println("</script>");
	    }
	     else   {
     while(rs.next()){
	        // Invalid login
                
	       String libid=rs.getString("Admin_Id");
               String libpass=rs.getString("Admin_Password");
               if(username.equals(libid)&&password.equals(libpass))
               {
                   out.println("<script type=\"text/javascript\">");
	        out.println("alert('Login Sucess');");
	        out.println("location='admin_page.html';");
	        out.println("</script>");
                flag=true;
                break;
               }
               else{
                   flag=false;
               }
	    } 
     if(flag==false)
     {
         out.println("<script type=\"text/javascript\">");
	        out.println("alert('Login Fail');");
	        out.println("location='admin_login.html';");
	        out.println("</script>");
     }
        }
 }catch(Exception e)
 {
     System.out.println(e);
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
