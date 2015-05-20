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
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.dto.User;

/**
 *
 * @author hp
 */
@WebServlet("/Anchor")
public class LogoutServlet extends HttpServlet {

   
      
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
      String uname;
      uname=request.getParameter("uname");
      HttpSession session = request.getSession();
      System.out.println(uname);
      User user=new User();
            user.Logout();
//            String username=(String)session.getAttribute("username");
            session.invalidate();
            response.sendRedirect("index.jsp");
        
      
      
    }


}
