package controller;

import java.io.File;

import com.opensymphony.xwork2.ActionSupport;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

public class uploadAction2 extends ActionSupport {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private String savePath;
    private File[] pic;
    private String[] picContentType;
    private String[] picFileName;

    public String fileUpload() {
        try {
            System.out.println(getSavePath()+"\\"+getPicFileName());
            for(int i=0;i<pic.length;i++) {
                FileUtils.copyFile(pic[i], new File(getSavePath() + "\\" + picFileName[i]));
            }
        } catch (Exception e) {
            //TODO: handle exception
        }
        return SUCCESS;
    }

    public String getSavePath() {
        return ServletActionContext.getServletContext().getRealPath(savePath);
    }
    public void setSavePath(String savePath) {
        this.savePath = savePath;
    }
    public File[] getPic() {
        return pic;
    }
    public void setPic(File[] pic) {
        this.pic = pic;
    }
    public String[] getPicContentType() {
        return picContentType;
    }
    public void setPicContentType(String[] picContentType) {
        this.picContentType = picContentType;
    }
    public String[] getPicFileName() {
        return picFileName;
    }
    public void setPicFileName(String[] picFileName) {
        this.picFileName = picFileName;
    }
}