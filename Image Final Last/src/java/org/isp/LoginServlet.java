/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.isp;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.dto.Connecting;
import org.dto.Image;
import org.dto.User;
import org.dto.UserM;

/**
 *
 * @author hp
 */
@WebServlet("/index")
public class LoginServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            String userId,pswd;
            userId=request.getParameter("unameLog");
            pswd=request.getParameter("pass");
            HttpSession session=request.getSession();
             System.out.println("arora is 1");
             User user=new User();
             System.out.println("arora is 2");
             //Connecting c=new Connecting();
             System.out.println("arora is 4");
            boolean result;
            try
            {
                //result=user.auth_login_usingHash(userId, pswd);
                pswd=user.encrypt(pswd,"VIGENERECIPHER");
                result=user.auth_login_usingHash(userId, pswd);
                System.out.println("esult is"+result);
                if(result)
                {
                    System.out.println("arora is rifht");
                    //UserM userm =user.getDetails(userId);
                   
                  System.out.print(user.getUsername());
                  user.makeNewsfeed("uptime");
                 // user.searchimages("tag");
                    session.setAttribute("username", user.getUsername());
                    List<String> filenames = new ArrayList<>();
                    List<String> caption = new ArrayList<>();

            File[] files = new File("C:\\Users\\ankursmooth\\Documents\\Netbeans projects\\Image Final Last\\web\\img\\large" ).listFiles();
            //If this pathname does not denote a directory, then listFiles() returns null. 
            Image [] images = new Image[25];
            int kk=0;
            for (File file : files) {
                if (file.isFile()) {
                    String tt=file.getName();
                    filenames.add(tt);
                    String subtt = tt.substring(tt.indexOf('_')+1, tt.indexOf('.'));
                    
                    images[kk]=new Image();
                    images[kk].getDataofimage(Integer.parseInt(subtt));
                    caption.add("id:"+images[kk].getId()+", L:"+images[kk].getLikes()+", V:"+images[kk].getViews()+", P: "+images[kk].getPulse()+", uploader:"+images[kk].getIausername()+" ," + images[kk].getCaption());
                    System.out.println(images[kk].getCaption()+" "+tt);
                    kk++;
                    if(kk==24)
                        break;
                }
            }
            while(kk<26){
                filenames.add(kk+"abcd.jpg");
                caption.add(kk+"NO_image.jpg");
                kk++;
            }
            System.out.println("ha bhai aa gya ");
            System.out.println("Path:" + filenames.get(0));
            System.out.println("Path:"+ filenames.get(1));
                    System.out.println("Caption: "+(String)caption.get(0));
                    request.setAttribute("caption", caption);
                    request.setAttribute("filenames", filenames);
//                   try
//                    {
//                        Thread.sleep(11111);
//                    }
//                    catch(InterruptedException e)
//                    {
//                        Thread.currentThread().interrupt();
//                    }
                    RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/timeline.jsp");
                    dispatcher.forward(request,response);   
                    //response.sendRedirect("timeline.jsp");
                    System.out.println("Caption: ");
                }
                else
                {
                    System.out.println("Arora kya yar!");
                    response.sendRedirect("Failed.jsp");
                }
            }
            catch(SQLException e)
            {
                System.out.println("Arorar!");
                response.sendRedirect("Failed.jsp");
                e.printStackTrace();
            }
        }
    }