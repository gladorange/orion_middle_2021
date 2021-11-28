package com;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

import org.postgresql.ds.PGPoolingDataSource;
import org.postgresql.ds.PGSimpleDataSource;

import lombok.SneakyThrows;

public class JdbcTest {

    @SneakyThrows
    public static void main(String[] args) {
        String jdbcUrl = "jdbc:postgresql://localhost:6432/orion_test";

        PGSimpleDataSource ds = new PGSimpleDataSource();
        ds.setUrl(jdbcUrl);
        ds.setUser("user_name");
        ds.setPassword("your_password");

        try (Connection connection = ds.getConnection()) {
            connection.setAutoCommit(false);

            final Statement insertStatement = connection.createStatement();
            insertStatement.executeUpdate("INSERT INTO animal VALUES ('Sharik2','dog')");


            final PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM animal where type=? ");
            preparedStatement.setString(1,"dog");

            System.out.println("DOGS");
            final ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                System.out.println("name = " + resultSet.getString(1));
            }

            System.out.println("CATS");
            preparedStatement.setString(1,"cat");
            final ResultSet resultSet2 = preparedStatement.executeQuery();
            while (resultSet2.next()) {
                System.out.println("name = " + resultSet2.getString(1));
            }


            final Statement statement =connection .createStatement();
            statement.executeUpdate("DELETE FROM animal");
            connection.commit();
        }
    }
}
