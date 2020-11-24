一、文件名要对应。
二、配置文件里面的bean，要知道哪个调用了哪个。在这里是UserBizeImpl调用了UserDao。
三、注解不要轻易使用，注解是简化配置文件，这里已经配置了就不使用注解（可以去看看注解的一些概念）。之前是用了@Service和@Autowired和@Repository。
四、在写测试代码的时候，文件命名不要直接使用Test.java，最好加上xxxTest.java，在测试代码中的方法前一定要使用@Test才会生效。
五、如果要使用日志管理，需要在resources中添加log4j.properties文件，文件中的内容无需更改，以后可以直接复制使用。