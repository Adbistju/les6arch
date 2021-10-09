package Adbistju.system.Service;

import java.sql.Connection;
import java.sql.DriverManager;

public class CustomConnectionMysql {

    public static Connection connection;

    public static void createConnection(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/figure","root","root");
        }catch(Exception e){
            System.out.println(e);
        }
    }

    public static Connection getConnection(){
        return connection;
    }

    public static void closeConnection(){
        try{
            connection.close();
        }catch(Exception e){
            System.out.println(e);
        }

    }


}
