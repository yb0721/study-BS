package controller;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import com.opensymphony.xwork2.ActionSupport;

import org.apache.struts2.ServletActionContext;

public class uploadAction3 extends ActionSupport {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private String inputPath;
    private String fileName;
    
    public String getInputPath() {
        return inputPath;
    }

    public void setInputPath(String inpuPath) {
        this.inputPath = inpuPath;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public InputStream getInputStream() throws FileNotFoundException {
        String path = ServletActionContext.getServletContext().getRealPath(inputPath);
        return new BufferedInputStream(new FileInputStream(path + "\\" + getFileName()));
    }

    public void setInputStream(InputStream inputStream) {
    }
}