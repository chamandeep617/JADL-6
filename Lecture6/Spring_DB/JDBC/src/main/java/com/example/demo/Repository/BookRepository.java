package com.example.demo.Repository;

import com.example.demo.Model.Book;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class BookRepository {

    private Connection connection;
    private String tableName = "myBooks";

    private void getConnection() throws SQLException {
        if(connection ==null){
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/books","root","chaman@123");
        }
    }

    private void closeConnection(){
        connection = null;
    }

    public String createTable(String table_name) throws SQLException {
        getConnection();

        this.tableName = table_name;

        Statement statement = connection.createStatement();
        boolean isSuccess = statement.execute("CREATE TABLE "+this.tableName+" (id INT primary key, book_name VARCHAR(20),author_name VARCHAR (30),cost INT)");

        if(isSuccess){
            System.out.println("Table "+this.tableName+" created Successfully");
        }else{
            System.out.println("Not able to create table with name "+this.tableName);
        }
//        closeConnection();
        return "Table Got created";
    }

    public String save(Book book) throws SQLException {

        getConnection();

        PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO "+this.tableName+" VALUES (?,?,?,?)");

        preparedStatement.setInt(1,book.getId());
        preparedStatement.setString(2,book.getName());
        preparedStatement.setString(3,book.getAuthorName());
        preparedStatement.setInt(4,book.getCost());

        int row = preparedStatement.executeUpdate();

        if(row < 1){
            System.out.println("Insertion of "+book.getName()+" is not successful");
            return "BOOK IS NOT INSERTED";
        }else{
            System.out.println("Insertion of "+book.getName()+" is successful");
            return "BOOK GOT INSERTED";
        }
    }

    public List<Book> getAllBooks() throws SQLException {
        getConnection();

        ArrayList<Book> books = new ArrayList<>();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM "+this.tableName);

        while(resultSet.next()){
            int id =resultSet.getInt(1);
            String name = resultSet.getString(2);
            String authorName = resultSet.getString(3);
            int cost = resultSet.getInt(4);

            Book book = new Book(name,id,authorName,cost);
            books.add(book);
        }
        return books;
    }

    public Book getBookWithId(int id) {
//        Leaving this for you guys to implement;
        return null;
    }


}
