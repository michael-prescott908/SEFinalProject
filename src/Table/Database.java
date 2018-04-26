package Table;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;

public class Database {
    public static void main(String args[]) throws SQLException{
        //try {
            //if (tablesExists()) {
                //dropTable();
                //tablesExists();
            //}*/

            //createTable();
            String temp = "10.12,Shirt,55612";
            String[] strArr = temp.split(",");
            Connection eConnection = connect();
            //Connection eConnection = connect();
            //BufferedReader br;

            /*try{
                br = new BufferedReader(new FileReader(args[0]));
                br.readLine();
                String str;
                while((str = br.readLine()) != null){
                    String [] strArr = str.split(",");*/
                    insert(strArr, eConnection);
               /* }
                br.close();
            } catch (IOException e){
                e.getMessage();
            }

        } finally {
            *//*catch(SQLException e){
            System.out.println(e.getMessage());
        }*//*
        }*/
    }

    /**
     * creates tables with fields from the given CSV file
     */
    public static void createTable(){
        try {
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        Connection connection = null;
        try {
            connection = DriverManager.getConnection("jdbc:derby:Inventory;create=true", "", "");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        Connection eConnection = null;
        Statement statement = null;

        String createTableSQL = "CREATE TABLE INVENTORY( Price REAL NOT NULL , "
                + "Name VARCHAR(255) NOT NULL, " + "Serial BIGINT NOT NULL )";

        try{
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
        }catch(ClassNotFoundException e){
            System.out.println(e.getMessage());
        }
        try{
            eConnection = DriverManager.getConnection("jdbc:derby:Inventory;create=true", "", "");
            statement = eConnection.createStatement();
            statement.execute(createTableSQL);
            System.out.println("Table Created!");
        }catch(SQLException e){
            System.out.println(e.getMessage());
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.getMessage();
                }
            }
            if (eConnection != null) {
                try {
                    eConnection.close();
                } catch (SQLException e) {
                    e.getMessage();
                }
            }
        }
    }

    /**
     * returns a connection to the player table
     */
    public static Connection connect(){
        Connection eConnection = null;

        try{
            eConnection = DriverManager.getConnection("jdbc:derby:Inventory", "", "");
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }

        return eConnection;
    }

    /**
     * determines if the player tables already exists
     */
    public static boolean tablesExists() throws SQLException{
        Connection c = connect();
        DatabaseMetaData dbm = c.getMetaData();
        ResultSet rs = dbm.getTables(null, null, "INVENTORY", null);

        if (rs.next()) {
            System.out.println("Table exists");
            return true;
        } else {
            System.out.println("Table does not exist");
            return false;
        }
    }

    /**
     * If the player table already exists, it will be deleted
     */
    public static void dropTable() throws SQLException{
        Statement stmt = connect().createStatement();
        String del = "DROP TABLE INVENTORY";
        stmt.executeUpdate(del);
    }

    /**
     * constructs an insertion query and inserts the CSV data into the table
     */
    public static void insert(String [] strArr, Connection c){
        String sqlCommand = "INSERT INTO INVENTORY (Price, Name, Serial) VALUES ( " +
                strArr[0] + ", \'" + strArr[1] + "\', " + strArr[2] + ")";
        Statement stmt;
        try {
            stmt = c.createStatement();
            stmt.executeUpdate(sqlCommand);
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }
}
