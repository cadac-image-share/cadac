/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

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
 * @author flappy
 */
@WebServlet("/Profile")
public class ProfilePage extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("hi");
            User user=new User();
            String uname=request.getParameter("uname");
            System.out.println(uname);
        try {
            user.retrieveUserdetails(uname);
            //user.getP_image();
            System.out.println(user.getUsername());
        } catch (SQLException ex) {
            Logger.getLogger(ProfilePage.class.getName()).log(Level.SEVERE, null, ex);
        }
            request.setAttribute("user", user);
                    RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/profile.jsp");
                    dispatcher.forward(request,response);   
    }
}
