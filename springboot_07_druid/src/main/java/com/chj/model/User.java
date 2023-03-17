package com.chj.model;


public class User {
    private Integer id;
    private String name;
    private Integer pwd;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", pwd=" + pwd +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPwd() {
        return pwd;
    }

    public void setPwd(Integer pwd) {
        this.pwd = pwd;
    }

    public User(Integer id, String name, Integer pwd) {
        this.id = id;
        this.name = name;
        this.pwd = pwd;
    }
}