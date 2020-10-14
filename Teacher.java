import org.mindrot.jbcrypt.BCrypt;

public class Teacher extends User {

    Teacher() {
        super();
    }

    Teacher(String emailId, String firstName, String lastName, String password) {
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

        if (Teachers.addStudent(this)) {
            return true;
        }
        else {
            return false;
        }
    }

//    public boolean signIn(String emailId, String password)
//    {
//        for (Teacher teacher : Teachers.getTeachersList()) {
//            System.out.println(password + " " + teacher.getPassword());
//            if (teacher.getEmailId().equals(emailId.trim()) && BCrypt.checkpw(password.trim(), teacher.getPassword()))
//                return true;
//        }
//
//        return false;
//    }

    public void viewDetails() {
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
