package MainFrame.DaftarBuku;


import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegistrationBook extends JDialog{
    private JTextField CodeField;
    private JTextField NameField;
    private JButton submitButton;
    private JButton cancelButton;
    private JLabel NameLabel;
    private JPanel BookRegist;
    private JPanel rootPanel;
    private JTable table1;
    private JSplitPane dalamnama;


    public RegistrationBook() {
        JFrame frame = new JFrame("Main Registration");
        frame.setContentPane(dalamnama);
        frame.setPreferredSize(new Dimension(600, 420));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        List<DataBook> dataBooks = new ArrayList<>();
        dataBooks.add(new DataBook("HAE123", "Lekas"));
        dataBooks.add(new DataBook("HAE222", "Hentikan Tangismu"));
        dataBooks.add(new DataBook("HAE983", "Waktu mu"));
        dataBooks.add(new DataBook("HAE323", "Sangat terbatas"));

//        JFrame frame = new JFrame();
        frame.setPreferredSize(new Dimension(600,420));
        BookTable bookTable = new BookTable(dataBooks);

        table1.setModel(bookTable);
        table1.setAutoCreateRowSorter(true);
        submitButton.addActionListener(e -> {
            String bookCode = CodeField.getText();
            String bookName = NameField.getText();

            if (bookCode.isEmpty() || bookName.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please enter all fields", "Try Again", JOptionPane.ERROR_MESSAGE);
                return;
            }

            Pattern pattern = Pattern.compile("^HAE\\d{3}$");
            Matcher matcher = pattern.matcher(bookCode);

            if (matcher.matches()) {
                JOptionPane.showMessageDialog(this, "Input Succesfull", "Validasi Input", JOptionPane.INFORMATION_MESSAGE);
                DataBook dataBook = new DataBook();
                dataBook.setBookCodee(CodeField.getText());
                dataBook.setBookName(NameField.getText());
                dataBooks.add(dataBook);
                bookTable.fireTableDataChanged();
                CodeField.setText("");
                NameField.setText("");
            } else {
                JOptionPane.showMessageDialog(this, "please enter the book code according to the command", "Validasi Input", JOptionPane.ERROR_MESSAGE);
            }


        });

        cancelButton.addActionListener(e -> {
            CodeField.setText("");
            NameField.setText("");

        });

    }


    public static void main(String[] args) {


//        JFrame frame = new JFrame("Main Registration");
//        frame.setContentPane(new RegistrationBook().dalamnama);
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame.pack();
//        frame.setLocationRelativeTo(null);
//        frame.setVisible(true);
        new RegistrationBook();
    }


    private static class BookTable extends AbstractTableModel{//DISINI YANG KONVERSI IN

        //HANYA DIGUNAKAN DISINI GA DI KLAS LAINNYA
        private final String[] COLUMNS = {"Book Code","Book Name"};

        private List<DataBook> dataBooks; //PENAMPUNG DATA

        private BookTable(List<DataBook> dataBooks) {
            this.dataBooks = dataBooks;
        }

        @Override
        public int getRowCount() { //return jumblah baris dalam jtable
            return dataBooks.size(); //berasal dari list jadi return size
        }

        @Override
        public int getColumnCount() {
            return COLUMNS.length;
        }

        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            return switch (columnIndex){
                case 0-> dataBooks.get(rowIndex).getBookCodee();
                case 1-> dataBooks.get(rowIndex).getBookName();
                default ->"-";
            };
        }

        @Override
        public String getColumnName(int column){
            return COLUMNS[column]; //mengkonversi data nya
        }

        @Override
        public Class<?> getColumnClass(int columnIndex){
            if (getValueAt(0,columnIndex) != null){
                return getValueAt(0,columnIndex).getClass();
            }else {
                return Object.class;
            }
        }
    }
}
