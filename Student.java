public class Student extends User {

    Student() {
        addCourse("Course 1");
        addCourse("Course 2");
        addCourse("Course 3");
    }

    Student(String emailId, String name, String password) {
        this.setEmailId(emailId);
        this.setName(name);
        this.setPassword(password);
    }

    public void viewDetails() {
        System.out.println("Student Name: " + this.getName());
        System.out.println("Student Email: " + this.getEmailId());
        System.out.println("Student Encrypted Password: " + this.getPassword());
        System.out.println("Student Courses: ");

        for (String course : this.getCourses())
        {
            System.out.println(course);
        }
    }
}
