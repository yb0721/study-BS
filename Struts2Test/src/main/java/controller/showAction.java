package controller;

import com.opensymphony.xwork2.ActionSupport;

import model.User;

public class showAction extends ActionSupport {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private User user;
    private String message;
    private String[] hobbies;
    private String[] number = new String[3];

    public String excute() {

        for(int i = 0;i < hobbies.length;i++) {
            System.out.println(hobbies[i]);
        }

        for(int j = 0;j < number.length;j++) {
            System.out.println(number[j]);
        }

        return SUCCESS;
    }

    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    public String[] getHobbies() {
        return hobbies;
    }
    public void setHobbies(String[] hobbies) {
        this.hobbies = hobbies;
    }
    public String[] getNumber() {
        return number;
    }
    public void setNumber(String[] number) {
        this.number = number;
    }

}