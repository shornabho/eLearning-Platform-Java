import java.util.ArrayList;

public class TestClass {
    public static ArrayList<Teacher> teachersList = new ArrayList<>();
    public static ArrayList<Lesson> lessonsList = new ArrayList<>();

    public static void create()
    {

        Teacher teacher1 = new Teacher("teacher1@university.com", "Teacher 1", "password");
        Teacher teacher2 = new Teacher("teacher2@university.com", "Teacher 2", "password");

        teachersList.add(teacher1);
        teachersList.add(teacher2);

        Lesson lesson1 = new Lesson("Lesson 1", "Welcome to Lesson 1.");
        Lesson lesson2 = new Lesson("Lesson 2", "Welcome to Lesson 2.");
        lessonsList.add(lesson1);
        lessonsList.add(lesson2);
    }
}
