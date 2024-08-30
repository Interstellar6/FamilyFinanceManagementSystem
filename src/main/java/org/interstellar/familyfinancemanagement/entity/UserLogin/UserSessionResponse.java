package org.interstellar.familyfinancemanagement.entity.UserLogin;

import lombok.Data;

import java.text.SimpleDateFormat;
import java.util.Date;

@Data
public class UserSessionResponse {
    private String token;
    private Integer userId;
    private String username;
    private Date date;
    private int status;
    private boolean isAdmin;
    private String description;

    static {
        SimpleDateFormat sdf = new SimpleDateFormat();
        sdf.applyPattern("yyyy-MM-dd HH:mm:ss a");
    }

    public UserSessionResponse(String token, Integer userId, String username,int status, boolean isAdmin,String description) {
        this.token = token;
        this.userId = userId;
        this.username = username;
        this.date = new Date();
        this.status = status;
        this.isAdmin = isAdmin;
        this.description = description;
    }

    public UserSessionResponse(String token, Integer userId, String username, boolean isAdmin) {
        this.token = token;
        this.userId = userId;
        this.username = username;
        this.date = new Date();
        this.isAdmin = isAdmin;
        this.status = 200;
        this.description = "Success";
        if(this.isAdmin){
            this.description="管理员登录";
        }
    }



}
