import java.util.ArrayList;
import java.util.Collections;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class NameSorter {

    public static void main(String[] args) throws Exception {
        ArrayList<Name> nameList = new ArrayList<Name>();
        String inputPath = (args.length>0) ? args[0] : "./unsorted-names-list.txt";

        int lineNumber = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(inputPath))) {
            String line;
            while ((line = br.readLine()) != null) {
                lineNumber++;
                try {
                    if (!line.isBlank()) {
                        nameList.add(new Name(line));
                    }
                } catch (IllegalArgumentException e) {
                    System.out.println("Error at line " + lineNumber + ", name: " + e.getMessage());
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        Collections.sort(nameList);

        for (Name name : nameList) {
            System.out.println(name.toString());
        }

        try {
            File outputFile = new File("./sorted-names-list.txt");
            outputFile.createNewFile();
            FileWriter fw = new FileWriter(outputFile);
            for (Name name : nameList) {
                fw.write(name.toString() + "\n");
            }

            fw.close();

        } catch (IOException e) {
            System.out.println("Fail to write into the output file.");
            e.printStackTrace();
        }

    }
}
