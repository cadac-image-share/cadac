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
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.dto.Likes;

/**
 *
 * @author Dell-
 */

@WebServlet("/addBucket")
public class BucketServlet extends HttpServlet {

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
            throws ServletException, IOException 
    {
        String currentUsername;
        int id;
        Likes lobj = new Likes();
        
        //Extract currently logged in user's username 
        HttpSession session = request.getSession();
        currentUsername = (String) session.getAttribute("username");
        
       //Extracting image id from the form
        id = Integer.parseInt(request.getParameter("imageId"));
        
        //Setting the temp in session to image id
        session = request.getSession();
        session.setAttribute("tempname",request.getParameter("imageId"));
        
        System.out.println("Image id :"+id+"- Username "+currentUsername);
        
        try {
            //Checking if the user had already liked or not
            //public boolean useralreadyliked(int id, String username) throws SQLException{
            if(lobj.useralreadyliked(id,currentUsername))
            {
                System.out.println("Image already liked");
                //If already liked redirect
                RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/alreadyLiked.jsp");
                dispatcher.forward(request,response);
            }
            
            else            
            {
                System.out.println("Image not liked,liking it");
                try {
                    //If not liked ,like the image
                    lobj.insertlike(id,currentUsername);
                } catch (SQLException ex) {
                    Logger.getLogger(BucketServlet.class.getName()).log(Level.SEVERE, null, ex);
                }
                RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/insertedLiked.jsp");
                dispatcher.forward(request,response);
            }
        } catch (SQLException ex) {
            Logger.getLogger(BucketServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
}
    

