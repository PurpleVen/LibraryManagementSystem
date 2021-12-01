package com.example.librarymanagementsystem;

import javax.xml.namespace.QName;

public class MemberDetailsinfo {
    String  name,   memberid, emailid, phoneno;

    public MemberDetailsinfo(String name, String memberid, String emailid, String phoneno){
        this.name= name;
        this.memberid=memberid;
        this.emailid=emailid;
        this.phoneno=phoneno;
    }

    public String getName(){
        return name;
    }

    public void setName(){
        this.name=name;
    }

    public String getMemberID(){
        return memberid;
    }

    public void setMemberID(){
        this.memberid=memberid;
    }

    public String getEmailID(){
        return emailid;
    }

    public void setEmailID(){
        this.emailid=emailid;
    }

    public String getPhoneNo(){
        return phoneno;
    }

    public void setPhoneNo(){
        this.phoneno=phoneno;
    }



}