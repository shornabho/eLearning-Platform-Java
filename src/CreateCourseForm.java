import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CreateCourseForm extends JFrame {
    private JTextField courseNameField;
    private JButton createCourseButton;
    private JButton cancelButton;
    private JTextField numOfHoursField;
    private JPanel createCoursePanel;

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

    public CreateCourseForm(int teacherInChargeId) {
        Connect();

        add(createCoursePanel);


        setTitle("Create Course Form");
        setSize(600,300);

        // Center window
        setLocationRelativeTo(null);


        // Set default button (Enter key) for the frame to trigger the loginButton
        this.getRootPane().setDefaultButton(createCourseButton);


        createCourseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String courseName = courseNameField.getText();
                    int numOfHours = Integer.parseInt(numOfHoursField.getText());

                    preparedStatement = connection.prepareStatement("INSERT INTO Course (courseName,teacherInCharge,numOfHours) VALUES(?,?,?);");
                    preparedStatement.setString(1, courseName);
                    preparedStatement.setInt(2, teacherInChargeId);
                    preparedStatement.setInt(3, numOfHours);
                    int i = preparedStatement.executeUpdate();

                    if (i > 0) {
                        JOptionPane.showMessageDialog(CreateCourseForm.this, "Course Created!");

                        CreateCourseForm.super.dispose();

                        
                    }

                } catch (NumberFormatException | SQLException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(CreateCourseForm.this, "Course Creation failed!");

                    clearDetails();
                }

            }

            public void clearDetails() {
                courseNameField.setText("");
                numOfHoursField.setText("");

                courseNameField.requestFocus();
            }
        });
    }
}
