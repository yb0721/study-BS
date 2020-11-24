package test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import entities.Car;
import entities2.impl.CarTE;
import entities2.impl.Count;

public class TestCar {
    public static void main(String[] args) {
        testCar();
    }

    public static void testCar() {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        // Car car = (Car) context.getBean("car");
        // car.run();
        CarTE car = (CarTE)context.getBean("car15auto");
        car.run();
        CarTE car2 = (CarTE)context.getBean("car18auto");
        car2.run();

        Count count = (Count)context.getBean("countnum");
        count.setNum(count.getNum()+1);
        System.out.println(count.getNum());
        Count count1 = (Count)context.getBean("countnum");
        count.setNum(count.getNum()+1);
        System.out.println(count1.getNum());

        System.out.println("count1对象是否就是count对象：" + (count1 == count));
    }
}