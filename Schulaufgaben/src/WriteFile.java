import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class WriteFile {

    public static void main(String[] args) throws IOException {
        String filePath = "Schulaufgaben/Data/Classes";
        File folder = new File(filePath);
        ArrayList<String> classes = new ArrayList<>();
        File[] listOfFiles = folder.listFiles();
        assert listOfFiles != null;

        for(File file : listOfFiles){
            if(file.isFile()){
                classes.add(folder + File.separator + file.getName());
            }
        }
        BufferedReader br = new BufferedReader(new FileReader(classes.get(0)));
        ArrayList<String> names = new ArrayList<>();
        String name = null;
        for(int i = 0; i< 3;i++){
            name = br.readLine();
        }
        while(name != null){
            name = name.split(";")[0];
            names.add(name);
            name = br.readLine();
        }

        for(String n: names){
            File output = new File("Resources" + File.separator + "Students");
            if(!output.exists()){
                output.mkdirs();
            }
            BufferedWriter bw = new BufferedWriter(new FileWriter(output + File.separator + n + ".txt"));
            bw.write("Zeugnis für " + n);
            for(String c:classes){
                bw.newLine();
                br = new BufferedReader(new FileReader(c));
                String fach = br.readLine().split(";")[1];
                String note = null;
                for(int i = 0; i< 2 + names.indexOf(n);i++){
                    note = br.readLine();
                }
                assert note != null;
                note = note.split(";")[1];
                bw.write(fach + ": " + note);
            }
            bw.close();
            br.close();
        }
    }
}



