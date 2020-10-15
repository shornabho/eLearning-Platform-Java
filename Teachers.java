import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Teachers {
    private static List<Teacher> teachersList = new ArrayList<>();
    private static final String TEACHERS_CSV_FILE = "../assets/data/Teachers.csv";

    public static void readTeachersFromFile() {
        teachersList.clear();

        List<String[]> rows = CSVHandler.readCSV(TEACHERS_CSV_FILE);

        for (String[] row : rows) {
            teachersList.add(createTeacher(row));
        }
    }

    private static Teacher createTeacher(String[] row) { return new Teacher(row[0].trim(), row[1].trim(), row[2].trim(), row[3]); }

    public static List<Teacher> getTeachersList() {
        readTeachersFromFile();
        return teachersList;
    }

    public static boolean addTeacher(Teacher teacher) {

        String[] data = {teacher.getEmailId(), teacher.getFirstName(), teacher.getLastName(), teacher.getPassword()};

        try {
            CSVHandler.writeCSV(TEACHERS_CSV_FILE, data);
        }
        catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

}
