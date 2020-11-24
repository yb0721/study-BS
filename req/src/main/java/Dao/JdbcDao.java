package Dao;

import java.sql.*;

public class JdbcDao extends BaseDao{
    public boolean isExistUser(String uname, String pwd) {

        // Connection conn = null;
        // PreparedStatement ps = null;
        // ResultSet rs = null;

        // try {
        //     //加载驱动
        //     Class.forName("com.mysql.jdbc.Driver");
        //     conn = DriverManager.getConnection("jdbc:mysql://localhost:3307/people?useUnicode=true&characterEncoding=utf8", "root", "123");
            openDB();
            String sql = "select * from user where uname=? and upwd=?";
            try {
                ps=conn.prepareStatement(sql);
                ps.setString(1, uname);
                ps.setString(2, pwd);
                rs = ps.executeQuery();

                if(rs.next()) {
                    return true;
                } 
            }
            catch(SQLException e) {
                e.printStackTrace();
            }
            return false;

        //     if(rs.next()){
        //         return true;
        //         }
        //     }
        //     catch (Exception e){
        //         e.printStackTrace();
        //     }
        //     finally {
        //     try {
        //         if(rs!=null){
        //             rs.close();
        //         }
        //         if(ps!=null){
        //             ps.close();
        //         }
        //         if(conn!=null){
        //             conn.close();
        //         }
        //     }catch (Exception e){
        //         e.printStackTrace();
        //     }

        // }
        // return false;
        }
}