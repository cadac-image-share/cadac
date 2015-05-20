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
import javax.servlet.http.HttpSession;
import org.dto.User;
import org.dto.Follows;

/**
 *
 * @author Dell-
 */
@WebServlet("/followUser")
public class FollowUserServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        System.out.println("Follow user servlet entered ");
        String username;
        User tempUser = new User();
        Follows fobj = new Follows();
        
        //Extracting the username of current logged in user
        HttpSession session = request.getSession();
        String currentUsername = (String) session.getAttribute("username");
        try {
            tempUser.retrieveUserdetails(currentUsername);
        } catch (SQLException ex) {
            Logger.getLogger(FollowUserServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        //Extracting the username of the user to be followed
        username = request.getParameter("followUser");
        System.out.println("Received user - " + username);
        
        try {
            //Makes logged in user to follow received user
            fobj.afollowsb(tempUser,username);
        } catch (SQLException ex) {
            Logger.getLogger(FollowUserServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            //Check if the users are being followed
            if(fobj.checkafollowsb(currentUsername, username))
            {
                System.out.println(currentUsername + " IS following " + username);
            }
            else
            {
                System.out.println(currentUsername + " is NOT following " + username);
                        }
        } catch (SQLException ex) {
            Logger.getLogger(FollowUserServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        //Set tempname attribute of session 
        session = request.getSession();
        session.setAttribute("tempname",username);
        
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/nowFollowing.jsp");
        dispatcher.forward(request,response);
    }


}
