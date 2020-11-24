package Services;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import entities.Empt;
import mappers.EmptMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class EmptTest {

    @Autowired
    private EmptMapper emptMapper;

    @Test
    public void testList() {
        List<Empt> ep = emptMapper.list();
        for(Empt e:ep) {
            System.out.println(e.getEname());
        }
    }
}