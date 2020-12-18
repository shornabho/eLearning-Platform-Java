import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeleteCourseForm extends JFrame{
    private JTextField courseIdField;
    private JButton deleteCourseButton;
    private JButton closeButton;
    private JPanel deleteCoursePanel;


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

    public DeleteCourseForm() {
        Connect();

        add(deleteCoursePanel);


        setTitle("Create Course Form");
        setSize(600,300);

        // Center window
        setLocationRelativeTo(null);


        // Set default button (Enter key) for the frame to trigger the loginButton
        this.getRootPane().setDefaultButton(deleteCourseButton);


        deleteCourseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int courseId = Integer.parseInt(courseIdField.getText());

                    preparedStatement = connection.prepareStatement("DELETE FROM Course WHERE courseId = ?;");
                    preparedStatement.setInt(1, courseId);
                    int i = preparedStatement.executeUpdate();

                    if (i > 0) {
                        JOptionPane.showMessageDialog(DeleteCourseForm.this, "Course deleted!");

                        DeleteCourseForm.super.dispose();


                    }

                } catch (NumberFormatException | SQLException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(DeleteCourseForm.this, "Course deletion failed!");

                    clearDetails();
                }

            }

            public void clearDetails() {
                courseIdField.setText("");

                courseIdField.requestFocus();
            }
        });
    }

    public static void main(String[] args) {
        DeleteCourseForm deleteCourseForm = new DeleteCourseForm();

        deleteCourseForm.setVisible(true);
    }
}
