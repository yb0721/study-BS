package controller;

import com.opensymphony.xwork2.ActionSupport;

import model.enties.Book;

public class showAction extends ActionSupport {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private Book book;

    public String excute() {
        return SUCCESS;
    }
    
    public Book getBook() {
        return book;
    }
    public void setBook(Book book) {
        this.book = book;
    }
}