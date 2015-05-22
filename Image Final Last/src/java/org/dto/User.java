package org.dto;
//project by ankur arora , akshat, dhiyavasu, chirag agarwal, chirag garg

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.sql.*;
import static org.dto.Connecting.con;

/**
 *
 * @author ankursmooth
 */
public class User extends Connecting implements Serializable {

    private Readwriteimage img;
    private String username, fname, lname, pword, email, dob, fpq, fpa, m, gender;
    private int numimages, numfrs, numfes;
    private static boolean authorized;
    private byte[] p_image;

    public User() {

        img = new Readwriteimage();

    }
	// before signup check email and username
    //If username exits returns false

    public boolean username_available(String s) throws SQLException {
        con = Connecting.connect();

//        Statement selectStmt = con.createStatement();
//        PreparedStatement pstmt = con.prepareStatement("select username from s.user where username=?");
//        pstmt.setString(1, s);
//        ResultSet selectResults = pstmt.executeQuery();
//        if (selectResults.next()) {
//            pstmt.close();
//
//            return false;
//        }
//        pstmt.close();
// using The HASH MAP created in Connecting.java
            if(hs.containsKey(s))
                return false;
            else
                return true;
//        return true;
    }
	//for getting public details of create object of this class and then call retrieveUserdetails, u should use this function 
    //at time of forget password also, so that fpq ie security question can be accesed ad then call forget pass


    public boolean getAuthorized() {
        return authorized;
    }

    public boolean forgotpass(String username, String answer) throws SQLException {
        con = connect();
        authorized = false;
        PreparedStatement pstmt2 = con.prepareStatement("select fpa from s.user where username=?");
        pstmt2.setString(1, username);
        ResultSet sR2 = pstmt2.executeQuery();

        while (sR2.next()) {
            if (answer.compareTo(sR2.getString("fpa")) == 0) {
                authorized = true;
                this.username = username;
                retrieveUserdetails(username);

            }

        }
        pstmt2.close();
        return authorized;
    }

    public void makeNewsfeed(String order) throws SQLException {
        if (authorized) {
            System.out.println("Authorised");
//                        img.deldir("C:\\Users\\ankursmooth\\Documents\\Netbeans projects\\Image Final Last\\web\\img\\");
            File file = new File("C:\\Users\\ankursmooth\\Documents\\Netbeans projects\\Image Final Last\\web\\img\\large\\");
            file.mkdirs();
            File file2 = new File("C:\\Users\\ankursmooth\\Documents\\Netbeans projects\\Image Final Last\\web\\img\\thumb\\");
            file2.mkdirs();
            PreparedStatement pstmt2 = con.prepareStatement("select imagedata,id from s.image where (iausername in (select frusername from s.follows where feusername= ?) and visible_to=1) or (visible_to=2 ) or ( iausername=? and visible_to<2) order by " + order + " DESC");
            pstmt2.setString(1, username);
            pstmt2.setString(2, username);

            ResultSet sR2 = pstmt2.executeQuery();
            byte[] image_data;
            int id;
            char order_id = 'a';
            Views vvv = new Views();
            while (sR2.next()) {
                image_data = sR2.getBytes("imagedata");
                id = sR2.getInt("id");
                System.out.println(id + "");
                if (image_data != null) {

                    if (order_id > 'z') {
                        break;
                    }
                    img.writeImage(image_data, "C:\\Users\\ankursmooth\\Documents\\Netbeans projects\\Image Final Last\\web\\img\\large\\" + order_id + "_" + id + ".jpg");
                    img.writeImage(image_data, "C:\\Users\\ankursmooth\\Documents\\Netbeans projects\\Image Final Last\\web\\img\\thumb\\" + order_id + "_" + id + ".jpg");
                    order_id = (char) (order_id + 1);
                    vvv.insertview(id, username);
	        		//to get more details of a particular image .. get the image id from the string and get more data
                    // by creating object of image and then calling getimagedetailsof function for image by giving image id
                }
            }
            pstmt2.close();

        }
    }

