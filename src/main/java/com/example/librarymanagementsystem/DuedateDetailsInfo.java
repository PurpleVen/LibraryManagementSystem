package com.example.librarymanagementsystem;

import java.util.Date;

public class DuedateDetailsInfo {
    String  memberid, membername, bookname;
    Date duedate;
    double fine;

    public DuedateDetailsInfo(String memberid, String membername, String bookname, Date duedate, double fine){
        this.memberid=memberid;
        this.membername=membername;
        this.bookname=bookname;
        this.duedate=duedate;
        this.fine=fine;

    }

    public String getBookID(){
        return memberid;
    }

    public void setBookID(){
        this.memberid=memberid;
    }

    public String getTitle(){
        return membername;
    }

    public void setTitle(){
        this.membername=membername;
    }

    public String getBookISBN(){
        return bookname;
    }

    public void setBookISBN(){ this.bookname=bookname; }

    public Date getAuthor(){
        return duedate;
    }

    public void setAuthor(){
        this.duedate=duedate;
    }

    public double getGenre(){
        return fine;
    }

    public void setGenre(){
        this.fine=fine;
    }

}
