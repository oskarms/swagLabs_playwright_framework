package utils;

public enum User {
    STANDARD("standard_user", "secret_sauce"),
    PROBLEM("problem_user", "secret_sauce"),
    ERROR("error_user", "secret_sauce");

    private String userLogin;
    private String userPassword;

    User(String userLogin, String userPassword) {
        this.userLogin = userLogin;
        this.userPassword = userPassword;
    }

    public String getUserLogin() {
        return userLogin;
    }

    public String getUserPassword() {
        return userPassword;
    }
}


