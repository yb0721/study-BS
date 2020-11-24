package work;

import bean.User;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import services.UserOeration;
import services.impl.UserOerationImpl;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testUserJdbc()
    {
        User user=null;
        UserOeration userop=new UserOerationImpl();
        user=userop.getUser("root","123");
        assertEquals("root",user.getUname());//assertEquals查看两个对象是否相等
        assertEquals("123",user.getUpwd());
    }
}
