package org.dto;
import java.sql.*;
//import java.util.*;
import java.io.Serializable;
public class Album extends Connecting implements Serializable{

	String ausername, alname;

	public String getAusername() {
		return ausername;
	}

	public String getAlname() {
		return alname;
	}
	public boolean createAlbum(User u, String alname) throws SQLException{
	if(u.getAuthorized()){
		int success=0;
		ausername=u.getUsername();
		
		PreparedStatement pstmt2 = con.prepareStatement("select alname from s.album where alname=? and ausername=?");
		pstmt2.setString(1, alname);
		pstmt2.setString(2,ausername);
        ResultSet sR2 = pstmt2.executeQuery() ;
        if(sR2.next()){
        	pstmt2.close();
        	this.alname=alname;
        	return true;
        	
        }
        
        pstmt2.close();
         PreparedStatement pstmt = con.prepareStatement("insert into s.album (ausername, alname) values (?,?)");
         pstmt.setString(2, alname);
 		pstmt.setString(1,ausername);
         success =    pstmt.executeUpdate();
         pstmt.close();
         if(success>=1)
         { 
        	 this.alname=alname;
        	 return true;
         
         }
	
   return false;
	}
	return false;
	}
	
//	public void setAusername(String ausername) {
//		this.ausername = ausername;
//	}

//	public void setAlname(String alname) {
//		this.alname = alname;
//	}
	
}
