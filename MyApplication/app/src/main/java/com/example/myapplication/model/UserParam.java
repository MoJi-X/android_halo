package com.example.myapplication.model;

public class UserParam {
    //@NotBlank(message = "用户名不能为空", groups = {CreateCheck.class, UpdateCheck.class})
    //@Size(max = 50, message = "用户名的字符长度不能超过 {max}", groups = {CreateCheck.class, UpdateCheck.class})
    private String username;

    //@NotBlank(message = "用户昵称不能为空", groups = {CreateCheck.class, UpdateCheck.class})
   // @Size(max = 255, message = "用户昵称的字符长度不能超过 {max}", groups = {CreateCheck.class, UpdateCheck.class})
    private String nickname;

    //@Email(message = "电子邮件地址的格式不正确", groups = {CreateCheck.class, UpdateCheck.class})
   // @NotBlank(message = "电子邮件地址不能为空", groups = {CreateCheck.class, UpdateCheck.class})
   // @Size(max = 127, message = "电子邮件的字符长度不能超过 {max}", groups = {CreateCheck.class, UpdateCheck.class})
    private String email;

   // @Null(groups = UpdateCheck.class)
   // @Size(min = 8, max = 100, message = "密码的字符长度必须在 {min} - {max} 之间", groups = {CreateCheck.class})
    private String password;

   // @Size(max = 1023, message = "头像链接地址的字符长度不能超过 {max}", groups = {CreateCheck.class, UpdateCheck.class})
    //头像链接地址
    private String avatar;

   // @Size(max = 1023, message = "用户描述的字符长度不能超过 {max}", groups = {CreateCheck.class, UpdateCheck.class})
    private String description;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
