import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class Students {
    private static List<Student> studentList = new ArrayList<>();
    private static final String STUDENTS_CSV_FILE = "../assets/data/Students.csv";

    public static void readStudentsFromFile() {
        studentList.clear();

        List<String[]> rows = CSVHandler.readCSV(STUDENTS_CSV_FILE);

        for (String[] row : rows) {
            studentList.add(createStudent(row));
        }
    }

    private static Student createStudent(String[] row) { return new Student(row[0], row[1], row[2], row[3]); }

    public static List<Student> getStudentList() {
        readStudentsFromFile();
        return studentList;
    }

    public static boolean addStudent(Student student) {

        String[] data = {student.getEmailId(), student.getFirstName(), student.getLastName(), student.getPassword()};

        try {
            CSVHandler.writeCSV(STUDENTS_CSV_FILE, data);
        }
        catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

}
