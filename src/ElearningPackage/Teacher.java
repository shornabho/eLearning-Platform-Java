package ElearningPackage;

import org.mindrot.jbcrypt.BCrypt;

public class Teacher extends User {

    Teacher() {
        // Call User class constructor
        super();
    }

    Teacher(String emailId, String firstName, String lastName, String password) {
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
        // Hash the password for input in db
        String passwordHash = BCrypt.hashpw(password.trim(), BCrypt.gensalt());
        // Create new teacher instance
        Teacher teacher = new Teacher(emailId, firstName, lastName, passwordHash);
        // Add teacher to teachers db
        Teachers.addTeacher(teacher);

        return teacher;
    }

    public static User signIn(String emailId, String password)
    {
        // Fetch appropriate teacher from db matching email and password
        for (Teacher teacher : Teachers.getTeachersList()) {
            if (teacher.getEmailId().equals(emailId.trim()) && BCrypt.checkpw(password.trim(), teacher.getPassword()))
                return teacher;
        }

        return null;
    }

    public void viewDetails() {
        // View teacher details
        System.out.println("Teacher's Name: " + this.getFullName());
        System.out.println("Teacher's Email: " + this.getEmailId());
        System.out.println("Teacher's Encrypted Password: " + this.getPassword());
        System.out.println("Teacher's Courses: ");

        for (Course course : this.getCourses())
        {
            course.showCourseDetails();
        }
    }
}
