import org.mindrot.jbcrypt.BCrypt;

import java.util.ArrayList;

public abstract class User {
    protected String emailId;
    protected String name;
    protected String password;
    protected ArrayList<String> courses = new ArrayList<String>();

    public String getEmailId() {
        return emailId;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public ArrayList<String> getCourses() {
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

    protected void addCourse(String course) {
        courses.add(course);
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
