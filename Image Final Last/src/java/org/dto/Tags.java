package org.dto;
import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;


public class Tags extends Connecting implements Serializable{

	String tag;
	int tid;
	public void inserttag(Image i,String tag) throws SQLException{
		int success;
		PreparedStatement pstmt = con.prepareStatement("insert into s.tags (tid,tag) values (?,?)");
                 pstmt.setString(2, tag);
 		pstmt.setInt(1,i.getId());
                 success =    pstmt.executeUpdate();
                pstmt.close();
                if(success>=1)
                { 
        	 this.tag=tag; 
        	 
         
                }
	
   
	
	}
	public void deletetag(Image i,String tag) throws SQLException{
		int success;
		PreparedStatement pstmt = con.prepareStatement("delete from s.tags where tid=? and tag=?");
         pstmt.setString(2, tag);
 		pstmt.setInt(1,i.getId());
         success =    pstmt.executeUpdate();
         pstmt.close();
         if(success>=1)
         { 
        	 this.tag=tag; 
        	 
         
         }
	
   
	
	}
	public ArrayList<String> getalltags(Image i) throws SQLException{
		ArrayList<String> ls=new ArrayList<String>();

		
		PreparedStatement pstmt2 = con.prepareStatement("select tag from s.tags where tid=?");
		pstmt2.setInt(1, i.getId());
		
        ResultSet sR2 = pstmt2.executeQuery() ;
        int k=0;
        while(sR2.next()){
        	
        	ls.add(k++,sR2.getString("tag"));
      	
        	
        }
        pstmt2.close();
		return ls;
	}
	
}
