package model.dao;

import java.sql.*;

public class BaseDao {
    private static final String DRIVER = "com.mysql.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3307/people?useUnicode=true&characterEncoding=utf8";
    private static final String USER = "root";
    private static final String PWD = "123";

    protected Connection conn;
    protected PreparedStatement ps;
    protected ResultSet rs;

    //建立数据库连接
    public Connection getCon(){
        try {
            Class.forName(DRIVER);
            conn= DriverManager.getConnection(URL,USER,PWD);
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return conn;
    }

    public static void closeAll(ResultSet rs, Connection conn, Statement st) {
        try{
            if(rs!=null) {
                rs.close();
            }
            if(conn!=null) {
                conn.close();
            }
            if(st!=null) {
                st.close();
            }
        }catch(SQLException e) {
            e.printStackTrace();
        }
    }
}