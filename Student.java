package ElearningPackage;

import org.mindrot.jbcrypt.BCrypt;

public class Student extends User {

    Student() {
        // Call User class constructor
        super();
    }

    Student(String emailId, String firstName, String lastName, String password) {
        this.setEmailId(emailId);
        this.setFirstName(firstName);
        this.setLastName(lastName);
        this.setPassword(password);
    }

    public static User signUp(String firstName, String lastName, String emailId, String password) throws EmptyFieldException {
        // Validate fields
        if (firstName.isBlank()) {
            throw new EmptyFieldException("First name field is blank.");
        }
        else if (lastName.isBlank()) {
            throw new EmptyFieldException("Last name field is blank.");
        }
        else if (emailId.isBlank()) {
            throw new EmptyFieldException("Email Id field is blank.");
        }
        else if (password.isBlank()) {
            throw new EmptyFieldException("Password field is blank.");
        }

        // Hash password before entering to db
        String passwordHash = BCrypt.hashpw(password.trim(), BCrypt.gensalt());
        // Create new student instance
        Student student = new Student(emailId, firstName, lastName, passwordHash);
        // Add student to students db
        Students.addStudent(student);

        return student;
    }

    public static User signIn(String emailId, String password)
    {
        // Fetch appropriate student from db matching email and password
        for (Student student : Students.getStudentList()) {
            if (student.getEmailId().equals(emailId.trim()) && BCrypt.checkpw(password.trim(), student.getPassword()))
                return student;
        }

        return null;
    }

    public void viewDetails() {
        // View student details
        System.out.println("Student Name: " + this.getFullName());
        System.out.println("Student Email: " + this.getEmailId());
        System.out.println("Student Encrypted Password: " + this.getPassword());
        System.out.println("Student Courses: ");

        for (Course course : this.getCourses())
        {
            course.showCourseDetails();
        }
    }
}
