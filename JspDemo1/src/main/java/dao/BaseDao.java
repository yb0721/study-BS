package dao;

import java.sql.*;

public class BaseDao{
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

     //执行SQL的增删改操作
     public int executeSQL(String sql,Object[] param){
        int rows=0;
        try {
            conn=getCon();
            ps=conn.prepareStatement(sql);
            if(param!=null){
                for(int i=0;i<param.length;i++){
                    ps.setString(i+1,param[i].toString());
                }
            }
            rows=ps.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            closeAll(null,conn,ps);//与上文的closeAll()中的参数顺序一致
        }
        return rows;
    }
}