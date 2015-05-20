/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.isp;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.dto.User;

/**
 *
 * @author hp
 */
@WebServlet("/register")
public class RegisterServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("mskjhfkjds");
      String userId, fname, lname, pword, email, dob, fpq , fpa, m ,gender,cpword;
      userId=request.getParameter("uname");
      fname=request.getParameter("fname");
      lname=request.getParameter("lname");
      pword=request.getParameter("pswd");
        cpword=request.getParameter("cpswd");
      email=request.getParameter("email");
      dob=request.getParameter("bdate");
      fpq=request.getParameter("sq");
      fpa=request.getParameter("ans");
      gender="M";
      m=request.getParameter("mob_no");
      User user=new User();
        try {
            if(!user.username_available(userId))
            {
                System.out.println("dfgdf");
                response.sendRedirect("UserExist.jsp");
                return;
            }
            else{
                    if(cpword.compareTo(pword)!=0)
                    {
                        System.out.println("YOu are ");
                        response.sendRedirect("Failed.jsp");
                    }
                    else
                    {
                        pword=user.encrypt(pword,"VIGENERECIPHER");
                        user.signup_nomobile(userId,fname, lname, pword, email, gender, dob, fpq , fpa);
                                                System.out.println("Method to chala11");

                        if(m!=null)
                            user.setM(m);
                        System.out.println("Method to chala");
                        response.sendRedirect("index.jsp");
                        System.out.println("Jadoo");
                    return;
                    }                
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(RegisterServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
