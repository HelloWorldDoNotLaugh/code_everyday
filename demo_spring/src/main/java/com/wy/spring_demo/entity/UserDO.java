package com.wy.spring_demo.entity;


/**
 * @author HelloWorld
 * @date 2023/8/21 22:29
 * @email helloworld.dng@gmail.com
 */
public class UserDO {

    private String userName;

    private String password;

    private String nickName;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }
}
