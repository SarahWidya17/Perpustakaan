package MainFrame.Register;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import MainFrame.Login.LoginFrame;

public class RegistrationFrame extends JFrame implements ActionListener{
        private JTextField firstNameField, lastNameField, emailField;
        private JPasswordField passwordField, confirmField;
        private JButton registerButton, resetButton, loginButton;

        public RegistrationFrame() {
//            super("Register Frame");
            setTitle("HAE LIBRARY");
            JFrame frame = new JFrame();
            JPanel panel = new JPanel();

//            setVisible(true);

            getContentPane().setBackground(new Color(228,195,248));

            JLabel firstNameLabel = new JLabel("First Name: ");
            JLabel lastNameLabel = new JLabel("Last Name: ");
            JLabel emailLabel = new JLabel("Email: ");
            JLabel passwordLabel = new JLabel("Password: ");
            JLabel confirmLabel = new JLabel("Confirm password: ");

//            ===================================
//            JLabel validation =  new JLabel("BAHAGIA");
//            ===================================






            firstNameField = new JTextField(20);
            lastNameField = new JTextField(20);
            emailField = new JTextField(20);
            passwordField = new JPasswordField(20);
            confirmField = new JPasswordField(20);



            registerButton = new JButton("Register");
            loginButton = new JButton("Login");
            resetButton = new JButton("Reset");
            JLabel titleLabel = new JLabel("ayam");
            titleLabel.setFont(new Font("Serif", Font.BOLD, 24));
            titleLabel.setHorizontalAlignment(JLabel.CENTER);

            setLayout(new GridLayout(9, 2, 10, 10));
            frame.add(panel);
            panel.add(titleLabel);
            add(firstNameLabel);
            add(firstNameField);
            add(lastNameLabel);
            add(lastNameField);
            add(emailLabel);
            add(emailField);
            add(passwordLabel);
            add(passwordField);
            add(confirmLabel);
            add(confirmField);
//            add(validation);
            add(registerButton);
            add(resetButton);
            add(loginButton);

//            registerButton.setPreferredSize(new Dimension(60, 20)); // set ukuran baru untuk tombol register
//            resetButton.setPreferredSize(new Dimension(60, 20)); // set ukuran baru untuk tombol reset
//            firstNameField.setPreferredSize(new Dimension(200, 20)); // set ukuran baru untuk JTextField firstNameField
//            lastNameField.setPreferredSize(new Dimension(200, 20)); // set ukuran baru untuk JTextField lastNameField
//            emailField.setPreferredSize(new Dimension(200, 20)); // set ukuran baru untuk JTextField emailField
//            passwordField.setPreferredSize(new Dimension(200, 20)); // set ukuran baru untuk JTextField passwordField
//            confirmField.setPreferredSize(new Dimension(200, 20)); // set ukuran baru untuk JTextField confirmField

            registerButton.addActionListener(this);
            resetButton.addActionListener(this);
            loginButton.addActionListener(this);


            setSize(600, 420);
            setLocationRelativeTo(null);
            frame.pack();
//            frame.setVisible(true);
            setDefaultCloseOperation(3);
            setVisible(true);
        }

        public void actionPerformed(ActionEvent e) {
            String firstName = firstNameField.getText();
            String lastName = lastNameField.getText();
            String email = emailField.getText();
            String password = new String(passwordField.getPassword());
            String confirm = new String(confirmField.getPassword());

            
            if(e.getSource() == loginButton) {
                LoginFrame loginFrame = new LoginFrame();
                loginFrame.setVisible(true);
                dispose();
            }else{
                if(firstName.isEmpty() || lastName.isEmpty() || email.isEmpty() || password.isEmpty() || confirm.isEmpty()){
                    JOptionPane.showMessageDialog(null, "Please fill in all fields.");
                }else if (e.getSource() == registerButton) {


                    System.out.println("First Name: " + firstName);
                    System.out.println("Last Name: " + lastName);
                    System.out.println("Email: " + email);
                    System.out.println("Password: " + password);
                    System.out.println("Confirm Password " + confirm);
                    if (password.equals(confirm)) {
                        System.out.println("Password Match!");
                        JOptionPane.showMessageDialog(this,"Registration succesfull!!");

                        System.out.println("First Name: " + firstName);
                        System.out.println("Last Name: " + lastName);
                        System.out.println("Email: " + email);
                        System.out.println("Password: " + password);
                        System.out.println("Confirm Password " + confirm);

                        firstNameField.setText("");
                        lastNameField.setText("");
                        emailField.setText("");
                        passwordField.setText("");
                        confirmField.setText("");
                    } else {
                        JOptionPane.showMessageDialog(null,"Password and Confirm Password do not match!");
                    }
                } else if (e.getSource() == resetButton) {
                    firstNameField.setText("");
                    lastNameField.setText("");
                    emailField.setText("");
                    passwordField.setText("");
                    confirmField.setText("");
                }

            }
            


        }

        public static void main(String[] args) {
            new RegistrationFrame();
        }
    }

