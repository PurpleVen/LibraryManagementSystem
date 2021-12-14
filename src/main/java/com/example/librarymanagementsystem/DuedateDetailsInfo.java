package com.example.librarymanagementsystem;

import java.util.Date;

public class DuedateDetailsInfo {
    String  memberid, membername, bookid;
    Date duedate;
    double fine;

    public DuedateDetailsInfo(String memberid, String membername, String bookname, Date duedate, double fine){
        this.memberid=memberid;
        this.membername=membername;
        this.bookid=bookname;
        this.duedate=duedate;
        this.fine=fine;

    }

    public String getMemberID(){
        return memberid;
    }

    public void setMemberID(){
        this.memberid=memberid;
    }

    public String getName(){
        return membername;
    }

    public void setName(){
        this.membername=membername;
    }

    public String getBookID(){
        return bookid;
    }

    public void setBookID(){ this.bookid=bookid; }

    public Date getReturnDate(){
        return duedate;
    }

    public void setReturnDate(){
        this.duedate=duedate;
    }

    public double getFine(){
        return fine;
    }

    public void setFine(){
        this.fine=fine;
    }

}
