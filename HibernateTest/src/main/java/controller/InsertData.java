package controller;

import org.hibernate.cfg.Configuration;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import entities.User;

public class InsertData {
    static Configuration configuration = null;
    static SessionFactory sessionFactory = null;
    static Session session = null;
    static Transaction tx = null;

    public static void main(String[] args) {
        try {
            
            //读取配置文件
            configuration = new Configuration().configure();
            configuration.addResource("Hibernate.cfg.xml");

            //创建会话工厂
            StandardServiceRegistry serviceRegistry=new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
            sessionFactory=configuration.buildSessionFactory(serviceRegistry);

            //创建会话
            session=sessionFactory.openSession();

            //开始进行事物操作；
            tx = session.beginTransaction();
            User dept=new User("财务部","江西");
            session.save(dept);
            tx.commit();

        } 
        catch (HibernateException e) {
            //TODO: handle exception
            tx.rollback();
            e.printStackTrace();
        }
        finally {
            if(session!=null){
                session.close();
            }
            if(sessionFactory!=null){
                sessionFactory.close();
            }
        }
    }
}