package Service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import mappers.BookMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class BookTest {
    
    @Autowired
    private BookMapper bookMapper;

    @Test
    // public void deleteBook() {
        
    //     try {
    //         bookMapper.deleteBook(16);
    //         System.out.println("success");
    //     } catch (Exception e) {
    //         //TODO: handle exception
    //         System.out.println("error");
    //     }
    // }

    public void findBook() {

        try {
            bookMapper.findBook("撒野");
            System.out.println("success");
        } catch (Exception e) {
            //TODO: handle exception
            e.printStackTrace();
            System.out.println("error");
        }
        
    }

}