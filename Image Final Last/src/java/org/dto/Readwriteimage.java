package org.dto;
import java.io.*;
/**
 *
 * @author ankursmooth
 */
public class Readwriteimage {

	 public byte[] getBytes(InputStream is) throws IOException {

    int len;
    int size = 1024;
    byte[] buf;

    if (is instanceof ByteArrayInputStream) {
      size = is.available();
      buf = new byte[size];
      len = is.read(buf, 0, size);
    } else {
      ByteArrayOutputStream bos = new ByteArrayOutputStream();
      buf = new byte[size];
      while ((len = is.read(buf, 0, size)) != -1)
        bos.write(buf, 0, len);
      buf = bos.toByteArray();
    }
    return buf;
  }
 
        public byte[] readImage(String filename) {

	      byte[]  imageData = null;
	      FileInputStream file = null;
	      try {
	           file = new FileInputStream(filename);
	           int size = file.available();
	           imageData = new byte[size];
	           file.read(imageData);
	      } catch (FileNotFoundException e) {
	           e.printStackTrace();
	               } catch (IOException e) {
	           e.printStackTrace();
	      } finally {
	           try {
	                if (file != null) file.close();
	               } catch (IOException e) {
	                e.printStackTrace();
	                 }
	             }
	          return imageData;
	      }
	 public void makdir(String username){
		 File file = new File(".\\"+username);
		 file.mkdir();
	 }
	 private void delete(File f) {
		  if (f.isDirectory()) {
		    for (File c : f.listFiles())
		      delete(c);
		  }
		  f.delete();
		}
	 public void deldir(String tobedeleted){
		 File file = new File(tobedeleted);
		 delete(file);
		 
	 }
	 public void writeImage(byte[] imageData, String pathtofile) {

		 FileOutputStream file = null;
	     try {
	          file = new FileOutputStream(pathtofile);
	          file.write(imageData);
	     } catch (FileNotFoundException e) {
	          e.printStackTrace();
	              } catch (IOException e) {
	          e.printStackTrace();
	     } finally {
	          try {
	               if (file != null) file.close();
	              } catch (IOException e) {
	               e.printStackTrace();
	                }
	            }
	}
	}


