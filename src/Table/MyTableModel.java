package Table;

import Items.Item;

import javax.swing.table.AbstractTableModel;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Vector;

public class MyTableModel extends AbstractTableModel{
    private Vector<String> columnNames;
    private Vector <Vector> vec;

    public MyTableModel(){
        columnNames = new Vector<String>();
        vec = new Vector<>();
        columnNames.add("Price");
        columnNames.add("Name");
        columnNames.add("Serial");

        Vector<Item> itemVector = new Vector<>();
        vec = new Vector <>();

        try {
            Connection connection = Database.connect();
            String query = "SELECT * FROM INVENTORY";
            Statement stmt = null;
            stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while(rs.next()){
                Vector temp = new Vector(3);
                temp.add(rs.getFloat("Price"));
                temp.add(rs.getString("Name"));
                temp.add(rs.getInt("Serial"));
                vec.add(temp);
            }
        } catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }

    public int getColumnCount() {
        return columnNames.size();
    }

    public int getRowCount() {
        return vec.size();
    }

    public String getColumnName(int col) {
        return columnNames.get(col);
    }

    public Object getValueAt(int row, int col) {
        return vec.get(row).get(col);
    }

    public Vector<Vector> getVec(){
        return vec;
    }

    public Vector<String> getColumnNames(){
        return columnNames;
    }
}
