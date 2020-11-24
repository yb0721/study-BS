package Services;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import entities.Dept;
import entities.Empt;
import mappers.DeptMapper;
import mappers.EmptMapper;

public class Test {

    public static void main(String[] args) throws IOException {
        
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession session = sqlSessionFactory.openSession();
        //DeptMapper mapper = session.getMapper(DeptMapper.class);
        EmptMapper mapper = session.getMapper(EmptMapper.class);


        listAll(mapper);

        session.commit();
        session.close();
    }

    // public static void add(DeptMapper mapper) {
    //     Dept depts = new Dept();
    //     depts.setDno(10);
    //     depts.setDname("设计部");
    //     mapper.add(depts);
    //     listAll(mapper);

    // }

    // public static void listAll(DeptMapper mapper) {
    //     List<Dept> dp = mapper.list();
    //     for(Dept d: dp) {
    //         System.out.println(d.getDname());
    //     }
    // }

    // public static void listAll(EmptMapper mapper) {
    //     List<Empt> emps = mapper.list();
    //     for(Empt emp:emps) {
    //         System.out.println(emp);
    //     }
    // }

    private static void listAll(EmptMapper mapper) {
        List<Empt> emps = mapper.list();
        for(Empt emp:emps) {
            System.out.println(emp.getEname());
            List<Dept> dept = emp.getDepts();
            for(Dept d: dept) {
                System.out.println("\t" + d.getDname());
            }
            
        }
    }
}