/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author flappy
 */
package org.dto;
    public class UserM {
    private String uname,fname,lname,email,mob_no,bdate,pswd,cpswd,sq,ans;
    public UserM()
    {
        fname=lname=email=mob_no=bdate=pswd=cpswd=sq=ans=null;
    }
    /**
     * @return the fname
     */
    public String getFname() {
        return fname;
    }

    /**
     * @param fname the fname to set
     */
    public void setFname(String fname) {
        this.fname = fname;
    }

    /**
     * @return the lname
     */
    public String getLname() {
        return lname;
    }

    /**
     * @param lname the lname to set
     */
    public void setLname(String lname) {
        this.lname = lname;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the mob_no
     */
    public String getMob_no() {
        return mob_no;
    }

    /**
     * @param mob_no the mob_no to set
     */
    public void setMob_no(String mob_no) {
        this.mob_no = mob_no;
    }

    /**
     * @return the bdate
     */
    public String getBdate() {
        return bdate;
    }

    /**
     * @param bdate the bdate to set
     */
    public void setBdate(String bdate) {
        this.bdate = bdate;
    }

    /**
     * @return the pswd
     */
    public String getPswd() {
        return pswd;
    }

    /**
     * @param pswd the pswd to set
     */
    public void setPswd(String pswd) {
        this.pswd = pswd;
    }

    /**
     * @return the cpswd
     */
    public String getCpswd() {
        return cpswd;
    }

    /**
     * @param cpswd the cpswd to set
     */
    public void setCpswd(String cpswd) {
        this.cpswd = cpswd;
    }

    /**
     * @return the sq
     */
    public String getSq() {
        return sq;
    }

    /**
     * @param sq the sq to set
     */
    public void setSq(String sq) {
        this.sq = sq;
    }

    /**
     * @return the ans
     */
    public String getAns() {
        return ans;
    }

    /**
     * @param ans the ans to set
     */
    public void setAns(String ans) {
        this.ans = ans;
    }

    /**
     * @return the uname
     */
    public String getUname() {
        return uname;
    }

    /**
     * @param uname the uname to set
     */
    public void setUname(String uname) {
        this.uname = uname;
    }
}
