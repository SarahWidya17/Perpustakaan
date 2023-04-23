package MainFrame.Peminjaman;

import MainFrame.Pengembalian.Pengembalian;
import MainFrame.Pengembalian.PengembalianUser;
import MainFrame.Login.LoginFrame;
import com.toedter.calendar.JDateChooser;

import javax.swing.JFrame;


import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.List;

public class Peminjaman extends JFrame{
    private JTextField memberNametxt;
    private JSplitPane rootPanel;
    private JTable table1;
    private JButton submitButton;
    private JButton clearButton;
    private JPanel jPanelCalender;
    private JComboBox bookNameComboBox;
    private JMenuBar MenuBar;
    private JMenu FileMenu;
    private JMenuItem PeminjamanItem;
    private JMenuItem PengembalianItem;
    private JMenuItem LogoutItem;


    Calendar calender = Calendar.getInstance();
    JDateChooser dateChooser = new JDateChooser(calender.getTime());

    public Peminjaman(){

        JFrame frame = new JFrame("Borrow Form");
        frame.setContentPane(rootPanel);
        frame.setPreferredSize(new Dimension(600, 420));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        List<User> userList = new ArrayList<>();
        userList.add(new User("170805","Sesya", "HAE242", "DATA STRUCTURES", "17/08/2022"));
        userList.add(new User("293742","Andrea", "HAE123", "CALCULUS", "31/12/2021"));
        userList.add(new User("284666","Charlie", "HAE187", "OBJECT ORIENTED PROGRAMMING", "11/11/2022"));
        userList.add(new User("312930","David", "HAE352", "HUMAN COMPUTING INTERACTION", "1/03/2023"));
        userList.add(new User("123456", "Camila Cabello", "HAE375", "SCIENTIFIC COMPUTING", "02/03/2023"));

        UserTableModel userTableModel = new UserTableModel(userList);
        table1.setModel(userTableModel);
        table1.setAutoCreateRowSorter(true);

        dateChooser.setDateFormatString("dd/MM/yyyy");
        jPanelCalender.add(dateChooser);

        submitButton.addActionListener(e -> {

            String addMemberName, comboName;
            addMemberName = memberNametxt.getText();
            comboName = bookNameComboBox.getSelectedItem().toString();

            if (addMemberName.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Member Name can't be Empty!", "Warning", JOptionPane.WARNING_MESSAGE);
            }
//            else if (!addBookCode.matches("HAE\\d{3}$")) {
//                JOptionPane.showMessageDialog(null, "The Book Code must contain 'HAE' and have a length of 6 characters", "Warning", JOptionPane.WARNING_MESSAGE);
            else if (bookNameComboBox.getSelectedIndex() == 0){
                JOptionPane.showMessageDialog(null, "Book Name must be Selected", "Error", JOptionPane.ERROR_MESSAGE);
            }else {
                User user = new User();

                user.setBorrowCode(String.format(String.valueOf(new Random().nextInt(999999))));
                user.setMemberName(addMemberName);
                user.setBookName(comboName);

                if(comboName.matches("CALCULUS")){
                    user.setBookCode("HAE123");
                }else if(comboName.matches("DATA STRUCTURES")){
                    user.setBookCode("HAE242");
                }else if(comboName.matches("OBJECT ORIENTED PROGRAMMING")){
                    user.setBookCode("HAE187");
                }else if(comboName.matches("SCIENTIFIC COMPUTING")){
                    user.setBookCode("HAE375");
                }else{
                    user.setBookCode("HAE352");
                }

//            DatePicker datePicker = new DatePicker();

                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/YYYY");
                String dateBorrow = simpleDateFormat.format(dateChooser.getDate());

                if(dateChooser.getDate() != null){
                    JOptionPane.showMessageDialog(rootPanel, "Maximum Period for Borrowing Books is 14 days!", "Information", JOptionPane.INFORMATION_MESSAGE);
                }

                user.setBorrowDate(dateBorrow);

//            jCalender.add(dateChooser);

                userList.add(user);
                userTableModel.fireTableDataChanged();
                clear();

                System.out.println("Borrow Code : " +user.getBorrowCode());
                System.out.println("Member Name : " +addMemberName);
                System.out.println("Book Code : " + user.getBookCode());
                System.out.println("Book Name : " +comboName);
                System.out.println("Borrow Date : " +dateBorrow);
//                int lastIndex = userTableModel.getRowCount()-1;
//                Object[] lastRow = {
//                    userTableModel.getValueAt(lastIndex,0),
//                    userTableModel.getValueAt(lastIndex,1),
//                    userTableModel.getValueAt(lastIndex,2),
//                    userTableModel.getValueAt(lastIndex,3),
//                    userTableModel.getValueAt(lastIndex,4),
//                    userTableModel.getValueAt(lastIndex,5)
//                };
//                System.out.println(Arrays.toString(lastRow));
            }


        });

        clearButton.addActionListener(e -> {
            clear();
        });


//        FileMenu.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//
//            }
//        });

        PeminjamanItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
              //  System.out.println(getName());
                JOptionPane.showMessageDialog(null, "You are already in the Borrow menu", "Information", JOptionPane.INFORMATION_MESSAGE);
                dispose();
            }
        });

        PengembalianItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Pengembalian pengembalian = new Pengembalian();
                pengembalian.setVisible(true);
                dispose();
            }
        });

        LogoutItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int option = JOptionPane.showConfirmDialog(null, "Are you sure want to logout?", "Logout", JOptionPane.YES_NO_OPTION);

                if(option == JOptionPane.YES_OPTION){
                    dispose();
                    System.gc();
                    LoginFrame loginFrame = new LoginFrame();
                    loginFrame.setVisible(true);
                }
