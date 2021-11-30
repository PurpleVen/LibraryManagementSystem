package com.example.librarymanagementsystem;

import java.util.Date;

public class IssueDetailsInfo {
    int bookid, memberid;
    Date issuedate, returndate;

    public IssueDetailsInfo(int bookid, int memberid, Date issuedate, Date returndate){
        this.bookid=bookid;
        this.memberid=memberid;
        this.issuedate=issuedate;
        this.returndate=returndate;
    }

    public int getBookID(){
        return bookid;
    }

    public void setBookID(){
        this.bookid=bookid;
    }

    public int getMemberID(){
        return memberid;
    }

    public void setMemberID(){
        this.memberid=memberid;
    }

    public Date getIssueDate(){
        return issuedate;
    }

    public void setIssueDate(){
        this.issuedate=issuedate;
    }

    public Date getReturnDate(){
        return returndate;
    }

    public void setReturnDate(){
        this.returndate=returndate;
    }
}

