package DAO;

import java.sql.*;

public class DataBase {
    private static final String USER_NAME = "root";
    private static final String Password = "root";
    private static final String URL = "jdbc:mysql://localhost:3306/train_schedule";
    private static Statement statement;
    private static Connection connection;

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            //Class.forName("something.jdbc.driver.YourFubarDriver");
            connection = DriverManager.getConnection(URL, USER_NAME, Password);
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
            throw new RuntimeException("Noi class ++ ==============");
        }
    }

    static {
        try {
            statement = connection.createStatement();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            throw new RuntimeException();
        }
    }

    public DataBase() throws SQLException {
    }
    public static Statement getStatement (){
        return statement;
    }

    public void readData () throws SQLException {
        ResultSet resultSet = statement.executeQuery ("SELECT * FROM  user");
        while (resultSet.next()){
            System.out.println(resultSet.getString(1) + " " +
                    resultSet.getString (2) + " " +
                    resultSet.getString (3) + " " +
                    resultSet.getString( 4)) ;
        }
    }
}
