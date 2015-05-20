package org.dto;
//project by ankur arora , akshat, dhiyavasu, chirag agarwal, chirag garg
import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class Likes extends Connecting implements Serializable{

	String lusername;
	int lid;
	public void insertlike(int id,String username) throws SQLException{
		int success;
			PreparedStatement pstmt = con.prepareStatement("select lid,lusername from s.likes where lid=? and lusername=?");
         pstmt.setString(2, username);
 		pstmt.setInt(1,id);
                ResultSet sR=pstmt.executeQuery();
                if(!sR.next())
                {
                    PreparedStatement pstmt2 = con.prepareStatement("insert into s.likes (lid,lusername) values (?,?)");
                     pstmt2.setString(2, username);
 		pstmt2.setInt(1,id);
                success =    pstmt2.executeUpdate();
                pstmt2.close();
                if(success>=1)
                    { 
                        this.lusername=username; 


                    }
                }
	
   
	
	}
	public void deletellike(int id, String username) throws SQLException{
		int success;
			PreparedStatement pstmt = con.prepareStatement("select lid,lusername from s.likes where lid=? and lusername=?");
         pstmt.setString(2, username);
 		pstmt.setInt(1,id);
                ResultSet sR=pstmt.executeQuery();
                if(!sR.next())
                {
                    	PreparedStatement pstmt2 = con.prepareStatement("delete from s.likes where lid=? and lusername=?");
                     pstmt2.setString(2, username);
 		pstmt2.setInt(1,id);
                success =    pstmt2.executeUpdate();
                pstmt2.close();
                
                }
	    
	
         
	
   
	
	}
        public boolean useralreadyliked(int id, String username) throws SQLException{
            int success;
			PreparedStatement pstmt = con.prepareStatement("select lid,lusername from s.likes where lid=? and lusername=?");
         pstmt.setString(2, username);
 		pstmt.setInt(1,id);
                ResultSet sR=pstmt.executeQuery();
                if(!sR.next())
                    return false;
                else
                    return true;
        }
	public ArrayList<String> getalllikers(Image i) throws SQLException{
		ArrayList<String> ls=new ArrayList<String>();

		
		PreparedStatement pstmt2 = con.prepareStatement("select lusername from s.likes where lid=?");
		pstmt2.setInt(1, i.getId());
		
        ResultSet sR2 = pstmt2.executeQuery() ;
        int k=0;
        while(sR2.next()){
        	
        	ls.add(k++,sR2.getString("lusername"));
      	
        	
        }
        pstmt2.close();
		return ls;
	}
	
}
