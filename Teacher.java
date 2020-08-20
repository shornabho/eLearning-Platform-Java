public class Teacher extends User {

    Teacher() {
        super();
    }

    Teacher(String emailId, String name, String password) {
        this.setEmailId(emailId);
        this.setName(name);
        this.setPassword(password);
    }

    public void viewDetails() {
        System.out.println("Teacher Name: " + this.getName());
        System.out.println("Teacher Email: " + this.getEmailId());
        System.out.println("Teacher Encrypted Password: " + this.getPassword());
        System.out.println("Teacher Courses: ");

        for (Course course : this.getCourses())
        {
            course.showCourseDetails();
        }
    }
}
