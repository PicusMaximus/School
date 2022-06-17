import java.io.*;
import java.util.ArrayList;

public class WriteFile {

    public static void main(String[] args) throws IOException {
        String filePath = "Schulaufgaben/Data/Classes";
        File folder = new File(filePath);
        ArrayList<String> names = new ArrayList<>();
        ArrayList<String> classes = new ArrayList<>();
        File[] listOfFiles = folder.listFiles();
        assert listOfFiles != null;

        for (File file : listOfFiles) {
            if (file.isFile()) {
                classes.add(folder + File.separator + file.getName());
            }
        }

        try (BufferedReader br = new BufferedReader(new FileReader(classes.get(0)))) {
            String name = null;
            for (int i = 0; i < 3; i++) {
                name = br.readLine();
            }
            while (name != null) {
                name = name.split(";")[0];
                names.add(name);
                name = br.readLine();
            }
        }

        boolean result = true;
        File output = new File("Resources" + File.separator + "Students");
        if (!output.exists()) {
            result = output.mkdirs();
        }
        if (result) {
            for (String n : names) {
                try (BufferedWriter bw = new BufferedWriter(new FileWriter(output + File.separator + n + ".txt"))) {
                    bw.write("Zeugnis für " + n);
                    for (String c : classes) {
                        bw.newLine();
                        try (BufferedReader br = new BufferedReader(new FileReader(c))) {
                            String fach = br.readLine().split(";")[1];
                            String note = null;
                            for (int i = 0; i < 2 + names.indexOf(n); i++) {
                                note = br.readLine();
                            }
                            assert note != null;
                            note = note.split(";")[1];
                            bw.write(fach + ": " + note);
                        }
                    }
                }
            }
        }
    }
}



