import org.mindrot.jbcrypt.BCrypt;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegisterForm extends JFrame {
    private JTextField emailIDField;
    private JPasswordField passwordField;
    private JButton registerButton;
    private JPanel registerPanel;
    private JPasswordField confirmPasswordField;
    private JTextField firstNameField;
    private JTextField lastNameField;
    private JLabel emailValidityMessage;
    private JLabel firstNameValidityMessage;
    private JLabel lastNameValidityMessage;
    private JLabel passwordValidityMessage;
    private JLabel confirmPasswordValidityMessage;
    private JButton closeButton;

    // JDBC Stuff
    Connection connection;
    PreparedStatement preparedStatement;

    public void Connect() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost/ELearningPlatform", "root", "shornabho");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

    }

    public RegisterForm() {
        Connect();

        add(registerPanel);

        setTitle("Register Form");
        setSize(800,600);

        // Center window
        setLocationRelativeTo(null);

        // Set default button (Enter key) for the frame to trigger the registerButton
        this.getRootPane().setDefaultButton(registerButton);

        emailIDField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                super.keyReleased(e);
                String input = emailIDField.getText();
                Pattern pattern = Pattern.compile("^[a-zA-Z0-9_+&*-]+(?:\\."+
                        "[a-zA-Z0-9_+&*-]+)*@" +
                        "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
                        "A-Z]{2,7}$");
                Matcher matcher = pattern.matcher(input);

                if (!matcher.find()) {
                    emailValidityMessage.setVisible(true);
                    emailValidityMessage.setForeground(Color.RED);
                    emailValidityMessage.setText("Invalid email!");
                }
                else {
                    emailValidityMessage.setVisible(false);
                }
            }
        });

        firstNameField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                super.keyReleased(e);
                String input = firstNameField.getText();
                Pattern pattern = Pattern.compile("^[\\p{L} .'-]+$", Pattern.CASE_INSENSITIVE);
                Matcher matcher = pattern.matcher(input);

                if (!matcher.find()) {
                    firstNameValidityMessage.setVisible(true);
                    firstNameValidityMessage.setForeground(Color.RED);
                    firstNameValidityMessage.setText("Invalid Name!");
                }
                else {
                    firstNameValidityMessage.setVisible(false);
                }
            }
        });

        lastNameField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                super.keyReleased(e);
                String input = lastNameField.getText();
                Pattern pattern = Pattern.compile("^[\\p{L} .'-]+$", Pattern.CASE_INSENSITIVE);
                Matcher matcher = pattern.matcher(input);

                if (!matcher.find()) {
                    lastNameValidityMessage.setVisible(true);
                    lastNameValidityMessage.setForeground(Color.RED);
                    lastNameValidityMessage.setText("Invalid Name!");
                }
                else {
                    lastNameValidityMessage.setVisible(false);
                }
            }
        });

        passwordField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                super.keyReleased(e);
                String password = String.valueOf(passwordField.getPassword());
                passwordValidityMessage.setForeground(Color.RED);

                // Get password length
                int passwordLength = password.length();

                boolean passwordTooSmall = passwordLength < 8;
                boolean passwordTooLong = passwordLength > 20;
                boolean passwordHasUppercase = false;
                boolean passwordHasLowercase = false;
                boolean passwordHasDigit = false;
                boolean passwordHasSpecialCharacter = false;

                // Check for digit, uppercase, lowercase characters
                for (int i = 0; i < passwordLength; i++) {
                    char character = password.charAt(i);
                    if (Character.isDigit(character)) {
                        passwordHasDigit = true;
                    }
                    else if (Character.isUpperCase(character)) {
                        passwordHasUppercase = true;
                    }
                    else if (Character.isLowerCase(character)) {
                        passwordHasLowercase = true;
                    }
                }

                // Check if password has special characters
                Pattern pattern = Pattern.compile("[^a-zA-Z0-9]");
                Matcher matcher = pattern.matcher(password);

                if (matcher.find()) passwordHasSpecialCharacter = true;

                // Set warning string
                String warningString = "";
                boolean warningVisibilityStatus = true;

                if (passwordTooSmall) warningString = "Password should be minimum of 8 characters long!";
                else if (passwordTooLong) warningString = "Password should be maximum of 20 characters long!";
                else if (!passwordHasDigit) warningString = "Password should have at least one digit!";
                else if (!passwordHasLowercase) warningString = "Password should have at least one lowercase character!";
                else if (!passwordHasUppercase) warningString = "Password should have at least one uppercase character!";
                else if (!passwordHasSpecialCharacter) warningString = "Password should have at least one special character!";
                else warningVisibilityStatus = false;

                passwordValidityMessage.setText(warningString);
                passwordValidityMessage.setVisible(warningVisibilityStatus);
            }
        });

        confirmPasswordField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                super.keyReleased(e);
                String password = String.valueOf(passwordField.getPassword());
                String confirmPassword = String.valueOf(confirmPasswordField.getPassword());
                boolean passwordsMatch = password.equals(confirmPassword);

                System.out.println("Password: " + password + "\nConfirm Password: " + confirmPassword);

                if (!passwordsMatch) {
                    confirmPasswordValidityMessage.setText("Passwords do not match!");
                    confirmPasswordValidityMessage.setForeground(Color.RED);
                    confirmPasswordValidityMessage.setVisible(true);
                }
                else {
                    confirmPasswordValidityMessage.setVisible(false);
                }
            }
        });

        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Get username and password and verify

                // Get username and password
                String emailID = emailIDField.getText();
                String firstName = firstNameField.getText();
                String lastName = lastNameField.getText();
                char[] password = passwordField.getPassword();
                char[] confirmPassword = confirmPasswordField.getPassword();
                if (!String.valueOf(password).equals(String.valueOf(confirmPassword))) {
                    JOptionPane.showMessageDialog(RegisterForm.this, "Passwords do not match!");

                    clearFields();
                }
                else {
                    // Query DB to check
                    // System.out.println("Email ID: " + emailID);
                    // System.out.println("First Name: " + firstName);
                    // System.out.println("Last Name: " + lastName);
                    // System.out.println("Password: " + password);
                    // System.out.println("Confirm Password: " + confirmPassword);

                    try {
                        preparedStatement = connection.prepareStatement("INSERT INTO Teacher (emailId, firstName, lastName, password) VALUES(?,?,?,?);");
                        preparedStatement.setString(1, emailID);
                        preparedStatement.setString(2, firstName);
                        preparedStatement.setString(3, lastName);
                        preparedStatement.setString(4, BCrypt.hashpw(String.valueOf(password), BCrypt.gensalt()));
                        int i = preparedStatement.executeUpdate();

                        JOptionPane.showMessageDialog(RegisterForm.this, "Registration successful!");

                        RegisterForm.super.dispose();

                        LoginForm loginForm = new LoginForm();
                        loginForm.setVisible(true);

                    } catch (java.sql.SQLIntegrityConstraintViolationException ex) {
                        JOptionPane.showMessageDialog(RegisterForm.this, "User already exists!");
                        clearFields();
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                        clearFields();
                    }

                }
            }

            public void clearFields() {
                // Clear values in all fields

                emailIDField.setText("");
                firstNameField.setText("");
                lastNameField.setText("");
                passwordField.setText("");
                confirmPasswordField.setText("");

                emailIDField.requestFocus();
            }
        });
        closeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                RegisterForm.super.dispose();
            }
        });
    }

    public static void main(String[] args) {
        RegisterForm registerForm = new RegisterForm();
        registerForm.setVisible(true);


    }
}