    public boolean signup_nomobile(String username, String fname, String lname, String pword, String email, String gender, String dob, String fpq, String fpa) throws SQLException {
        authorized = false;//
        con = Connecting.connect();
        int success = 0;
        PreparedStatement pstmt = con.prepareStatement("insert into s.user ( USERNAME, FNAME , LNAME, PWORD, EMAIL, GENDER, DOB, FPQ, FPA) values (?,?,?,?,?,?,?,?,?)");
        pstmt.setString(1, username);
        this.username = username;
        pstmt.setString(2, fname);
        this.fname = fname;
        pstmt.setString(3, lname);
        this.lname = lname;
        pstmt.setString(4, pword);
        this.pword = pword;
        pstmt.setString(5, email);
        this.email = email;
        pstmt.setString(6, gender);
        this.gender = gender;
        pstmt.setString(7, dob);
        this.dob = dob;
        pstmt.setString(8, fpq);
        this.fpq = fpq;
        pstmt.setString(9, fpa);
        this.fpa = fpa;
        success = pstmt.executeUpdate();
        pstmt.close();
        if (success >= 1) {
            authorized = true;
            retrieveUserdetails(username);
            hs.put(username, pword);
            return true;

        }

        return false;
    }

    public void retrieveUserdetails(String username) throws SQLException {
        con = Connecting.connect();
        PreparedStatement pstmt2 = con.prepareStatement("select * from s.user where username=?");
        pstmt2.setString(1, username);
        this.username = username;
        ResultSet sR2 = pstmt2.executeQuery();
        while (sR2.next()) {
            fname = sR2.getString("FNAME");
            lname = sR2.getString("LNAME");
            sR2.getString("PWORD");
            email = sR2.getString("EMAIL");
            dob = sR2.getString("DOB");
            fpq = sR2.getString("FPQ");
            sR2.getString("FPA");
            m = sR2.getString("M");
            numimages = sR2.getInt("NUMIMAGES");
            numfrs = sR2.getInt("NUMFRS");
            numfes = sR2.getInt("NUMFES");
        }
        pstmt2.close();

    }

    public boolean auth_login(String uname, String p) throws SQLException {

        con = connect();
        // if(con==null)
        authorized = false;
        System.out.println("--------------------------------");
        PreparedStatement pstmt = con.prepareStatement("select pword from s.user where username=?");
        pstmt.setString(1, uname);
        ResultSet selectResults = pstmt.executeQuery();
        while (selectResults.next()) {
            username = uname;
            if (p.compareTo(selectResults.getString("PWORD")) == 0) {
                authorized = true;
            }
            if (authorized) {
                retrieveUserdetails(uname);
            }
        }

        return authorized;

    }

    public boolean auth_login_usingHash(String uname, String p) throws SQLException {
        //		
        authorized = false;
        con = connect();
        if (p.equals(hs.get(uname))) {
            authorized = true;
        }
        if (authorized) {
            username = uname;
            retrieveUserdetails(uname);
        }

        return authorized;

    }

    public String getUsername() {
        return username;
    }

    public String getFname() {

        return fname;
    }

    public String getLname() {
        return lname;
    }
//	public String getPword() {
//		return pword;
//	}

    public String getEmail() {
        return email;
    }

    public String getDob() {
        if (authorized) {
            return dob;
        } else {
            return null;
        }
    }

    public String getFpq() {
        return fpq;
    }
//	public String getFpa() {
//		return fpa;
//	}

    public String getM() {
        if (authorized) {
            return m;
        } else {
            return null;
        }
    }

    public String getGender() {
        return gender;
    }

    public int getNumimages() throws SQLException {
        retrieveUserdetails(username);
        return numimages;
    }

    public int getNumfrs() throws SQLException {
        retrieveUserdetails(username);
        return numfrs;
    }

    public int getNumfes() throws SQLException {
        retrieveUserdetails(username);
        return numfes;
    }

    public void getP_image() throws SQLException {
        //
        PreparedStatement pstmt = con.prepareStatement("select p_image,username from s.user WHERE USERNAME=?");
        pstmt.setString(1, username);
        ResultSet sR = pstmt.executeQuery();
        while (sR.next()) {
            p_image = sR.getBytes("p_image");
        }
        img.makdir(username);
        if (p_image != null) {
            img.writeImage(p_image, "C:\\Users\\ankursmooth\\Documents\\Netbeans projects\\Image Final Last\\web\\img\\profilepic.jpg");
        } else {

            img.writeImage(img.readImage("C:\\Users\\ankursmooth\\Documents\\Netbeans projects\\Image Final Last\\web\\defaultprofilepic.jpg"), "C:\\Users\\ankursmooth\\Documents\\Netbeans projects\\Image Final Last\\web\\img\\profilepic.jpg");
        }
        pstmt.close();

    }

