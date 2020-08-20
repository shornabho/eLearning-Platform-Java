import java.util.ArrayList;

public class Course {
    private String courseName;
    private ArrayList<Teacher> teachersInCharge;
    private double numOfHours;
    private ArrayList<Lesson> lessonsIncluded;

    Course(String courseName, ArrayList<Teacher> teachersInCharge, double numOfHours, ArrayList<Lesson> lessonsIncluded) {
        this.setCourseName(courseName);
        this.setTeachersInCharge(teachersInCharge);
        this.setNumOfHours(numOfHours);
        this.setLessonsIncluded(lessonsIncluded);
    }

    public String getCourseName() {
        return courseName;
    }

    public ArrayList<Teacher> getTeachersInCharge() {
        return teachersInCharge;
    }

    public double getNumOfHours() {
        return numOfHours;
    }

    public ArrayList<Lesson> getLessonsIncluded() {
        return lessonsIncluded;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public void setTeachersInCharge(ArrayList<Teacher> teachersInCharge) {
        this.teachersInCharge = teachersInCharge;
    }

    public void setNumOfHours(double numOfHours) {
        this.numOfHours = numOfHours;
    }

    public void setLessonsIncluded(ArrayList<Lesson> lessonsIncluded) {
        this.lessonsIncluded = lessonsIncluded;
    }
}
