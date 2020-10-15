import org.mindrot.jbcrypt.BCrypt;

public class Student extends User {

    Student() {
        super();
    }

    Student(String emailId, String firstName, String lastName, String password) {
        this.setEmailId(emailId);
        this.setFirstName(firstName);
        this.setLastName(lastName);
        this.setPassword(password);
    }

    public static User signUp(String firstName, String lastName, String emailId, String password) throws EmptyFieldException {
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


        String passwordHash = BCrypt.hashpw(password.trim(), BCrypt.gensalt());

        Student student = new Student(emailId, firstName, lastName, passwordHash);

        Students.addStudent(student);

        return student;
    }

    public static User signIn(String emailId, String password)
    {
        for (Student student : Students.getStudentList()) {
            if (student.getEmailId().equals(emailId.trim()) && BCrypt.checkpw(password.trim(), student.getPassword()))
                return student;
        }

        return null;
    }

    public void viewDetails() {
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
