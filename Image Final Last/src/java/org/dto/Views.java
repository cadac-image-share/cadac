package org.dto;
import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class Views extends Connecting implements Serializable {

	String vusername;
	int vid;
	public void insertview(int id,String username) throws SQLException{
		int success;
			PreparedStatement pstmt = con.prepareStatement("select vid,vusername from s.views where vid=? and vusername=?");
         pstmt.setString(2, username);
 		pstmt.setInt(1,id);
                ResultSet sR=pstmt.executeQuery();
                if(!sR.next())
                {
                    PreparedStatement pstmt2 = con.prepareStatement("insert into s.views (vid,vusername) values (?,?)");
                     pstmt2.setString(2, username);
 		pstmt2.setInt(1,id);
                success =    pstmt2.executeUpdate();
                pstmt2.close();
                if(success>=1)
                    { 
                        this.vusername=vusername; 


                    }
                }
	
   
	
	}
        //not required function
	public void deletelview(Image i,User u) throws SQLException{
		int success;
		PreparedStatement pstmt = con.prepareStatement("delete from s.views where vid=? and vusername=?");
         pstmt.setString(2, u.getUsername());
 		pstmt.setInt(1,i.getId());
         success =    pstmt.executeUpdate();
         pstmt.close();
         
	
   
	
	}
}
