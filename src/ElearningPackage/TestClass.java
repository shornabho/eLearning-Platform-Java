package ElearningPackage;

import java.util.ArrayList;
import java.time.Duration;

public class TestClass {
    public static ArrayList<Teacher> teachersList = new ArrayList<>();
    public static ArrayList<Lesson> lessonsList = new ArrayList<>();

    static
    {

        Teacher teacher1 = new Teacher("teacher1@university.com", "Teacher", "1", "password");
        Teacher teacher2 = new Teacher("teacher2@university.com", "Teacher", "1", "password");

        teachersList.add(teacher1);
        teachersList.add(teacher2);

        Lesson lesson1 = new TextLesson("Lesson 1", "Welcome to Lesson 1.", Duration.parse("PT15M20S"));
        Lesson lesson2 = new TextLesson("Lesson 2", "Welcome to Lesson 2.", Duration.parse("PT10M25S"));
        lessonsList.add(lesson1);
        lessonsList.add(lesson2);
    }
}
