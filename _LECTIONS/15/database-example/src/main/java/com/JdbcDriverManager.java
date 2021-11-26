package com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JdbcDriverManager {


    public static void main(String[] args) throws SQLException {
        String jdbcUrl = "jdbc:postgresql://localhost:6432/orion_test";

        try (final Connection connection = DriverManager.getConnection(jdbcUrl, "user_name", "your_password");) {

            final PreparedStatement preparedStatement = connection.prepareStatement("SELECT name, type typeAlias  FROM animal");

            final ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                final String name = resultSet.getString(1);
                final String type = resultSet.getString("typeAlias");
                System.out.println("name = " + name + ",type=" + type);
            }
        }
    }
}
