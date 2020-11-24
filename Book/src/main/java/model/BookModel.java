package model;

import java.sql.SQLException;

import model.dao.BeasDao;

public class BookModel extends BeasDao {
    public boolean insert(String bookname, String author, String introduced, String press) {
        getCon();

        String sql = "insert into book(bookname,author,introduced,press)value(?,?,?,?)";

        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, bookname);
            ps.setString(2, author);
            ps.setString(3, introduced);
            ps.setString(4, press);
            int i = ps.executeUpdate();

            if(i > -1) {
                return true;
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return false;
        
    }
}