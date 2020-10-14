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

    public boolean signUp(String firstName, String lastName, String emailId, String password) throws EmptyFieldException
    {
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

        this.setFirstName(firstName);
        this.setLastName(lastName);
        this.setEmailId(emailId);
        this.setPassword(password);

        if (Students.addStudent(this)) {
            return true;
        }
        else {
            return false;
        }
    }

//    public boolean signIn(String emailId, String password)
//    {
//        for (Student student : Students.getStudentList()) {
//            if (student.getEmailId().equals(emailId.trim()) && BCrypt.checkpw(password.trim(), student.getPassword()))
//                return true;
//        }
//
//        return false;
//    }

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
