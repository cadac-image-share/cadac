/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.isp;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import org.dto.*;

/**
 *
 * @author hp
 */
@WebServlet("/uploadServlet")
@MultipartConfig(maxFileSize = 16177215)
public class uploadServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("Tandon from london");
        String alname,cap,tag,visible_to,location;
        alname=request.getParameter("album");
        cap=request.getParameter("caption");
        tag=request.getParameter("tags");
        visible_to=request.getParameter("visible_to");
        location=request.getParameter("loc");
        HttpSession session = request.getSession();
        String uname=(String) session.getAttribute("username");
        System.out.println(uname);
        User user=new User();
        
        try {
            InputStream inputStream = null; // input stream of the upload file
         
        // obtains the upload file part in this multipart request
            Part filePart = request.getPart("photo");
            if (filePart != null) {
                // prints out some information for debugging
                System.out.println(filePart.getName());
                System.out.println(filePart.getSize());
                System.out.println(filePart.getContentType());

                // obtains input stream of the upload file
                inputStream = filePart.getInputStream();
            }
            user.retrieveUserdetails(uname);
            Album al=new Album();
            al.createAlbum(user, alname);
            Image img=new Image();
            String tagarray[]=new String[20];
            StringTokenizer st = new StringTokenizer(tag);
            int i=0;
             while (st.hasMoreTokens()) {
         tagarray[i++]=st.nextToken();
     }
     for(int j=0;j<i;j++)
     {
         System.out.println(tagarray[j]);
     }
     int vto=Integer.parseInt(visible_to);
            if(img.uploadImage(user, inputStream,location, cap, "copyright", 1,vto, alname))//location and visible_to
            {
                Tags t=new Tags();
                System.out.println("Tag mein to gya hian");
                for(int j=0;j<i;j++)
                {
                       t.inserttag(img, tagarray[j]);
                        System.out.println("Tag insrt ho rha hain yar");
                }
            System.out.println("Bahar bhi aa gya ");
            }
            else
            {
                System.out.println("nahi hui upload");
            }
        } catch (SQLException ex) {
            
            Logger.getLogger(uploadServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println(uname);
        //response.sendRedirect("timeline.jsp");
        User u=new User();
        try {
            u.retrieveUserdetails(uname);
             user.makeNewsfeed("uptime");
                  //user.searchimages("tag");
        } catch (SQLException ex) {
            Logger.getLogger(uploadServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
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
                    try {
                        images[kk].getDataofimage(Integer.parseInt(subtt));
                    } catch (SQLException ex) {
                        Logger.getLogger(uploadServlet.class.getName()).log(Level.SEVERE, null, ex);
                    }
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
            System.out.println("Hello Arora");
            request.setAttribute("caption", caption);
                    request.setAttribute("filenames", filenames);
//        try {
//            Thread.sleep(11111);
//        } catch (InterruptedException ex) {
//            Logger.getLogger(uploadServlet.class.getName()).log(Level.SEVERE, null, ex);
//        }
                    RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/timeline.jsp");
                    dispatcher.forward(request,response); 
    }
  }