    public void setP_image(InputStream inputStream) throws SQLException, IOException {
        //
        p_image = img.getBytes(inputStream);
        PreparedStatement pstmt = con.prepareStatement("UPDATE S.USER SET p_image=? WHERE USERNAME=?");
        pstmt.setBytes(1, p_image);
        pstmt.setString(2, username);
        pstmt.executeUpdate();
        pstmt.close();

    }

    public void setFname(String fname) throws SQLException {
        //
        PreparedStatement pstmt = con.prepareStatement("UPDATE S.USER SET fname=? WHERE USERNAME=?");
        pstmt.setString(1, fname);
        pstmt.setString(2, username);
        pstmt.executeUpdate();
        this.fname = fname;

        pstmt.close();
    }

    public void setLname(String lname) throws SQLException {
        //
        PreparedStatement pstmt = con.prepareStatement("UPDATE S.USER SET lname=? WHERE USERNAME=?");
        pstmt.setString(1, lname);
        pstmt.setString(2, username);
        pstmt.executeUpdate();
        this.lname = lname;
        pstmt.close();
    }

    public void setPword(String pword) throws SQLException {
        if (authorized) {
            //
            System.out.println("password changed");
            System.out.println(pword);
            PreparedStatement pstmt = con.prepareStatement("UPDATE S.USER SET pword=? WHERE USERNAME=?");
            pstmt.setString(1, pword);
            pstmt.setString(2, username);
            pstmt.executeUpdate();
            this.pword = pword;
            pstmt.close();
            hs.put(username, pword);
        } else {
            System.out.println("setpw");
        }
    }

    public boolean availableEmail(String email) throws SQLException {
        //
        PreparedStatement pstmt = con.prepareStatement("select email from s.user where email=?");
        pstmt.setString(1, email);
        ResultSet selectResults = pstmt.executeQuery();
        if (selectResults.next()) {
            pstmt.close();
            return false;
        }
        return true;
    }

    public void setEmail(String email) throws SQLException {
        //
        PreparedStatement pstmt = con.prepareStatement("UPDATE S.USER SET email=? WHERE USERNAME=?");
        pstmt.setString(1, email);
        pstmt.setString(2, username);
        pstmt.executeUpdate();
        this.email = email;
        pstmt.close();
    }

    public void setDob(String dob) throws SQLException {
        //
        PreparedStatement pstmt = con.prepareStatement("UPDATE S.USER SET dob=? WHERE USERNAME=?");
        pstmt.setString(1, dob);
        pstmt.setString(2, username);
        pstmt.executeUpdate();
        this.dob = dob;
        pstmt.close();
    }

    public void setFpq(String fpq) throws SQLException {
        //
        PreparedStatement pstmt = con.prepareStatement("UPDATE S.USER SET fpq=? WHERE USERNAME=?");
        pstmt.setString(1, fpq);
        pstmt.setString(2, username);
        pstmt.executeUpdate();
        this.fpq = fpq;
        pstmt.close();
    }
// Fpa is secret question's answer ( forgot password answer)
    public void setFpa(String fpa) throws SQLException {
        //
        PreparedStatement pstmt = con.prepareStatement("UPDATE S.USER SET fpa=? WHERE USERNAME=?");
        pstmt.setString(1, fpa);
        pstmt.setString(2, username);
        pstmt.executeUpdate();
        this.fpa = fpa;
        pstmt.close();
    }

    public void setM(String m) throws SQLException {
        //
        PreparedStatement pstmt = con.prepareStatement("UPDATE S.USER SET m=? WHERE USERNAME=?");
        pstmt.setString(1, m);
        pstmt.setString(2, username);
        pstmt.executeUpdate();
        this.m = m;
        pstmt.close();
    }

    //allowed gender values M F U

