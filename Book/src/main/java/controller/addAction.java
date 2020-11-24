package controller;

import javax.servlet.http.HttpServletRequest;

import com.opensymphony.xwork2.ActionSupport;

import org.apache.struts2.interceptor.ServletRequestAware;

import model.BookModel;

public class addAction extends ActionSupport implements ServletRequestAware {
    HttpServletRequest request;
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    public String excute() throws Exception {
        String name = request.getParameter("book.bookname");
        String author = request.getParameter("book.author");
        String introduced = request.getParameter("book.introduced");
        String press = request.getParameter("book.press");

        BookModel bm = new BookModel();
        if(bm.insert(name, author,introduced, press) == true) {
            return "success";
        }
        else {
            return "error";
        }
    }


    public void setServletRequest(HttpServletRequest request) {
        // TODO Auto-generated method stub
        this.request = request;

    }
    
}