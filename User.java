import org.mindrot.jbcrypt.BCrypt;
import java.util.ArrayList;

public abstract class User {
    protected String emailId;
    protected String firstName;
    protected String lastName;
    protected String password;
    protected ArrayList<Course> courses = new ArrayList<>();

    User() {
        this.addCourse("Course 1", TestClass.teachersList, 75, TestClass.lessonsList);
        this.addCourse("Course 2", TestClass.teachersList, 53, TestClass.lessonsList);
        this.addCourse("Course 3", TestClass.teachersList, 29, TestClass.lessonsList);
    }

    public String getEmailId() {
        return emailId;
    }

    public String getPassword() {
        return password;
    }

    public String getFirstName() { return firstName; }

    public String getLastName() { return lastName; }

    public String getFullName() {
        StringBuffer fullName = new StringBuffer(firstName.trim());
        fullName.append(" " + lastName.trim());
        return fullName.toString();
    }

    public ArrayList<Course> getCourses() {
        return courses;
    }

    protected void setEmailId(String emailId) {
        this.emailId = emailId.trim();
    }

    protected void setPassword(String encrpytedPassword) { this.password = encrpytedPassword; }

    public void setFirstName(String firstName) { this.firstName = firstName.trim(); }

    public void setLastName(String lastName) { this.lastName = lastName.trim(); }

    protected void addCourse(String courseName, ArrayList<Teacher> teachersInCharge, double numOfHours, ArrayList<Lesson> lessonsIncluded) {
        Course newCourse = new Course(courseName, teachersInCharge, numOfHours, lessonsIncluded);
        courses.add(newCourse);
    }

    public abstract void viewDetails();

    public static User signUp(String firstName, String lastName, String emailId, String password) throws EmptyFieldException {
        return null;
    }

    public static User signIn(String emailId, String password)
    {
        return null;
    }
}
