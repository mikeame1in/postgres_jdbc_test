package com.amelin.jdbctest.dal;

import com.amelin.jdbctest.model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserGateway {

    public UserGateway() {}

    public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();

        try (Connection connection = ConnectionCreator.createConnection()) {
             Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM users");
            while (resultSet.next()) {
                long id = resultSet.getInt(1);
                String nickname = resultSet.getString(2);
                users.add(new User(id, nickname));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return users;
    }

    public User findUserById(Long id) {
        User user = new User(new Long(-1), "empty_user");

        try (Connection connection = ConnectionCreator.createConnection()) {
            String sql = "SELECT * FROM users WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setLong(1, id);

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                long userId = resultSet.getInt(1);
                String nickname = resultSet.getString(2);
                user = new User(userId, nickname);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return user;
    }

    public void createUser(User user) {
        try (Connection connection = ConnectionCreator.createConnection()) {
            String sql = "INSERT INTO users(nickname) VALUES (?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, user.getNickname());

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
