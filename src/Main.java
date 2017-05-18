import java.sql.*;
import java.util.Scanner;

/**
 * Created by gerarddeharoramirez on 18/5/17.
 */
public class Main {

    static Scanner scanner = new Scanner(System.in); //Sirve para recoger texto por consola
    static int select = -1; //opción elegida del usuario
    static int num1 = 0, num2 = 0; //Variables

    public static void main(String[] args) {
        String table = "Players";

        //Creamos un Player
        //(FUNCIÓN COMENTADA)insertPlayerDatabase(13,"Geri","Suplex","City","steelChair!","broken@tables.com");

        //muestra la tabla de players
        //(FUNCION COMENTADA)testDatabse();

        //SELECCIONA UN PLAYER POR ID
        //(FUNCION COMENTADA)getPlayerById(7);

        //Borra un Player segun la ID
        //(FUNCION COMENTADA) deletePlayerById(13);








    }
    //EN ESTE TEST CONFIRMAMOS SI LA DATABASE FUNCIONA
    private static void testDatabse() {
        try{
            //SACAREMOS EL NOMBRE DE TODOS LOS PLAYERS
            //COGEMOS EL GETCONECTION() DE LA CLASS SINGLETON. OJO! TIENE QUE SER PUBLIC Y STATIC
        Connection connection = Singleton.getConnection();
        //DAMOS LA ORDEN DE SQL QUE SE QUIERE
        PreparedStatement statement = connection.prepareStatement("SELECT * from Players;");
            ResultSet resultSet = statement.executeQuery();
            ResultSetMetaData rsmd = resultSet.getMetaData();
            int numberOfColumns = rsmd.getColumnCount();

            System.out.println(numberOfColumns);

            //obtiene numero de columnas
            while (resultSet.next()) {
                for (int i = 1; i < numberOfColumns+1; i++){
                    String colValue = resultSet.getString(i);
                    System.out.println("\t");
                    System.out.println(colValue+" "+ rsmd.getColumnName(i));


                }

            }

                }

    catch (SQLException e){
        e.printStackTrace();
        }
    }
    private static void insertPlayerDatabase (int id ,String name,String apellido1,String apellido2, String password,String email) {
        try

        {   Connection con = Singleton.getConnection();

             PreparedStatement statement = con.prepareStatement("insert into Players (id, nombre, apellido1, apellido2, password, email)\n"
                     + "values (?,?,?,?,?,?);");

             statement.setInt(1, id);
            statement.setString(2, name);
            statement.setString(3, apellido1);
            statement.setString(4, apellido2);
            statement.setString(5, password);
            statement.setString(6, email);

            statement.executeUpdate();

            System.out.println("INSERT DONE");

        } catch (SQLException e) {

            e.printStackTrace();
        }
    }

    private static void getPlayerById(int id){
        try {
            Connection connection = Singleton.getConnection();
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM PLAYERS WHERE id = ?");

            statement.setInt(1, id);

            ResultSet resultSet = statement.executeQuery();
            ResultSetMetaData rsmd = resultSet.getMetaData();
           int numberOfColumns =  rsmd.getColumnCount();

            while (resultSet.next()){
                for (int i = 1; i<numberOfColumns + 1; i++){
                    System.out.println(resultSet.getString(i));

                }


            }

        }
        catch (SQLException e){
            e.printStackTrace();

        }

    }
//los delete necesitan un updateQuery
    private static void deletePlayerById (int id){
        try {
            Connection connection = Singleton.getConnection();
            PreparedStatement st = connection.prepareStatement(
                    "Delete from Players where id = ?"
            );
            st.setInt(1,id);
            st.executeUpdate();
            System.out.println("borrado el player con id"+" "+id);
        }
        catch (SQLException e){
            e.printStackTrace();
        }

    }

}




