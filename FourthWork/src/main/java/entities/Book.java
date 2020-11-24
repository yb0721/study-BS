package entities;

public class Book {
    
    private Integer id;
    private String bookname;
    private String bookauthor;
    private String bookdes;

    public String toString() {
        return "book:" + "id="+ id + "bookname=" + bookname + "bookauthor=" + bookauthor + "bookdes=" + bookdes;
    }

    public int getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getBookname() {
        return bookname;
    }
    public void setBookname(String bookname) {
        this.bookname = bookname;
    }
    public String getBookauthor() {
        return bookauthor;
    }
    public void setBookauthor(String bookauthor) {
        this.bookauthor = bookauthor;
    }
    public String getBookdes() {
        return bookdes;
    }
    public void setBookdes(String bookdes) {
        this.bookdes = bookdes;
    }

}