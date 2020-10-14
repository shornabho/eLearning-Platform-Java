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
