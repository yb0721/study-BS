package controller;

import java.io.File;
import java.io.IOException;

import com.opensymphony.xwork2.ActionSupport;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

public class uploadFileAction extends ActionSupport {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private String savePath;
    private File pic;
    private String picContentType;
    private String picFileName;

    public String uploadFile() {
        
        try {
            System.out.println(getSavePath() + "\\" + getPicFileName());
            FileUtils.copyFile(pic, new File(getSavePath() + "\\" + getPicFileName()));
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return SUCCESS;
    }

    public String getSavePath() {
        return ServletActionContext.getServletContext().getRealPath(savePath);
    }
    public void setSavePath(String savePath) {
        this.savePath = savePath;
    }
    public File getPic() {
        return pic;
    }
    public void setPic(File pic) {
        this.pic = pic;
    }
    public String getPicContentType() {
        return picContentType;
    }
    public void setPicContentType(String picContentType) {
        this.picContentType = picContentType;
    }
    public String getPicFileName() {
        return picFileName;
    }
    public void setPicFileName(String picFileName) {
        this.picFileName = picFileName;
    }
}