package controller;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class MyInterceptor2 extends AbstractInterceptor {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @Override
    public String intercept(ActionInvocation invocation) throws Exception {
        // TODO Auto-generated method stub

        //第二个拦截器所需要实现的功能
        System.out.println("进入拦截器2！");

        //获取第一次当前时间
        long time = System.currentTimeMillis();
        String re = invocation.invoke();

        //获取第二次的当前时间
        long endtime = System.currentTimeMillis();

        //计算所需的时间
        System.out.println("执行时间2："+(endtime-time));
        System.out.println("退出拦截器2！");

        return re;
    }
    
}