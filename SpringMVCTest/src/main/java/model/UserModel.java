package model;

import model.dao.BaseDao;
import java.sql.*;

public class UserModel extends BaseDao{
    public boolean isExistUser(String uname, String upwd) {
        
        getCon();
        String sql = "select * from user where uname=? and upwd=?";

        try {
            ps=conn.prepareStatement(sql);
            ps.setString(1, uname);
            ps.setString(2, upwd);
            rs = ps.executeQuery();

            if(rs.next()) {
                return true;
            } 
        }
        catch(SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}