package com.example.librarymanagementsystem;

public class BookDetailsinfo {
    String  id, isbn, title,  author, genre;
    int quantity;

    public BookDetailsinfo(String id, String title, String isbn, String author, String genre, int quantity){
        this.id=id;
        this.title=title;
        this.isbn=isbn;
        this.author=author;
        this.genre=genre;
        this.quantity=quantity;
    }

    public String getBookID(){
        return id;
    }

    public void setBookID(){
        this.id=id;
    }

    public String getTitle(){
        return title;
    }

    public void setTitle(){
        this.title=title;
    }

    public String getBookISBN(){
        return isbn;
    }

    public void setBookISBN(){
        this.isbn=isbn;
    }

    public String getAuthor(){
        return author;
    }

    public void setAuthor(){
        this.author=author;
    }

    public String getGenre(){
        return genre;
    }

    public void setGenre(){
        this.genre=genre;
    }

    public int getNoOfCopies(){
        return quantity;
    }

    public void setNoOfCopies(){
        this.quantity=quantity;
    }


}
