/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

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
import org.dto.Image;
import org.dto.User;

/**
 *
 * @author flappy
 */
@WebServlet("/Search")
public class SearchServlet extends HttpServlet {

   
   protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       String squery=request.getParameter("search"); 
       HttpSession session = request.getSession();
        String uname=(String) session.getAttribute("username");
        User user=new User();
        
       try {
           
           user.retrieveUserdetails(uname);
           System.out.println("search tak pahucha"+squery);
           if(user.searchimages(squery))
               System.out.println("search toh hua");
               
                    session.setAttribute("username", user.getUsername());
                    List<String> filenames = new ArrayList<>();
                    List<String> caption = new ArrayList<>();

            File[] files = new File("C:\\Users\\ankursmooth\\Documents\\Netbeans projects\\Image Final Last\\web\\searchresult\\large" ).listFiles();
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
            request.setAttribute("caption", caption);
                    request.setAttribute("filenames", filenames);
                    //Thread.sleep(11111);
                    RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/timeline_1.jsp");
                    dispatcher.forward(request,response);
       } catch (SQLException ex) {
           Logger.getLogger(SearchServlet.class.getName()).log(Level.SEVERE, null, ex);
       } catch (Exception ex) {
           Logger.getLogger(SearchServlet.class.getName()).log(Level.SEVERE, null, ex);
       }
           
    }
}
