import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class ReadFile {

    public static void main(String[] args) throws FileNotFoundException {
        String filePath = "Schulaufgaben/Data/wit1c_scores.txt";
        double total = 0;
        int itterations = 0;
        Scanner scanner = new Scanner(new FileReader(filePath));

        while(scanner.hasNextLine()){
            String user = scanner.nextLine();
            String[] strings = user.split(";");
            int grade = Integer.parseInt(strings[2]);
            total += grade;
            itterations++;
        }
        scanner.close();

        double average = total/itterations;
        StringBuilder out = new StringBuilder("Durchschnitt: ");
        System.out.println(out.append(average));

    }
}
