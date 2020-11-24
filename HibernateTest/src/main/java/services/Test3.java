package services;

import java.text.DecimalFormat;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import entities.Empt;

public class Test3 {

    public static void main(String[] args) {
        

        Session session = HibernateUtil.getSession();
        //排序查询
        try {
            
            //String hql = "select e from Empt e order by e.sal desc";

            //聚合函数
            //String hql = "select count(e) from Empt e";
            //String hql = "select max(e.sal),min(e.sal),avg(e.sal) from Empt e ";

            //分组查询
            //String hql = "select e.job,avg(e.sal) from Empt e group by e.job having e.job<>?";
            
            //子查询
            String hql = "from Empt where sal>(select avg(e.sal) from Empt e)";
            Query query = session.createQuery(hql);

            //分页查询
            //query.setFirstResult(0).setMaxResults(4);
            //List<Empt> emps = query.list();

            // for(Empt emp:emps) {
            //     System.out.println(emp.getEmpno() + ":" + emp.getEname());
            // }

            // Long count = (Long)query.uniqueResult();
            // System.out.println(count);
            // List<Object[]> emps = query.list();
            // for(Object emp:emps) {
            //     System.out.print(emp + ":");
            // }

            // query.setString(0, "vocal");
            // List<Object[]> sals = query.list();
            // for(Object[] sal:sals) {
            //     System.out.println("工作：" + sal[0] + "\t" + "平均工资" + new DecimalFormat("0.00").format((Double)sal[1]));
            // }

            List<Empt> sals = query.list();
            for(Empt emp:sals) {
                System.out.println("姓名：" + emp.getEname() + "\t" + "工资：" + emp.getSal());
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