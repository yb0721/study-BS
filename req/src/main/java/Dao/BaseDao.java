package Dao;

import java.sql.*;

public class BaseDao{
    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    public boolean openDB() {
        try {
            //加载驱动
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3307/people?useUnicode=true&characterEncoding=utf8", "root", "123");
            }
            catch (Exception e){
                e.printStackTrace();
                return false;
            }
            return true;
        }

    public boolean closeDB(){
            try {
                if(rs!=null){
                    rs.close();
                }
                if(ps!=null){
                    ps.close();
                }
                if(conn!=null){
                    conn.close();
                }
            }catch (Exception e){
                e.printStackTrace();
                return false;
            }
            return true;
        }
}