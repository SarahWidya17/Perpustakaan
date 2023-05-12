package MainFrame.Pengembalian;

import MainFrame.Login.LoginFrame;
import MainFrame.Peminjaman.Peminjaman;
import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.awt.Container;
import javax.swing.JMenu;
import javax.swing.JMenuBar;

public class Pengembalian extends JFrame{
    private JTextField borrowCodetxt;
    private JTextField memberNametxt;
    private JButton submitButton;
    private JButton clearButton;
    private JTable table1;
    private JPanel JPanel_Return;
    private JSplitPane rootPanel;
    private JComboBox bookNameComboBox;
    private JPanel JPanel_borrow;
    private JMenu FileMenu;
    private JMenuItem PeminjamanItem;
    private JMenuItem PengembalianItem;
    private JMenuItem LogoutItem;
    Calendar calender = Calendar.getInstance();
    JDateChooser dateChooser = new JDateChooser(calender.getTime());
    JDateChooser dateChooser2 = new JDateChooser(calender.getTime());

    public Pengembalian(){
        JFrame frame = new JFrame("Return Form");
        frame.setContentPane(rootPanel);
        frame.setPreferredSize(new Dimension(600, 420));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        List<PengembalianUser> pengembalianUserList = new ArrayList<>();


        pengembalianUserList.add(new PengembalianUser("293742", "Andrea", "DATA STRUCTURES", "17/08/2022","27/08/2022", "done"));
        pengembalianUserList.add(new PengembalianUser("170805", "Sesya", "CALCULUS", "30/08/2022","31/12/2021", "FINE Rp.163500"));
        pengembalianUserList.add(new PengembalianUser("284666","Charlie", "OBJECT ORIENTED PROGRAMMING","11/11/2022", "24/11/2022","done"));

        tableModel tableModel = new tableModel(pengembalianUserList);
        table1.setModel(tableModel);
        table1.setAutoCreateRowSorter(true);

        dateChooser.setDateFormatString("dd/MM/yyyy");
        JPanel_borrow.add(dateChooser);

        dateChooser2.setDateFormatString("dd/MM/yyyy");
        JPanel_Return.add(dateChooser2);

        submitButton.addActionListener(e -> {
            PengembalianUser newPengembalianUser = new PengembalianUser();
            String borrowCode, memberName, bookName;
            borrowCode = borrowCodetxt.getText();
            memberName = memberNametxt.getText();
            bookName = bookNameComboBox.getSelectedItem().toString();

            boolean isBorrowCodeExist = false;
            for(PengembalianUser pengembalianUser : pengembalianUserList){
                if(pengembalianUser.getBorrowCode().equals(borrowCode)){
                    isBorrowCodeExist = true;
                    break;
                }
            }

            if(isBorrowCodeExist){
                JOptionPane.showMessageDialog(rootPanel, "Borrow code already exists!", "Error", JOptionPane.ERROR_MESSAGE);
            }

            else if(borrowCode.isEmpty() || borrowCode.length() != 6){
                JOptionPane.showMessageDialog(rootPanel, "Borrow Code can't be Empty or Only 6 Characters are Accepted!", "Warning", JOptionPane.WARNING_MESSAGE);
            } else if(memberName.isEmpty()){
                JOptionPane.showMessageDialog(rootPanel, "Member Name can't be Empty!", "Warning", JOptionPane.WARNING_MESSAGE);
            } else if(bookName.isEmpty()){
                JOptionPane.showMessageDialog(rootPanel, "Book Name can't be Empty!", "Warning", JOptionPane.WARNING_MESSAGE);
            }  else {
                newPengembalianUser.setBorrowCode(borrowCode);
                newPengembalianUser.setMemberName(memberName);
                newPengembalianUser.setBookName(bookName);

                SimpleDateFormat sdfBorrow = new SimpleDateFormat("dd/MM/YYYY");
                String dateBorrow = sdfBorrow.format(dateChooser.getDate());

                SimpleDateFormat sdfReturn = new SimpleDateFormat("dd/MM/YYYY");
                String dateReturn = sdfReturn.format(dateChooser2.getDate());

                newPengembalianUser.setBorrowDate(dateBorrow);
                newPengembalianUser.setReturnDate(dateReturn);

                //denda
                Calendar calBorrow = Calendar.getInstance();
                calBorrow.setTime(dateChooser.getDate());

                Calendar calReturn = Calendar.getInstance();
                calReturn.setTime(dateChooser2.getDate());

                int limitBorrow = (int) ((calReturn.getTimeInMillis() - calBorrow.getTimeInMillis()) / (1000 * 60 * 60 * 24) ) - 14;

                if(limitBorrow > 0){
                    int charge = limitBorrow * 1500;
                    JOptionPane.showMessageDialog(rootPanel, "This book is late returned for " + limitBorrow + " days. So you get fined Rp. " +charge, "Warning", JOptionPane.WARNING_MESSAGE);
                    newPengembalianUser.setStatus("FINE Rp." +charge);
                }else{
                    newPengembalianUser.setStatus("done");
                }

                pengembalianUserList.add(newPengembalianUser);
                tableModel.fireTableDataChanged();
                clear();

                System.out.println("Borrow Code : " +borrowCode);
                System.out.println("Member Name : " +memberName);
                System.out.println("Book Name : " +bookName);
                System.out.println("Borrow Date : " + newPengembalianUser.getBorrowDate());
                System.out.println("Return Date : " + newPengembalianUser.getReturnDate());
                System.out.println("Status : " + newPengembalianUser.getStatus());
            }

        });

        clearButton.addActionListener(e -> {
            clear();
        });

        PeminjamanItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //  System.out.println(getName());
                Peminjaman peminjaman = new Peminjaman();
                peminjaman.setVisible(true);
                dispose();
            }
        });

        PengembalianItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "You are already in the Return menu", "Information", JOptionPane.INFORMATION_MESSAGE);
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
        borrowCodetxt.setText("");
        memberNametxt.setText("");
        bookNameComboBox.setSelectedIndex(0);
        dateChooser.setDate(new Date());
        dateChooser2.setDate(new Date());
        table1.clearSelection();
        submitButton.setEnabled(true);
    }
    public static void main(String[] args) {
//        JFrame frame = new JFrame("Pengembalian Form");
//        frame.setContentPane(new Pengembalian().rootPanel);
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame.pack();
//        frame.setLocationRelativeTo(null);
//        frame.setVisible(true);

        new Pengembalian();
    }

    private static class tableModel extends AbstractTableModel{
        private final String[] header = {"BORROW CODE", "MEMBER NAME", "BOOK NAME", "BORROW DATE", "RETURN DATE", "STATUS"};
        private List<PengembalianUser> pengembalianUsers;

        public tableModel(List<PengembalianUser> pengembalianUsers) {
            this.pengembalianUsers = pengembalianUsers;
        }

        @Override
        public int getRowCount() {
            return pengembalianUsers.size();
        }

        @Override
        public int getColumnCount() {
            return header.length;
        }

        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            return switch (columnIndex){
                case 0 -> pengembalianUsers.get(rowIndex).getBorrowCode();
                case 1 -> pengembalianUsers.get(rowIndex).getMemberName();
                case 2 -> pengembalianUsers.get(rowIndex).getBookName();
                case 3 -> pengembalianUsers.get(rowIndex).getBorrowDate();
                case 4 -> pengembalianUsers.get(rowIndex).getReturnDate();
                case 5 -> pengembalianUsers.get(rowIndex).getStatus();
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
                return getValueAt(0, columnIndex).getClass();
            }else{
                return Object.class;
            }
        }
    }
}
