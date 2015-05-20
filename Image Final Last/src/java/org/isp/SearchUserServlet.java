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
@WebServlet("/searchUser")
public class SearchUserServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
           String username; //Username entered in the form
           User tempUser = new User();
           Follows fobj = new Follows();
           
           //Extracting username from the form
           username = request.getParameter("username");
           System.out.println("Username entered is "+ username);
           
           //Extracting the username of current logged in user
           HttpSession session = request.getSession();
           String currentUsername = (String) session.getAttribute("username");
           
           System.out.println("Current logged in user is - "+currentUsername);
           
           //Set the attributes of the request to include the entered username
           request.setAttribute("enteredUser",username);
           
           //Set the tempname attribute of session
            session = request.getSession();
            session.setAttribute("tempname",username);
           
        try {
            // username_available returns false when user is foun in database
            // Check if the entered username is in database or not
            if(tempUser.username_available(username) == false)
            {
                System.out.println("The entered username EXISTS");
                
                try {
                    //Extracting the information of the user from the database
                    tempUser.retrieveUserdetails(username);
                } catch (SQLException ex) {
                    Logger.getLogger(SearchUserServlet.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                
                
                try {
                    //Check whether the logged in user is already following the entered user
                    
                    if( fobj.checkafollowsb( currentUsername,tempUser.getUsername() ) )
                    {
                        //If following
                        System.out.println("The logged in user is already following the entered user");
                        
                        //Redirect to a page that shows that the given user is being followed by the logged in user
                        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/alreadyFollows.jsp");
                        dispatcher.forward(request,response);
                    }
                    // If not following
                    else
                    {
                        //Redirect to a page giving option to the user to follow the entered user
                        System.out.println("The entered user is not being followed");
                        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/notFollowing.jsp");
                        dispatcher.forward(request,response);
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(SearchUserServlet.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                
            }
            
            else
            {
                //Redirect to page showing tha the given user dows not exist
                RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/notExist.jsp");
                dispatcher.forward(request,response);
                System.out.println("The entered username does NOT EXIST");
            }
        } catch (SQLException ex) {
            Logger.getLogger(SearchUserServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


}
