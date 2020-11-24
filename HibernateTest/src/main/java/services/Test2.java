package services;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import entities.Empt;
import entities.Privilege;
import entities.Role;

public class Test2 {

    public static void main(String[] args) {

        SessionFactory sessionFactory = null;
        Transaction tx = null;
        Session session = HibernateUtil.getSession();

        try {

            
            tx = session.beginTransaction();
            Role role1 = new Role("会计1");
            Role role2 = new Role("人事1");
            Privilege privilege1 = new Privilege("查询1");
            Privilege privilege2 = new Privilege("修改1");

            role1.getPrivileges().add(privilege1);
            role1.getPrivileges().add(privilege2);
            role1.getPrivileges().add(privilege1);
            role2.getPrivileges().add(privilege2);


            session.save(role1);
            session.save(role2);
            
            tx.commit();
        }

        catch (HibernateException e) {
            //TODO: handle exception
            tx.rollback();
            e.printStackTrace();
        }
        finally {
            HibernateUtil.closeSession(session);
        }

        try {

            //第一步获取session对象
            session = sessionFactory.openSession();

            //第二部编写HQL语句
            String hql = "from Empt";

            //第三步创建query对象
            Query query = session.createQuery(hql);

            //第四步查询query结果集
            List<Empt> emps = query.list();
            for(Empt emp:emps) {
                System.out.println(emp.getEmpno() + ":" + emp.getEname());
            }
            
        } catch (HibernateException e) {
            //TODO: handle exception
            e.printStackTrace();
        }
        finally {
            session.close();
            sessionFactory.close();
        }

    }
}