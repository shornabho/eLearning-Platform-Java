import java.io.*;
import java.nio.Buffer;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class CSVHandler {

    public static List<String[]> readCSV(String fileName)
    {
        List<String[]> rows = new ArrayList<String[]>();
        Path pathToFile = Paths.get(fileName);

        try (BufferedReader br = Files.newBufferedReader(pathToFile, StandardCharsets.US_ASCII)) {

            String line = br.readLine();

            while (line != null) {
                String[] row = line.split(",");

                rows.add(row);

                line = br.readLine();
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        return rows;
    }

    public static void writeCSV (String fileName, String[] data) throws IOException
    {
        FileWriter csvFile = new FileWriter(fileName, true);
        BufferedWriter bw = new BufferedWriter(csvFile);

        String row = String.join(",", data);

        if (readCSV(fileName).isEmpty())
        {
            bw.write(row.toString());
        }
        else {
            bw.write("\n" + row.toString());
        }

        bw.close();

    }
}
