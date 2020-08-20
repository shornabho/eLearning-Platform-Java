import org.mindrot.jbcrypt.BCrypt;

import java.util.ArrayList;
import java.util.List;

public abstract class User {
    protected String emailId;
    protected String name;
    protected String password;
    protected ArrayList<Course> courses = new ArrayList<>();

    User() {
        Teacher teacher1 = new Teacher("teacher1@university.com", "Teacher 1", "password");
        Teacher teacher2 = new Teacher("teacher2@university.com", "Teacher 2", "password");
        ArrayList<Teacher> teachersList = new ArrayList<>();
        teachersList.add(teacher1);
        teachersList.add(teacher2);

        Lesson lesson1 = new Lesson();
        Lesson lesson2 = new Lesson();
        ArrayList<Lesson> lessonsList = new ArrayList<>();
        lessonsList.add(lesson1);
        lessonsList.add(lesson2);

        this.addCourse("Course 1", teachersList, 75, lessonsList);
        this.addCourse("Course 2", teachersList, 53, lessonsList);
        this.addCourse("Course 3", teachersList, 29, lessonsList);
    }

    public String getEmailId() {
        return emailId;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public ArrayList<Course> getCourses() {
        return courses;
    }

    protected void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    protected void setName(String name) {
        this.name = name;
    }

    protected void setPassword(String password) {
        String passwordHash = BCrypt.hashpw(password, BCrypt.gensalt());
        this.password = passwordHash;
    }

    protected void addCourse(String courseName, ArrayList<Teacher> teachersInCharge, double numOfHours, ArrayList<Lesson> lessonsIncluded) {
        Course newCourse = new Course(courseName, teachersInCharge, numOfHours, lessonsIncluded);
        courses.add(newCourse);
    }

    public abstract void viewDetails();

    public boolean signUp(String name, String emailId, String password)
    {
        this.setName(name);
        this.setEmailId(emailId);
        this.setPassword(password);

        return true;
    }

    public boolean signIn(String emailId, String password)
    {
        if (emailId.equals(this.getEmailId()) && BCrypt.checkpw(password, this.getPassword()))
            return true;
        else
            return false;
    }
}