//                System.out.println(getName());


               // LoginFrame loginFrame = new LoginFrame();
               // loginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
               // loginFrame.setVisible(true);
               // dispose();
                return;
               // System.exit(0);

            }
        });
    }



    private void clear(){
        memberNametxt.setText("");
        bookNameComboBox.setSelectedIndex(0);
        dateChooser.setDate(new Date());
        table1.clearSelection();
        submitButton.setEnabled(true);
    }

    public static void main(String[] args) {
//        JFrame frame = new JFrame("Peminjaman Form");
//        frame.setContentPane(new Peminjaman().rootPanel);
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame.pack();
//        frame.setLocationRelativeTo(null);
//        frame.setVisible(true);
        new Peminjaman();

    }



    private static class UserTableModel extends AbstractTableModel{
        private final String[] header = {"BORROW CODE", "MEMBER NAME", "BOOK CODE", "BOOK NAME", "BORROW DATE"};
        private List<User> users;

        public UserTableModel(List<User> users) {
            this.users = users;
        }

        @Override
        public int getRowCount() { //mengembalikkan jumlah baris
            return users.size();
        }

        @Override
        public int getColumnCount() {
            return header.length;
        }

        @Override
        public Object getValueAt(int rowIndex, int columnIndex) { //isi data
            return switch (columnIndex){
                case 0 -> users.get(rowIndex).getBorrowCode();
                case 1 -> users.get(rowIndex).getMemberName();
                case 2 -> users.get(rowIndex).getBookCode();
                case 3 -> users.get(rowIndex).getBookName();
                case 4 -> users.get(rowIndex).getBorrowDate();
                default -> "-";
            };
        }

        @Override
        public String getColumnName(int column) {
            return header[column];
        }

        @Override
        public Class<?> getColumnClass(int columnIndex) {
            if(getValueAt(0, columnIndex) != null){
                return getValueAt(0,columnIndex).getClass();
            }
            else{
                return Object.class;
            }
        }
    }


    private class DatePicker {
    }
}
