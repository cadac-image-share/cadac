package org.dto;
import java.sql.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;

import javax.imageio.ImageIO;

/**
 *
 * @author ankursmooth
 */
public class Image extends Connecting implements Serializable {
	

	private int id,height,width,views,pulse,likes,category, visible_to;
	private String iausername,ialname,caption,iusername,place,copyright;
	private byte[] imagedata;
	private Readwriteimage img;
	public Image(){
		img= new Readwriteimage();
	}
	
	public int getId() {
		return id;
	}
	public int getHeight() {
		return height;
	}
	public int getWidth() {
		return width;
	}
	public int getViews() {
		
		return views;
	}
	public int getPulse() {
		return pulse;
	}
	public int getLikes() {
		return likes;
	}
	public int getCategory() {
		return category;
	}
        public String getCaption(){
            return caption;
        }
	public int getVisible_to() {
		return visible_to;
	}
	public String getIausername() {
		return iausername;
	}
	public String getIalbumname() {
		return ialname;
	}
//	public boolean tpfunc(User u){
//		return u.getAuthorized();
//	}
	public boolean getDataofimage(int id) throws SQLException{
		PreparedStatement pstmt = con.prepareStatement("select * from s.image where id=?");
		pstmt.setInt(1,id);
        ResultSet sR2 = pstmt.executeQuery() ;
        if(sR2.next()){
        	this.id=sR2.getInt("id"); 
	         sR2.getBytes("imagedata"); 
	         place=sR2.getString("place"); 
	         caption=sR2.getString("caption");
	         copyright=sR2.getString("copyright");
	         height=sR2.getInt("height"); 
	         width=sR2.getInt("width"); 
	         category=sR2.getInt("category"); 
	         visible_to=sR2.getInt("visible_to");
	         iausername=sR2.getString("iausername");
	         ialname=sR2.getString("ialname");
	         iusername=sR2.getString("iusername");
	         setlikespulseviews();
	         pstmt.close();
	         return true;
        }
        pstmt.close();


		return false;
	}
	public void setImagedata(InputStream inputStream) throws IOException{
//		imagedata=img.readImage(filepath);
            imagedata=img.getBytes(inputStream);
		BufferedImage imggg = ImageIO.read(new ByteArrayInputStream(imagedata));
        setWidth(imggg.getWidth());
        setHeight(imggg.getHeight());
        
	}
	//visible_to 2 is pubic, 1 is followers and 0 is me only
	public boolean uploadImage(User u,InputStream inputStream,String place, String caption, String copyright, int category,int visible_to, String albumname) throws SQLException, IOException{
	
            
			//write code to getconnection from connecting.java and then call setImagedata to set (imagedata,height and width)
			// set username using setIausername(u.getUsername)
                System.out.println("inner upload");
			int success=0;
			PreparedStatement pstmt2 = con.prepareStatement("select max(id) as max_id from s.image");
			
	        ResultSet sR2 = pstmt2.executeQuery() ;
	        if(sR2.next()){
	        	id=sR2.getInt("max_id")+1;
                        System.out.println("got max id");
	        }
	        else
	        	id=1;
	        pstmt2.close();
	         PreparedStatement pstmt = con.prepareStatement("insert into s.image ( ID, IMAGEDATA ,"
	         		+ " PLACE, CAPTION, COPYRIGHT, HEIGHT, WIDTH , CATEGORY, VISIBLE_TO,"
	         		+ " IAUSERNAME , IALNAME ,iusername) values (?,?,?,?,?,?,?,?,?,?,?,?)");
	         iausername=iusername=u.getUsername();
	         setImagedata(inputStream);
	         pstmt.setInt(1,id); 
	         pstmt.setBytes(2,imagedata); 
	         pstmt.setString(3,place); this.place=place;
	         pstmt.setString(4,caption); this.caption=caption;
	         pstmt.setString(5,copyright); this.copyright=copyright;
	         System.out.println(height +" "+width);
	         pstmt.setInt(6,height); 
	         pstmt.setInt(7,width); 
	         pstmt.setInt(8,category); this.category=category;
	         pstmt.setInt(9,visible_to); this.visible_to=visible_to;
	         pstmt.setString(10,iausername);
	         ialname=albumname;
	         pstmt.setString(11,ialname);
	         pstmt.setString(12,iusername);
	         success =    pstmt.executeUpdate();
	         pstmt.close();
	         if(success>=1)
	         { 
	        	 setlikespulseviews();
	        	 return true;
	         
	         }
		
       
		return false;
	}
	private void setlikespulseviews() throws SQLException{
		PreparedStatement pstmt2 = con.prepareStatement("select likes,pulse,views from s.image where id=?");
		pstmt2.setInt(1,id);
        ResultSet sR2 = pstmt2.executeQuery() ;
        while(sR2.next()){
        	views=sR2.getInt("VIEWS");
        	likes=sR2.getInt("LIKES");
        	pulse=sR2.getInt("PULSE");
        }
        pstmt2.close();
	}
//	public void setId(int id) {
//		this.id = id;
//	}
	private void setHeight(int height) {
		this.height = height;
	}
	private void setWidth(int width) {
		this.width = width;
	}
//	
//	public void setViews(int views) {
//		this.views = views;
//	}
//	public void setPulse(int pulse) {
//		this.pulse = pulse;
//	}
//	public void setLikes(int likes) {
//		this.likes = likes;
//	}
	public void setCategory(int category) {
		this.category = category;
	}
	public void setVisible_to(int visible_to) {
		this.visible_to = visible_to;
	}
	public void setIausername(String iausername) {
		this.iausername = iausername;
	}
	public void setIalname(String ialbumname) {
		this.ialname = ialbumname;
	}

	public String getIusername() {
		return iusername;
	}

	public void setIusername(String iusername) {
		this.iusername = iusername;
	}
	
}
