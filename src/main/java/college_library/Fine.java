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
public class Fine extends HttpServlet {

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
             throws ServletException, IOException
    { PrintWriter out = response.getWriter();
    
                 boolean a=false;
        try  {
        String search=request.getParameter("search");
        
        
       
         out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Fine</title>");  
             out.println("</head>");
            out.println("<body>");
       
        
            Connection con;
 
        Class.forName("com.mysql.cj.jdbc.Driver");
        con=DriverManager.getConnection("jdbc:mysql://localhost:3306/library_management","root","admin2");
        Statement stmt=con.createStatement();
        Statement stmt1=con.createStatement();
        Statement stmt2=con.createStatement();
        Statement stmt3=con.createStatement();
        ResultSet rs=stmt1.executeQuery("select * from issued_book where Stud_Id='"+search+"';");
        ResultSet rss=stmt.executeQuery("select * from Student where Stud_Id='"+search+"';");
        ResultSet rss2=stmt3.executeQuery("select * from fine where Stud_Id='"+search+"';");
        while(rss.next())
        {
            String id=rss.getString("Stud_ID");
            String name=rss.getString("Stud_Name");
            String Branch=rss.getString("Stud_Branch");
                out.println("<a style='float:right; color: white;\n" +
"  padding: 14px 25px; background-color:black;\n" +
"  text-align: center;\n" +
"  text-decoration: none;\n" +
"  display: inline-block;' href='stud_fine.html'>Back</a>");
                out.println("<div style='background-color:red;color:white;'>");
                out.println("<h1>Name :"+name+"</h1>");
                out.println("<h1>Student ID :"+id+"</h1>");
                out.println("<h1>Branch :"+Branch+"</h1>");
                out.println("</div>");
             }  
        
         out.println("<table border=1 width=50% height=50%>");  
             out.println("<tr><th>Book ID</th><th>Issued Date</th><th>Return Date</th><th>Fine Amount</th><th>Book Title</th><tr>");  
             while (rs.next()&& rss2.next()) 
             {  
                 
                 String n = rs.getString("Book_Id");  
                Date id = rs.getDate("Issued_Date");  
                 Date rd=rs.getDate("Return_Date");
                 int fa=rss2.getInt("Fine_Payment");
                 out.println("<tr><td>" + n + "</td><td>" + id + "</td><td>" +rd + "</td><td>"+fa+"</td>");   
                 ResultSet rs2=stmt2.executeQuery("select * from books where Book_Id='"+n+"';");
                 while(rs2.next())
                 {
                     String bt=rs2.getString("Book_Title");
                     out.println("<td>"+bt+"</td></tr>");
                 }
                 
             }  
             out.println("</table>");
       
             
             
            
              
            /* TODO output your page here. You may use following sample code. */
                     
            out.println("</html></body>");
          
        }
          
        catch(Exception e)
        {
            System.out.println("Exception .... :"+e);
        }
        
       
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
        processRequest(request, response);
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
