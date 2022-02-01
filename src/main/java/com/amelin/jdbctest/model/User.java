package com.amelin.jdbctest.model;

public class User extends Entity{
    private String nickname;

    public User(Long id, String nickname) {
        super(id);
        this.nickname = nickname;
    }

    public User(String nickname) {
        this.nickname = nickname;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
}
