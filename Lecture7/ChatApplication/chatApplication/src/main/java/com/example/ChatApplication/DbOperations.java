package com.example.ChatApplication;

import java.sql.*;

public class DbOperations {

    private static Connection connection;
    private static String UsersTableName;
    private static String ChatBackupTableName;

    private static Connection getConnection() throws SQLException {

        if(connection == null){
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/chat_application", "root","chaman@123");
        }

        return connection;
    }

    public static void createUserTable(String users) throws SQLException {
        getConnection();
        Statement statement = connection.createStatement();
        UsersTableName = users;
        statement.execute("CREATE TABLE "+users+" (id int primary Key auto_increment, name VARCHAR(30), joining_date date)");
    }

    public static void createChatTable(String chat_backup) throws SQLException {
        getConnection();
        Statement statement = connection.createStatement();
        ChatBackupTableName = chat_backup;
        statement.execute("create table "+chat_backup+" (msg_id varchar(30) primary Key , name VARCHAR(30), msg VARCHAR(200))");
    }

    public static void addUserInDb(String user) throws SQLException {
        getConnection();

        PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO "+UsersTableName+" VALUES (null,?,?)");
        preparedStatement.setString(1,user);
        preparedStatement.setDate(2, new Date(System.currentTimeMillis()));
        preparedStatement.executeUpdate();
    }

    public static void saveMessage(String id, String userName, String message) throws SQLException {
        getConnection();

        PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO "+ChatBackupTableName+" VALUES (?,?,?)");
        preparedStatement.setString(1,id);
        preparedStatement.setString(2,userName);
        preparedStatement.setString(3, message);
        preparedStatement.executeUpdate();
    }
}
