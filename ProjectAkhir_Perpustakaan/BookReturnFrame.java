package ProjectAkhir_Perpustakaan;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.chrono.JapaneseDate;

public class BookReturnFrame extends JFrame implements ActionListener {

    private JLabel headerLabel = new JLabel("Book Return");
    private JPanel CentralPanel = new JPanel(new GridLayout(5,2));
    private JLabel BorrowC = new JLabel("Borrow Code");
    private JLabel MemName = new JLabel("Member Name");
    private JLabel BookN = new JLabel("Book Name");
    private JLabel ReturnDate = new JLabel("Return Date");

    private JTextField BorrowCode = new JTextField();
    private JTextField MemberName = new JTextField();
    private JTextField BookName =  new JTextField();
    private JTextField Datee = new JTextField();
    private JPanel footerPanel = new JPanel();
    private JButton SubmitButton = new JButton("Submit");


    public BookReturnFrame(){

        headerLabel.setHorizontalAlignment(SwingConstants.CENTER);
        add(headerLabel,BorderLayout.NORTH);

        CentralPanel.add(BorrowC);
        CentralPanel.add(BorrowCode);

        CentralPanel.add(MemName);
        CentralPanel.add(MemberName);

        CentralPanel.add(BookN);
        CentralPanel.add(BookName);


        CentralPanel.add(ReturnDate);
        CentralPanel.add(Datee);
        add(CentralPanel);

        footerPanel.add(SubmitButton);
        add(footerPanel,BorderLayout.SOUTH);

        SubmitButton.addActionListener(this);

        setSize(400,300);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

    }

    public static void main(String[] args) {
        new BookReturnFrame();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == SubmitButton){
            String BorCode = BorrowCode.getText();

        }

    }
}
