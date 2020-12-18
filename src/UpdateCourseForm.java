import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdateCourseForm extends JFrame{
    private JTextField courseIdField;
    private JTextField numOfHoursField;
    private JButton updateCourseButton;
    private JButton closeButton;
    private JPanel updateCoursePanel;

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

    public UpdateCourseForm() {
        Connect();

        add(updateCoursePanel);


        setTitle("Create Course Form");
        setSize(600,300);

        // Center window
        setLocationRelativeTo(null);


        // Set default button (Enter key) for the frame to trigger the loginButton
        this.getRootPane().setDefaultButton(updateCourseButton);


        updateCourseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int courseId = Integer.parseInt(courseIdField.getText());
                    int numOfHours = Integer.parseInt(numOfHoursField.getText());

                    preparedStatement = connection.prepareStatement("UPDATE Course SET numOfHours = ? WHERE courseId = ?;");
                    preparedStatement.setInt(1, numOfHours);
                    preparedStatement.setInt(2, courseId);
                    int i = preparedStatement.executeUpdate();

                    if (i > 0) {
                        JOptionPane.showMessageDialog(UpdateCourseForm.this, "Course updated!");

                        UpdateCourseForm.super.dispose();


                    }

                } catch (NumberFormatException | SQLException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(UpdateCourseForm.this, "Course updation failed!");

                    clearDetails();
                }

            }

            public void clearDetails() {
                courseIdField.setText("");
                numOfHoursField.setText("");

                courseIdField.requestFocus();
            }
        });
    }

    public static void main(String[] args) {
        UpdateCourseForm updateCourseForm = new UpdateCourseForm();

        updateCourseForm.setVisible(true);
    }
}
