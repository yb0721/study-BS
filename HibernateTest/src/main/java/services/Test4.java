package services;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import entities.Empt;

public class Test4 {
    public static void main(String[] args) {
        
        Session session = HibernateUtil.getSession();

        try {

            //HQL的表连接

            //内连接查询
            // String hql = "from Empt e inner join e.dept";
            // Query query = session.createQuery(hql);
            // List<Object[]> objects = query.list();

            // for(Object[] obj:objects) {
            //     System.out.println(obj[0]);
            //     System.out.println(obj[1]);
            // }


            //迫切内连接查询,迫切连接fetch使得结果集种仅包含Empt对象
            // String hql = "from Empt e inner join fetch e.dept";
            // Query query = session.createQuery(hql);
            // List<Empt> objects = query.list();
            // for(Empt emp:objects) {
            //     System.out.println(emp);
            // }

            //迫切左外连接查询
            String hql = "from Empt e left join fetch e.dept";
            Query query = session.createQuery(hql);
            List<Empt> objects = query.list();
            for(Empt emp:objects) {
                    System.out.println(emp);
                }
            
        } catch (HibernateException e) {
            //TODO: handle exception
            e.printStackTrace();
        }
        finally {
            HibernateUtil.closeSession(session);
        }

    }
}