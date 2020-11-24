package services;

import java.util.List;

import org.hibernate.*;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import entities.Empt;
import entities.User;

public class Test {
    public static void main(String[] args) {


        Configuration configuration = null;
        SessionFactory sessionFactory = null;
        Session session = null;
        Transaction tx = null;

        // try{
            
        //     configuration = new Configuration().configure();
        //     configuration.addResource("Hibernate.cfg.xml");


        //     StandardServiceRegistry serviceRegistry=new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
        //     sessionFactory=configuration.buildSessionFactory(serviceRegistry);

        //     session=sessionFactory.openSession();

        //     tx = session.beginTransaction();
        //     User dept = new User("市场销售部", "北京");
        //     Empt empt1 = new Empt("sehun");
        //     //Empt empt2 = new Empt("李五");

        //     //单向多对一
        //     // empt1.setDept(dept);
        //     // empt2.setDept(dept);

        //     //单向一对多
        //     // dept.getEmps().add(empt1);
        //     // dept.getEmps().add(empt2);

        //     //双向关联，双向一对多,只需要save(dept)
        //     empt1.setDept(dept);
        //     dept.getEmps().add(empt1);

        //     session.save(dept);
        //     //session.save(empt1);
        //     //session.save(empt2);
            
        //     tx.commit();
        // }

        // catch (HibernateException e) {
        //     //TODO: handle exception
        //     tx.rollback();
        //     e.printStackTrace();
        // }
        // finally {
        //     if(session!=null){
        //         session.close();
        //     }
        //     if(sessionFactory!=null){
        //         sessionFactory.close();
        //     }
        // }


        //HQL查询
        try {

            //第一步获取session对象
            session = HibernateUtil.getSession();

            //第二部编写HQL语句
            //实体类查找
            // String hql = "from Empt";
            //对象查找
            // String hql = "from Empt e where e.ename like:name";

            //投影映射
            //String hql = "select id,ename from Empt";
            String hql = "select new Empt(id, ename) from Empt";

            //第三步创建query对象
            Query query = session.createQuery(hql);
            //query.setString("name", "%sehun%");

            //第四步查询query结果集
            List<Empt> emps = query.list();
            for(Empt emp:emps) {
                System.out.println(emp.getEmpno() + ":" + emp.getEname());
            }

            // List<Object[]> emps = query.list();
            // for(Object[] emp:emps) {
            //     System.out.println(emp[0] + ":" + emp[1]);
            // }


            
        } catch (HibernateException e) {
            //TODO: handle exception
            e.printStackTrace();
        }
        finally {
            session.close();
        }


    }
}