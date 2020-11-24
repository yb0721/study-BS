package controller;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport {
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private String username;
     //获取字节流
    private InputStream inputStream;

    @Override
    public String execute() throws Exception {
        if("jack".equals(username)) {
            //将字节流转化成字符流，并指定字符集
            inputStream=new ByteArrayInputStream("success".getBytes("UTF-8"));
        }
        else {
            inputStream=new ByteArrayInputStream("error".getBytes("UTF-8"));
        }
        return "success";
    }

    public String getUsername() {
        return username;
    }
    public void setUsername(String usename) {
        this.username = usename;
    }
    public InputStream getInputStream() {
        return inputStream;
    }
    public void setInputStream(InputStream inputStream) {
        this.inputStream = inputStream;
    }
}