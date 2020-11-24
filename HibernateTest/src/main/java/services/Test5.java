package services;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Property;
import org.hibernate.criterion.Restrictions;

import entities.Empt;

public class Test5 {

    private static Session session;

    public static void main(String[] args) {

        try {

            Session session = HibernateUtil.getSession();

            // 使用QBC查询
            // Criteria criteria = session.createCriteria(Empt.class);
            // List<Empt> emps = criteria.list();

            // for(Empt emp:emps) {
            // System.out.println(emp);
            // }

            // 排序查询
            // criteria.addOrder(Order.desc("sal"));
            // List<Empt> emps = criteria.list();
            // for(Empt emp:emps) {
            // System.out.println(emp);
            // }

            // 分页查询
            // criteria.addOrder(Order.desc("sal"));
            // criteria.setFirstResult(3).setMaxResults(3);
            // List<Empt> emps = criteria.list();
            // for(Empt emp:emps) {
            // System.out.println(emp);
            // }

            // 单条件查询
            // criteria.add(Restrictions.eq("job", "singer"));
            // List<Empt> emps = criteria.list();
            // for(Empt emp:emps) {
            // System.out.println(emp);
            // }

            // 多条件查询
            // Empt emp = new Empt();
            // emp.setEmpno(4);
            // emp.setEname("sehun");
            // emp.setSal(10000);

            // Criteria criteria = session.createCriteria(Empt.class);
            // criteria.add(Example.create(emp));
            // List<Empt> emps = criteria.list();
            // for(Empt e:emps) {
            // System.out.println(e);
            // }

            // 表连接查询
            // Criteria criteria =
            // session.createCriteria(Empt.class).createCriteria("dept");
            // criteria.add(Restrictions.eq("dname", "信息部"));
            // List<Empt> emps = criteria.list();
            // for(Empt emp:emps) {
            // System.out.println(emp);
            // }

            // 聚合函数
            // Criteria criteria = session.createCriteria(Empt.class);
            // criteria.setProjection(Projections.count("empno"));
            // Long count = (Long) criteria.uniqueResult();
            // System.out.println(count);

            // Criteria criteria = session.createCriteria(Empt.class);
            // ProjectionList projectionList = Projections.projectionList();
            // projectionList.add(Projections.max("sal"));
            // projectionList.add(Projections.min("sal"));
            // projectionList.add(Projections.avg("sal"));
            // criteria.setProjection(projectionList);
            // Object[] sals = (Object[]) criteria.uniqueResult();
            // System.out.println("max_Sal:" + sals[0] + " min_Sal:" + sals[1] + " avg_Sal:" + sals[2]);

            //分离查询

            
            //子查询
            DetachedCriteria avgSalary = DetachedCriteria.forClass(Empt.class).setProjection(Property.forName("sal").avg());
            List<Empt> emps = session.createCriteria(Empt.class).add(Property.forName("sal").gt(avgSalary)).list();
            for(Empt emp:emps) {
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