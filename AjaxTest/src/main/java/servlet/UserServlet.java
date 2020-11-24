package servlet;

// import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

// @WebServlet("/userServlet")
public class UserServlet extends HttpServlet {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");

        //获取用户名信息
        String username=request.getParameter("username");
        PrintWriter out=response.getWriter();
        //利用isExistuser()方法判断输入的名字是否正确
        out.print(isExistuser(username));
        //重新加载
        out.flush();
        //关闭
        out.close();
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        doPost(request,response);
    }

    private boolean isExistuser(String username) {
        if("jack".equals(username)){
            return true;
        }
        else{
            return false;
        }
    }
}