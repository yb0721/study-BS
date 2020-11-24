package services.impl;

import java.sql.*;

import Dao.BaseDao;
import bean.User;
import services.UserOeration;

public class UserOerationImpl extends BaseDao implements UserOeration {
    public User getUser(String uname, String upwd) {
        User user = null;
        String sql="select * from User where uname=? and upwd=?";
        conn=super.getCon();

        try {
            ps=conn.prepareStatement(sql);
            ps.setString(1,uname);
            ps.setString(2,upwd);
            super.rs=ps.executeQuery();
            user=new User();
            if(rs.next()){
                user.setUname(rs.getString("uname"));
                user.setUpwd(rs.getString("upwd"));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            closeAll(rs, conn, ps);
        }

        return user;
    }
}