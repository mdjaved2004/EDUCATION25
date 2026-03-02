package com.education25.model.userModel.authModel;

public class UserModel {
    private int user_id;
    private String user_name;
    private String user_email;
    private String user_username;

    public UserModel(int user_id, String user_name, String user_email, String user_username) {
        this.user_id = user_id;
        this.user_name = user_name;
        this.user_email = user_email;
        this.user_username = user_username;
    }

    public int getUser_id() {
        return user_id;
    }
    public String getUser_name() {
        return user_name;
    }
    public String getUser_email() {
        return user_email;
    }
    public String getUser_username() {
        return user_username;
    }
}