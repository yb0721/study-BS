package mappers;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import entities.Book;

public interface BookMapper {
    
    public List<Book> listBook();

    public Integer addBook(Book book);

    public Integer deleteBook(@Param(value = "id")Integer id);

    public Integer updateBook(Book book);

    public List<Book> findBook(@Param(value = "bookname")String bookname);


}