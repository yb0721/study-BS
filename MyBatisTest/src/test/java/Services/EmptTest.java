package Services;

import java.io.IOException;
import java.io.Reader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import entities.Dept;
import entities.Empt;

public class EmptTest {
    @Test
    // public void search() {
    //     Reader reader = null;
    //     SqlSession session = null;
    //     SqlSessionFactory sqlSessionFactory = null;

    //     try {

    //         //使用MyBatis提供的Resources类加载mybatis的配置文件
    //         reader = Resources.getResourceAsReader("mybatis-config.xml");

    //         //构建sqlSession的工厂
    //         sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
    //         session = sqlSessionFactory.openSession();

            //新增
            // Empt emp1 = new Empt();
            // emp1.setEname("Luhan");

            // session.insert("addEmpt", emp1);

            //删除
            // Empt emp1 = new Empt();
            // emp1.setEmpno(5);

            // session .delete("deleteEmpt", emp1);

            //根据条件查询
            // Empt emp2 = session.selectOne("getEmpt", 3);
            // System.out.println(emp2.getEname());

            //修改
            // Empt emp3 = session.selectOne("getEmpt", 3);
            // emp3.setEname("jack");
            // session.update("updateEmpt", emp3);

            // List<Empt> emps = session.selectList("listEmpt");

            // for(Empt emp:emps) {
            //     System.out.println(emp);
            // }

            //模糊查询
            // List<Empt> emps = session.selectList("listEmptByName", "jack");
            // for(Empt e:emps) {
            //     System.out.println(e.getEname());
            // }

            //多条件查询
            // Map<String, Object> params = new HashMap<String,Object>();
            // params.put("empno", 6);
            // params.put("ename", "Luhan");
            // List<Empt> emps = session.selectList("listEmptByNameANDbyID", params);
            // for(Empt e:emps) {
            //     System.out.println(e.getEname());
            // }

            //一对多条件查询
        //     List<Dept> depts = session.selectList("listDeptAndEmpt");
        //     for(Dept d:depts) {
        //         System.out.println(d);
        //         List<Empt> emps = d.getEmps();
        //         for(Empt e:emps) {
        //             System.out.println("\t" + e);
        //         }
        //     }


        //     session.commit();
            
        // } catch (IOException e) {
        //     //TODO: handle exception
        //     e.printStackTrace();
        // } finally {
        //     try {
                
        //         session.close();
        //         reader.close();

        //     } catch (IOException e) {
        //         //TODO: handle exception
        //         e.printStackTrace();
        //     }
        // }
    //}

    public void listEmpt() {

        Reader reader = null;
        SqlSession session = null;
        SqlSessionFactory sqlSessionFactory = null;

        try {

            //使用MyBatis提供的Resources类加载mybatis的配置文件
            reader = Resources.getResourceAsReader("mybatis-config.xml");

            //构建sqlSession的工厂
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
            session = sqlSessionFactory.openSession();

            // List<Empt> emps = session.selectList("listEmpt");
            // for(Empt e:emps) {
            //     System.out.println(e + "\t" + e.getDepts());

            // }

            HashMap param = new HashMap<String,Object>();
            param.put("ename", "sehun");

            List<Empt> emps = session.selectList("listEmp" , param);
            for(Empt emp:emps) {
                System.out.println(emp);
            }

            session.commit();
            
        } catch (IOException e) {
            //TODO: handle exception
            e.printStackTrace();
        } finally {
            try {
                
                session.close();
                reader.close();

            } catch (IOException e) {
                //TODO: handle exception
                e.printStackTrace();
            }
        }
    }

}