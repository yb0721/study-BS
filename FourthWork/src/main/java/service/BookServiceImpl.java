package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import entities.Book;
import mappers.BookMapper;

@Service
public class BookServiceImpl implements BookService {
    
    @Autowired
    private BookMapper bookMapper;

    public List<Book> listBook() {
        // TODO Auto-generated method stub
        return bookMapper.listBook();
    }

    public Integer addBook(Book book) {
        // TODO Auto-generated method stub
        return bookMapper.addBook(book);
    }

    public Integer deleteBook(Integer id) {
        // TODO Auto-generated method stub
        return bookMapper.deleteBook(id);
    }

    public Integer updateBook(Book book) {
        // TODO Auto-generated method stub
        return bookMapper.updateBook(book);
    }

    public List<Book> findBook(String bookname) {
        // TODO Auto-generated method stub
        return bookMapper.findBook(bookname);
    }

   
}