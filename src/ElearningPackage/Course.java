package ElearningPackage;

import java.time.Duration;
import java.util.ArrayList;

public class Course {
    private long courseId;
    private String courseName;
    private Duration courseDuration;
    private ArrayList<Teacher> teachersInCharge;
    private double numOfHours;
    private ArrayList<Lesson> lessonsIncluded;

    private static long lastCourseId;

    Course(String courseName, ArrayList<Teacher> teachersInCharge, double numOfHours, ArrayList<Lesson> lessonsIncluded) {
        this.setCourseId(++lastCourseId);
        this.setCourseName(courseName);
        this.setTeachersInCharge(teachersInCharge);
        this.setNumOfHours(numOfHours);
        this.setLessonsIncluded(lessonsIncluded);
    }

    public static long getLastCourseId() {
        return Course.lastCourseId;
    }

    private static void setLastCourseId(long lastCourseId) {
        Course.lastCourseId = getLastCourseId() + 1;
    }

    public long getCourseId() {
        return courseId;
    }

    private void setCourseId(long courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public Duration getCourseDuration() {
        return courseDuration;
    }

    public void setCourseDuration(Duration courseDuration) {
        this.courseDuration = courseDuration;
    }

    public ArrayList<Teacher> getTeachersInCharge() {
        return teachersInCharge;
    }

    public void setTeachersInCharge(ArrayList<Teacher> teachersInCharge) {
        this.teachersInCharge = teachersInCharge;
    }

    public double getNumOfHours() {
        return numOfHours;
    }

    public void setNumOfHours(double numOfHours) {
        this.numOfHours = numOfHours;
    }

    public ArrayList<Lesson> getLessonsIncluded() {
        return lessonsIncluded;
    }

    public void setLessonsIncluded(ArrayList<Lesson> lessonsIncluded) {
        this.lessonsIncluded = lessonsIncluded;
    }

    public void showCourseDetails() {
        System.out.println();
        System.out.println("\t*************");
        System.out.println("\tCourse Id: " + getCourseId());
        System.out.println("\tCourse: " + getCourseName());
        System.out.println("\tTeachers: ");
        for (Teacher teacher : getTeachersInCharge())
        {
            System.out.println("\t" + teacher.getFullName());
        }
        System.out.println("\tNumber of Hours: " + getNumOfHours());
        for (Lesson lesson : getLessonsIncluded())
        {
            lesson.showLessonDetails();
        }
    }
}