    public void setGender(String gender) throws SQLException {
        //
        PreparedStatement pstmt = con.prepareStatement("UPDATE S.USER SET gender=? WHERE USERNAME=?");
        pstmt.setString(1, gender);
        pstmt.setString(2, username);
        pstmt.executeUpdate();
        this.gender = gender;
        pstmt.close();
    }
//Logging out and deleting files og that user
    public void Logout() {
        img.deldir("C:\\Users\\ankursmooth\\Documents\\Netbeans projects\\Image Final Last\\web\\searchresult\\");
        img.deldir("C:\\Users\\ankursmooth\\Documents\\Netbeans projects\\Image Final Last\\web\\img\\")
        //removed semi colon so that u change the paths in this java file according tou ur file structure
        authorized = false;
        img.deldir("C:\\Users\\ankursmooth\\Documents\\Netbeans projects\\Image Final Last\\web\\profilepic.jpg");

    }

    public void del_user() throws SQLException {
        if (authorized) {

            PreparedStatement pstmt = con.prepareStatement("delete from S.USER WHERE USERNAME=?");
            pstmt.setString(1, username);
            pstmt.executeUpdate();
            pstmt.close();
            hs.remove(username);
            Logout();
        }
    }

    public UserM getDetails(String userId) {
        UserM userm = new UserM();
        userm.setUname(getUsername());
        userm.setFname(getFname());

        return userm;

    }

    public boolean searchimages(String squery) throws SQLException {
        System.out.println("user k search m");
        con = Connecting.connect();

        System.out.println("user k search m aur search m ander");
        
        img.deldir("C:\\Users\\ankursmooth\\Documents\\Netbeans projects\\Image Final Last\\web\\" + "searchresult\\");
        File file = new File("C:\\Users\\ankursmooth\\Documents\\Netbeans projects\\Image Final Last\\web\\" + "searchresult\\large\\");
        file.mkdirs();
        File file2 = new File("C:\\Users\\ankursmooth\\Documents\\Netbeans projects\\Image Final Last\\web\\" + "searchresult\\thumb\\");
        file2.mkdirs();

        PreparedStatement pstmt2 = con.prepareStatement("select id , imagedata from s.image c , (select distinct(id) as sid from (select imagedata,id,caption from s.image where (iausername in (select frusername from s.follows where feusername= ?) and visible_to=1) or (visible_to=2 ) or ( iausername=? and visible_to=0) order by pulse) a, s.tags b where (tag like '%" + squery + "%' and tid=id) or caption like '%" + squery + "%' ) d where d.sid=c.id order by uptime desc");
        pstmt2.setString(1, username);
        pstmt2.setString(2, username);

        ResultSet sR2 = pstmt2.executeQuery();
        byte[] image_data;
        int id;
        char order_id = 'a';
        boolean searchresultarethere = false;
        Views vvv = new Views();
        while (sR2.next()) {
            image_data = sR2.getBytes("imagedata");
            id = sR2.getInt("id");
            System.out.println(id + "");
            if (image_data != null) {
                if (order_id > 'z') {
                    break;
                }
                vvv.insertview(id, username);
                img.writeImage(image_data, "C:\\Users\\ankursmooth\\Documents\\Netbeans projects\\Image Final Last\\web\\" + "searchresult\\large\\" + order_id + "_" + id + ".jpg");
                img.writeImage(image_data, "C:\\Users\\ankursmooth\\Documents\\Netbeans projects\\Image Final Last\\web\\" + "searchresult\\thumb\\" + order_id + "_" + id + ".jpg");
                order_id = (char) (order_id + 1);

            //to get more details of a particular image .. get the image id from the string and get more data
                // by creating object of image and then calling getimagedetailsof function for image by giving image id
                searchresultarethere = true;
            }
        }
        pstmt2.close();
        return searchresultarethere;

    }
// to change the password string to senseless string to be stored in database
    public String encrypt(String text, final String key)
    {
        String res = "";
        text = text.toUpperCase();
        for (int i = 0, j = 0; i < text.length(); i++)
        {
            char c = text.charAt(i);
            int a;
            
            if (c < 'A' || c > 'Z')
            {
                a=3*c/4;
                a=a%10;
                res += (char) (a);
            }
            else
            res += (char) ((c + key.charAt(j) - 2 * 'A') % 26 + 'A');
            j = ++j % key.length();
        }
        System.out.println("after encrypton"+ res);
        return res;
    }

}
