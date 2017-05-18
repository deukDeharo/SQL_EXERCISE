


/**
 * Created by gerarddeharoramirez on 18/5/17.
 */


import java.sql.*;
public class Singleton {




    private static Connection connection = null;

    private Singleton() { }

    public static Connection getConnection(){

        if (connection == null){
            try {
                String url = "jdbc:mysql://127.0.0.1:8889/battleship";
                String usr ="root" ;
                String password = "root";
                String driver = "com.mysql.jdbc.Driver";

                Class.forName(driver);


                connection = DriverManager.getConnection(url,usr,password);
            }

           catch (SQLException e)
           {

                e.printStackTrace();
           }
           catch (ClassNotFoundException e)
           {
               e.printStackTrace();
           }


        }

        return connection;
    }

}
