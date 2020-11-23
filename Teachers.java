package ElearningPackage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import CSVHandler.CSVHandler;

public class Teachers {
    private static List<Teacher> teachersList = new ArrayList<>();
    private static final String TEACHERS_CSV_FILE = "assets/data/Teachers.csv";

    public static void readTeachersFromFile() {
        // This is a helper function to get teachers list from file

        // Clear existing values in teachersList before appending rows
        teachersList.clear();

        // Read CSV file for teachers list
        List<String[]> rows = CSVHandler.readCSV(TEACHERS_CSV_FILE);

        // Append row wise into csv file
        for (String[] row : rows) {
            teachersList.add(createTeacher(row));
        }
    }

    // Create new teacher and return a Teacher instance
    private static Teacher createTeacher(String[] row) { return new Teacher(row[0].trim(), row[1].trim(), row[2].trim(), row[3]); }

    public static List<Teacher> getTeachersList() {
        // Uses helper function to read the teachers from file first 
        // Helper function used for better readability and potential code reusability
        readTeachersFromFile();
        return teachersList;
    }

    public static boolean addTeacher(Teacher teacher) {
        // Adds a passed teacher to db

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
