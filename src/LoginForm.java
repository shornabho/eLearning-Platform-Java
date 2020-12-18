import org.mindrot.jbcrypt.BCrypt;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class LoginForm extends JFrame {
    private JTextField emailIDField;
    private JPasswordField passwordField;
    private JButton loginButton;
    private JPanel loginPanel;
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

    public LoginForm() {
        Connect();

        add(loginPanel);

        setTitle("Login Form");
        setSize(600,300);

        // Center window
        setLocationRelativeTo(null);

        // Set default button (Enter key) for the frame to trigger the loginButton
        this.getRootPane().setDefaultButton(loginButton);

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Get username and password and verify

                // Get username and password
                String emailID = emailIDField.getText();
                char[] password = passwordField.getPassword();

                boolean loggedIn = false;

                // Query DB to check
                try {
                    preparedStatement = connection.prepareStatement("SELECT id,password FROM Teacher WHERE emailId = ? LIMIT 1;");
                    preparedStatement.setString(1, emailID);
                    ResultSet result = preparedStatement.executeQuery();

                    while (result.next()) {
                        String password_DB = result.getString("password");
                        int id = result.getInt("id");

                        if (BCrypt.checkpw(String.valueOf(password), password_DB)) {
                            JOptionPane.showMessageDialog(LoginForm.this, "Login successful!");
                            loggedIn = true;
                            LoginForm.super.dispose();

                            CreateCourseForm createCourseForm = new CreateCourseForm(id);
                            createCourseForm.setVisible(true);
                        }
                    }

                } catch (SQLException ex) {
                    ex.printStackTrace();
                }

                if (!loggedIn) {
                    JOptionPane.showMessageDialog(LoginForm.this, "Login failed!");
                    clearFields();
                }

            }

            public void clearFields() {
                // Clear values in username and password fields

                emailIDField.setText("");
                passwordField.setText("");

                emailIDField.requestFocus();
            }
        });

        closeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                LoginForm.super.dispose();
            }
        });
    }

    public static void main(String[] args) {
        LoginForm loginForm = new LoginForm();
        loginForm.setVisible(true);
    }
}
