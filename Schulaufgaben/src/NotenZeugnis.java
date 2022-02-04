import java.sql.SQLOutput;
import java.util.Scanner;

public class NotenZeugnis {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int schuelerIDs = readLineInt("Anzahl Schueler: ");
        double[][] schueler = new double[schuelerIDs][10];

        for(int i = 0; i  < schuelerIDs;i++){
            int amount = readLineInt("Schueler " + (i+1) + ": Anzahl Noten:");
            for(int y = 0; y < amount;y++) {
                System.out.printf("Note %d ",(y+1));
                schueler[i][y] = in.nextDouble();
            }
        }
        averageOfMultiArray(schueler);
    }

    public static void averageOfMultiArray(double arr[][]){
        double Grade = 0;
        for(int z = 0; z < arr.length;z++){
            int temp = 0;
            for(int y= 0;y< arr[z].length;y++){
                temp += arr[z][y];
            }
            int divisor = 0;
            for(int x = 0; x< arr[z].length;x++){
                if(arr[z][x] != 0.0 )
                    divisor++;
            }
            Grade =  (double) temp/divisor;
            System.out.printf("Schueler %d: Note %.1f %n",z+1,Grade);
        }
    }

    public static int readLineInt(String msg){
        int result = 0;
        System.out.println(msg);
        Scanner in = new Scanner(System.in);
        result = in.nextInt();
        return result;
    }

}
