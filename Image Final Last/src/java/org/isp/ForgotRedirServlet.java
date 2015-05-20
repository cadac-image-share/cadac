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
import org.dto.User;

/**
 *
 * @author hp
 */
@WebServlet("/forgotRedir")
public class ForgotRedirServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String uname,ans,pword,cpword;
        uname=request.getParameter("uname");
        ans=request.getParameter("ans");
        User user=new User();
        try {
            System.out.println(ans);
            System.out.println(uname);
            if(user.forgotpass(uname, ans))
            {
                System.out.println("forgot");
                pword=request.getParameter("pswd");
                cpword=request.getParameter("cpswd");
                if(pword.compareTo(cpword)==0)
                {
                    pword=user.encrypt(pword,"VIGENERECIPHER");
                    user.setPword(pword);
                    response.sendRedirect("index.jsp");
                }else
                    response.sendRedirect("success.jsp");
            }
            else
            {
                response.sendRedirect("forgot1.jsp");
            }
        } catch (SQLException ex) {
            Logger.getLogger(ForgotRedirServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

}
