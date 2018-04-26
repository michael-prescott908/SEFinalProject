package Table;

import Items.Item;

import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Vector;

public class Table extends JPanel{
    private Boolean DEBUG = false;
    private TableRowSorter<MyTableModel> sorter;
    private JTextField filterText;
    private JTextField statusText;
    private MyTableModel model;

    public Table(){
        super(new GridLayout(1,0));
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        model = new MyTableModel();
        final JTable table = new JTable(model.getVec(), model.getColumnNames());
        table.setRowSorter(sorter);
        table.setAutoCreateRowSorter(true);

        table.setPreferredScrollableViewportSize(new Dimension(500, 100));
        table.setFillsViewportHeight(true);

        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        table.getSelectionModel().addListSelectionListener(
                new ListSelectionListener() {
                    public void valueChanged(ListSelectionEvent event) {
                        int viewRow = table.getSelectedRow();
                        if (viewRow < 0) {
                            //Selection got filtered away.
                            statusText.setText("");
                        } else {
                            int modelRow =
                                    table.convertRowIndexToModel(viewRow);
                            statusText.setText(
                                    String.format("Selected Row in view: %d. " +
                                                    "Selected Row in model: %d.",
                                            viewRow, modelRow));
                        }
                    }
                }
        );

        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane);

        //Create a separate form for filterText and statusText
        JPanel form = new JPanel(new SpringLayout());
        JLabel l1 = new JLabel("Filter Text:");
        form.add(l1);
        filterText = new JTextField();
        //Whenever filterText changes, invoke newFilter.
        filterText.getDocument().addDocumentListener(
                new DocumentListener() {
                    public void changedUpdate(DocumentEvent e) {
                        newFilter();
                    }
                    public void insertUpdate(DocumentEvent e) {
                        newFilter();
                    }
                    public void removeUpdate(DocumentEvent e) {
                        newFilter();
                    }
                });
        l1.setLabelFor(filterText);
        filterText.setColumns(80);
        form.add(filterText);
        JLabel l2 = new JLabel("Status:", SwingConstants.TRAILING);
        form.add(l2);
        statusText = new JTextField();
        l2.setLabelFor(statusText);
        form.add(statusText);
        add(form);

        if(DEBUG){
            table.addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent e){
                    printDebugData(table);
                }
            });
        }
    }

    private void printDebugData(JTable table){
        int numRows = table.getRowCount();
        int numCols = table.getColumnCount();
        TableModel model = table.getModel();
        System.out.println("Value of data: ");
        for(int i = 0; i < numRows; i++){
            System.out.print("  row" + i + ":");
            for(int j = 0; j < numCols; j++){
                System.out.print(" " + model.getValueAt(i, j));
            }
            System.out.println();
        }
        System.out.println("-------------------------");
    }

    public static void createAndShowGUI() {
        JFrame frame = new JFrame("Table");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Table newPane = new Table();
        newPane.setOpaque(true);
        frame.setContentPane(newPane);

        frame.setSize(new Dimension(600, 400));
        frame.setVisible(true);
    }

    private void newFilter(){
        /*RowFilter<MyTableModel, Object> rf = null;
        //If current expression doesn't parse, don't update.
        try {
            rf = RowFilter.regexFilter(filterText.getText(), 0);
        } catch (java.util.regex.PatternSyntaxException e) {
            return;
        }
        sorter.setRowFilter(rf);*/
    }

    public static void main(String[] args){
        BufferedReader br = null;
        String line;
        Vector<Item> items = new Vector<Item>();
        Table table = new Table();

        try{
            br = new BufferedReader(new FileReader("animals.csv"));
            br.readLine();
            while((line = br.readLine()) != null){
                //anim.add(CreateClass.returnClass(line.split(",")));
            }
            //table.createAndShowGUI(anim);
            javax.swing.SwingUtilities.invokeLater(new Runnable() {
                public void run() {
                    //createAndShowGUI(anim);
                }
            });
        } catch(FileNotFoundException e){
            System.out.println(e.getMessage());
        } catch (IOException e){
            System.out.println(e.getMessage());
        } finally {
            if(br != null){
                try {
                    br.close();
                } catch (IOException e){
                    System.out.println(e.getMessage());
                }
            }
        }
    }
}
