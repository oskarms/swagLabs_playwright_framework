package utils;

public enum User {
    STANDARD("standard_user", "secret_sauce"),
    LOCKED_OUT("locked_out_user", "secret_sauce"),
    PROBLEM("problem_user", "secret_sauce"),
    NOT_EXIST("not_exist_user", "abcd*1234"),
    ERROR("error_user", "secret_sauce");

    final private String userLogin;
    final private String userPassword;

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


