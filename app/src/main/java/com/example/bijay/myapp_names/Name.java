package com.example.bijay.myapp_names;

/**
 * Created by Bijay on 12-05-2016.
 */
public class Name {

    private int id;
    private String fname;
    private String lname;

    public Name(){}

    public Name(String fname, String lname){
        super();
        this.fname = fname;
        this.lname = lname;
    }

    public int getId(){return id;}
    public void setId(int id) {this.id=id;}
    public String getFname(){return fname;}
    public void setFname(String fname){this.fname=fname;}
    public String getLname(){return lname;}
    public void setLname(String lname){this.lname=lname;}

    @Override
    public String toString() {
        //return "Id = "+ id + " First Name = " + fname + " Last Name = " + lname;
        return id + " " + fname + " " + lname;
    }

}
