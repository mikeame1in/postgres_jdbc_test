package com.amelin.jdbctest;

import com.amelin.jdbctest.dal.UserGateway;
import com.amelin.jdbctest.model.User;

import java.util.List;

public class DbClient {
    public static void main(String[] args) {
        addUser(new User("mike"));
    }

    public static void getAllUsers() {
        UserGateway userGateway = new UserGateway();

        List<User> users = userGateway.getAllUsers();

        for (User user: users) {
            System.out.println(user.getId() + " " + user.getNickname());
        }
    }

    public static void getUser(Long id) {
        UserGateway userGateway = new UserGateway();

        User user = userGateway.findUserById(id);

        System.out.println(user.getId() + " " + user.getNickname());
    }

    public static void addUser(User user) {
        UserGateway userGateway = new UserGateway();

        userGateway.createUser(user);
    }



}
