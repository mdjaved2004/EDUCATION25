package com.education25.model.userModel.authModel;

public class LoginFormInformationModel {
    private String login_username;
    private String login_password;

    public LoginFormInformationModel(String login_username, String login_password) {
        this.login_username = login_username;
        this.login_password = login_password;
    }

    public String getLogin_username() {
        return login_username;
    }

    public void setLogin_username(String login_username) {
        this.login_username = login_username;
    }

    public String getLogin_password() {
        return login_password;
    }

    public void setLogin_password(String login_password) {
        this.login_password = login_password;
    }
}