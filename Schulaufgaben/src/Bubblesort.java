import java.util.Random;
import java.util.Scanner;

public class Bubblesort {

    public static void main(String[]args){
        Scanner in = new Scanner(System.in);
        System.out.println("Größe des Arrays Eingeben:");
        int a = in.nextInt();
        int[] zahlenFeld = new int[a];
        Random rand = new Random();

        for(int i= 0; i< zahlenFeld.length;i++){
            zahlenFeld[i] = rand.nextInt(1000);
        }

        for (int z : zahlenFeld){
            System.out.print(z + " ");
        }
        System.out.println();

        bubbleSort(zahlenFeld, zahlenFeld.length);

        for (int i: zahlenFeld){
            System.out.print(i + " ");
        }
    }

    static void bubbleSort(int arr[], int n){
        int helper;
        if(n == 1){
            return;
        }
        for(int i = 0;i<n-1;i++){
            if(arr[i]> arr[i+1]){
                helper = arr[i];
                arr[i] = arr[i+1];
                arr[i+1] = helper;
            }
        }
        bubbleSort(arr, n-1);
    }
}
