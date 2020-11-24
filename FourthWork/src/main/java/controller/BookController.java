package controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import entities.Book;
import entities.User;
import service.BookService;

@Controller
@RequestMapping("/book")
public class BookController {

    @Autowired
    private BookService bookService;

    @RequestMapping(value = "listBook")
    public String listBook(@RequestParam(value = "page",defaultValue = "1")int page,Model model, HttpSession session) {
        
        //接收值
        Object user = session.getAttribute("u");
        if(user != null) {
            PageHelper.startPage(page, 7);
            List<Book> books = bookService.listBook();
            PageInfo pageInfo = new PageInfo(books, 7);
            model.addAttribute("pageInfo", pageInfo);

            return "book";
        }
        else {
            return "redirect:/index.jsp";
        }

    }

    @RequestMapping(value = "addBook", method = RequestMethod.POST,produces = "text/html;charset=utf-8")
    public String addBook(String bookname, String bookauthor, String bookdes) {

        Book book = new Book();
        book.setBookname(bookname);
        book.setBookauthor(bookauthor);
        book.setBookdes(bookdes);

        try {
            bookService.addBook(book);
            return "redirect:/book/listBook";
        } catch (Exception e) {
            //TODO: handle exception
            e.printStackTrace();
            return "error";
        }
    }

    @RequestMapping(value = "deleteBook", method = RequestMethod.POST, produces = "text/html;charset=utf-8")
    @ResponseBody
    public String deleteBook(Integer id) {
        try {
            System.out.println(id);
            bookService.deleteBook(id);
            return "success";
        } catch (Exception e) {
            //TODO: handle exception
            e.printStackTrace();
            return "error";
        }
    }

    @RequestMapping(value = "updateBook", method = RequestMethod.POST, produces = "text/html;charset=utf-8")
    @ResponseBody
    public String updateBook(int id,String bookname, String bookauthor, String bookdes) {
        try {
            Book book = new Book();
            book.setId(id);
            book.setBookname(bookname);
            book.setBookauthor(bookauthor);
            book.setBookdes(bookdes);
            bookService.updateBook(book);
            System.out.println("success");
            return "success";
        } catch (Exception e) {
            //TODO: handle exception
            e.printStackTrace();
            return "error";
        }

    }

    @RequestMapping(value = "findBook")
    public String findBook(@RequestParam(value = "page",defaultValue = "1")int page,String bookname, Model model) {
        
        List<Book> book = bookService.findBook(bookname);
        PageHelper.startPage(page, 1);
        PageInfo pageInfo = new PageInfo(book, 1);
        model.addAttribute("pageInfo", pageInfo);

        return "book";

    }
    
}