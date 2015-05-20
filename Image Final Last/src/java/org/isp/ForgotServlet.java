/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.isp;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
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
@WebServlet("/forgot1")
public class ForgotServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String ques,uname;
        //ques=request.getParameter("sec_q");
        //ans=request.getParameter("answe");
        uname=request.getParameter("uname");
        User user =new User();
        try {
            user.retrieveUserdetails(uname);
        } catch (SQLException ex) {
            Logger.getLogger(ForgotServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println(uname);
        try {
            if(user.username_available(uname))
            {
                System.out.println("Invalid username");
                response.sendRedirect("forgot1.jsp");
                return;
            }else{
                 System.out.println("valid username");
                //response.sendRedirect("forgot_redir.jsp");
                user.retrieveUserdetails(uname);
                ques=user.getFpq();
                //System.out.println(ques);
                RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/forgot_redir.jsp");
                request.setAttribute("user", user);
                request.setAttribute("username", uname);
                request.setAttribute("ques", ques);
                dispatcher.forward(request,response);   
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(ForgotServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


}
