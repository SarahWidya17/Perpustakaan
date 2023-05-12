package MainFrame.Login;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import MainFrame.Peminjaman.Peminjaman;
import MainFrame.DaftarBuku.RegistrationBook;
import MainFrame.Register.RegistrationFrame;

public class LoginFrame extends JFrame{
    private JTextField usernameTxt;
    private JPasswordField passwordTxt;
    private JComboBox roleComboBox;
    private JButton loginButton;
    private JPanel Panel;
    private JButton registerButton;

    public LoginFrame(){
        registerButton.setOpaque(false);
        registerButton.setContentAreaFilled(false);
        registerButton.setBorderPainted(false);

        JFrame frame = new JFrame("Login Form");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(600, 420));
        frame.setResizable(false);
        frame.add(Panel);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        List<User> dataLoginUser = new ArrayList<>();
        List<User> dataLoginAdmin = new ArrayList<>();

        dataLoginUser.add(new User("USER001", "NEWMEMBER", "USER"));
        dataLoginAdmin.add(new User("HAENOTFOOD", "JAYA123", "ADMIN"));

        loginButton.addActionListener(e -> {
            String username, password, options;
            username = usernameTxt.getText();
            password = passwordTxt.getText();
            options = roleComboBox.getSelectedItem().toString();

            if(username.equals("") || password.equals("") || options.equals("")){
                JOptionPane.showMessageDialog(null, "Some Fields are Empty!", "Warning", JOptionPane.WARNING_MESSAGE);
            }

            if (options.equals("ADMIN")) {
                if (username.equals("HAENOTFOOD") && password.equals("JAYA123")) {
                    JOptionPane.showMessageDialog(null, "LOGIN SUCCESSFULLY! HELLO ADMIN @" +username, "Information", JOptionPane.INFORMATION_MESSAGE);
                    RegistrationBook registrationBook = new RegistrationBook();
                    registrationBook.setVisible(true);
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(rootPane, "Username or Password didn't match! Please Try Again", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } else if (options.equalsIgnoreCase("USER")) {
                if(username.equalsIgnoreCase("USER001") && password.equalsIgnoreCase("NEWMEMBER")){
                    JOptionPane.showMessageDialog(null, "LOGIN SUCCESSFULLY! HELLO USER @" +username, "Information", JOptionPane.INFORMATION_MESSAGE);
                    Peminjaman peminjaman = new Peminjaman();
                    peminjaman.setVisible(true);
                    dispose();
                }else {
                    JOptionPane.showMessageDialog(rootPane, "Username or Password didn't match! Please Try Again", "Error", JOptionPane.ERROR_MESSAGE);
                }

            }

            System.out.println("USERNAME : " +username);
            System.out.println("ROLE : " +options);

            clearForm();

        });

        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                JOptionPane.showMessageDialog(null,"Ini register");
                RegistrationFrame registrationFrame = new RegistrationFrame();
                registrationFrame.setVisible(true);
                dispose();
            }
        });

    }

    public void clearForm(){
        usernameTxt.setText("");
        passwordTxt.setText("");
        roleComboBox.setSelectedIndex(0);
        loginButton.setEnabled(true);
    }

    public static void main(String[] args) {
        new LoginFrame();
    }


}


