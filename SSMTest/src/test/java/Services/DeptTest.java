package Services;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import entities.Dept;
import mappers.DeptMapper;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class DeptTest {

    @Autowired
    private DeptMapper deptMapper;

    @Test
    public void testList() {
        List<Dept> dp = deptMapper.listDept();
        for(Dept d:dp) {
            System.out.println(d.getDname());
        }
    }
}