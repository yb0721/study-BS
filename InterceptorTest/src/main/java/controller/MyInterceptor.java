package controller;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class MyInterceptor extends AbstractInterceptor {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @Override
    public String intercept(ActionInvocation invocation) throws Exception {
        // TODO Auto-generated method stub

        //第一个拦截器所需要实现的功能
        System.out.println("进入拦截器1！");
        long starttime = System.currentTimeMillis();
        String result = invocation.invoke();

        long endtime = System.currentTimeMillis();

        System.out.println("执行时间："+(endtime-starttime));
        System.out.println("退出拦截器1！");

        return result;
    }
    
}