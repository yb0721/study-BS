package model;

import java.sql.SQLException;

import model.dao.BeasDao;

public class LoginModel extends BeasDao {
    public boolean Login(String uname, String upwd) {
        getCon();
        String sql = "select * from user where uname=? and upwd=?";

        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, uname);
            ps.setString(2, upwd);
            rs = ps.executeQuery();

            if(rs.next()) {
                return true;
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return false;
    }

    public boolean Reg(String uname, String upwd) {
        getCon();
        String sql = "insert into user(uname,upwd)value(?,?)";

        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, uname);
            ps.setString(2, upwd);
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