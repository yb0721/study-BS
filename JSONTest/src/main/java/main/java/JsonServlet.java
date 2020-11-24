package main.java;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/JsonServlet")
public class JsonServlet extends HttpServlet {
    /**
     *
     */
    private static final long serialVersionUID = -1263316127925944210L;

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setCharacterEncoding("utf-8");
        response.setContentType("textml;charset=utf-8");

        Depart depart1=new Depart();
        depart1.setDno(1);
        depart1.setDname("信息技术部");
        depart1.setLoc("北京");
        Depart depart2=new Depart();
        depart2.setDno(2);
        depart2.setDname("业务市场部");
        depart2.setLoc("广州");
        Depart depart3=new Depart();
        depart3.setDno(3);
        depart3.setDname("财务部");
        depart3.setLoc("深圳");

        List departs=new ArrayList();
        departs.add(depart1);
        departs.add(depart2);
        departs.add(depart3);

        PrintWriter out = response.getWriter();
        out.print(JSONArray.fromObject(departs));
        out.flush();
        out.close();
    }
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        doPost(request,response);
    }
}