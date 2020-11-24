package controller;

import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class controller extends HttpServlet {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private Map<String, Action> actionMap = new HashMap<String, Action>();// 新建actionMap管理Action

    public void init(ServletConfig config) {
        Enumeration enumeration = config.getInitParameterNames();// 通过config获取初始化参数，参数位于web.xml中
        while (enumeration.hasMoreElements()) {                  //循环查找参数
            String paramName = (String) enumeration.nextElement(); //通过enumeration方法获取参数的名称，将其定义为paramName
            String paramValue = config.getInitParameter(paramName);//讲定义为paramName的参数的值定义为paramValue
            try {
                Class clz = Class.forName(paramValue);//传入参数值
                try {
                    Action action = (Action)clz.newInstance();//通过clz.newInstance创建对象
                    actionMap.put(paramName, action);//将值及参数名称封装进actionMap中
                } catch (InstantiationException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            } catch (ClassNotFoundException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

    //实现用户请求接收与处理
    public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        response.setCharacterEncoding("utf-8");

        //获取地址内容
        String reqPath = request.getRequestURI();
        //拆分地址: /login.action,-7为后七位
        reqPath = reqPath.substring(reqPath.lastIndexOf("/")+1, reqPath.length()-7);
        //在actionMap中找到相对应的reqPath请求
        Action action = this.actionMap.get(reqPath);
        //传递request，response参数
        String path = action.execute(request, response);
        request.getRequestDispatcher(path).forward(request, response);        
    }
}