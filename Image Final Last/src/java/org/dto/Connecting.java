//project by ankur arora , akshat, dhiyavasu, chirag agarwal, chirag garg
package org.dto;
import java.io.*;
import java.sql.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;



public class Connecting{

	static protected Connection con;
	static protected HashMap<String, String> hs= new HashMap<String, String>();
        //Contains all the followers of a paritcular username
	static protected HashMap<String,HashSet<String>> followershash= new HashMap<String,HashSet<String>>();
        static boolean hashmade;
        public static Connection connect() 
        {
            try {
                Class.forName("com.ibm.db2.jcc.DB2Driver");
                con = DriverManager.getConnection("jdbc:db2://localhost:50000/chhavi","ankursmooth",password)
				//removed the semi colon to make u look here and set ur details. chhavi is the database name
                System.out.println("Connected");
                if(!hashmade)
               createHashmap();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Connecting.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(Connecting.class.getName()).log(Level.SEVERE, null, ex);
            }
       
       
            
            return con;
        }
//        
//	public static void startCon() throws ClassNotFoundException, SQLException 
//        {
//		
//           con=connect();
//           
//    }
        public static void createHashmap() throws SQLException{
//            con=connect();
       PreparedStatement pstmt = con.prepareStatement("select username, pword from s.user");
		
       ResultSet selectResults = pstmt.executeQuery() ;
       while(selectResults.next()){
       	String uname=selectResults.getString("username");
       	hs.put(uname,selectResults.getString("PWORD"));
       	PreparedStatement pstmt2 = con.prepareStatement("select frusername from s.follows where feusername=?");
		pstmt2.setString(1, uname);
        ResultSet selectResults2 = pstmt2.executeQuery() ;
        HashSet<String> nhashset= new HashSet<String>();
        	while(selectResults2.next()){
        	
        		nhashset.add(selectResults2.getString("frusername"));
        
        	}
        followershash.put(uname, nhashset);
       pstmt2.close();
       }
       
       pstmt.close();
       hashmade=true;
       
		       
        }
	
	public void closeCon() throws SQLException{
		hs.clear();
		con.close();
	}
	public Connection getCon(){
		return con;
	}
}
