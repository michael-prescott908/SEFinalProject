package Table;

import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

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

        table.setPreferredScrollableViewportSize(new Dimension(500, 400));
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
                        }
                    }
                }
        );

        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane);

        JPanel form = new JPanel(new SpringLayout());
        JLabel l1 = new JLabel("Filter Text:");
        form.add(l1);
        filterText = new JTextField();

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
        RowFilter<MyTableModel, Object> rf = null;
        try {
            rf = RowFilter.regexFilter(filterText.getText(), 0);
        } catch (java.util.regex.PatternSyntaxException e) {
            return;
        }
        sorter.setRowFilter(rf);
    }
}
