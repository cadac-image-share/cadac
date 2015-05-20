package org.dto;
import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
/**
 *
 * @author ankursmooth
 */

public class Follows extends Connecting implements Serializable {

	String frusername,feusername;

	public String getFrusername() {
		return frusername;
	}

	public String getFeusername() {
		return feusername;
	}
	public boolean afollowsb(User a,String feusername) throws SQLException{
		if(a.getAuthorized()&&(a.username_available(feusername)==false)){
			int success;
			frusername=a.getUsername();
			if(checkafollowsb(a.getUsername(),feusername))
                            return true;
			PreparedStatement pstmt = con.prepareStatement("insert into s.follows (frusername, feusername) values (?,?)");
	         pstmt.setString(2, feusername);
	 		pstmt.setString(1,frusername);
	         success =    pstmt.executeUpdate();
	         pstmt.close();
	         if(success>=1)
	         { 
	        	 this.feusername=feusername; 
	        	 HashSet<String> nhashset= followershash.get(a.getUsername());
	        	 nhashset.add(frusername);
	        	 followershash.put(feusername, nhashset);
	        	 return true;
	         
	         }
		
	   return false;
			
		}
		return false;
	}
	public void aunfollowsb(User a,String feusername) throws SQLException{
		if(a.getAuthorized()&&(a.username_available(feusername)==false)){
			int success;
			frusername=a.getUsername();
			if(!checkafollowsb(a.getUsername(),feusername))
                            return;
			PreparedStatement pstmt = con.prepareStatement("delete from s.follows where frusernaem=? and feusername=?)");
	         pstmt.setString(2, feusername);
	 		pstmt.setString(1,frusername);
	         success =    pstmt.executeUpdate();
	         HashSet<String> nhashset= followershash.get(a.getUsername());
        	 nhashset.remove(frusername);
        	 followershash.put(feusername, nhashset);
	         pstmt.close();
	        
		}
	}
        public boolean checkafollowsb(String a,String feusername) throws SQLException{
            PreparedStatement pstmt2 = con.prepareStatement("select frusername from s.follows where feusername=? and frusername=?");
		pstmt2.setString(1, feusername);
                pstmt2.setString(2, a);
                
        ResultSet selectResults2 = pstmt2.executeQuery() ;
        if(selectResults2.next())
            return true;
        else
            return false;
        }
	public HashSet<String> allfollowersofa(User a){
		HashSet<String> nhashset= followershash.get(a.getUsername());
		return nhashset;
	}
}
