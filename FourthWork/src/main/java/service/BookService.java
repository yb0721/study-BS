package service;

import java.util.List;

import entities.Book;

public interface BookService {
    
    public List<Book> listBook();

    public Integer addBook(Book book);

    public Integer deleteBook(Integer id);

    public Integer updateBook(Book book);

	public List<Book> findBook(String bookname);
}