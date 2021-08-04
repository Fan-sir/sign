package com.xk.sign.bean;

public class UserInfo {
    private Integer id;
    private String realName;
    private String classes;
    private String phone;
    private String qq;
    private User user;

    public String getClasses() {
        return classes;
    }

    public void setClasses(String classes) {
        this.classes = classes;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "id=" + id +
                ", realName='" + realName + '\'' +
                ", classes='" + classes + '\'' +
                ", phone='" + phone + '\'' +
                ", qq='" + qq + '\'' +
                ", user=" + user +
                '}';
    }
}
