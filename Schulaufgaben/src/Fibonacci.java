import java.util.Scanner;

public class Fibonacci {

    static long[] alreadyDone = new long[92];
    public static void main(String[] args) {

        int previousNumber = 0;
        int nextNumber = 1;
        Scanner in = new Scanner(System.in);

        System.out.println("Fibonacci von: ");
        int x = in.nextInt();

        System.out.println("Fibonacci Recursive:");
        for(int i = 0; i <= x; i++){
            System.out.print(fibonacci(i) + " ");
        }
        System.out.println("\n");

        System.out.println("Fibonacci Iterative:");
        for(int y =0; y <= x;y++){
            System.out.print(previousNumber + " ");
            int sum = previousNumber + nextNumber;
            previousNumber = nextNumber;
            nextNumber = sum;
        }
        System.out.println("\n");

        System.out.println("Fibonacci improved");
        for(int i =0;i <= x; i++){
            System.out.print(fibImproved(i) + " ");
        }
    }

    public static int fibonacci(int n)  {
        if(n == 0)
            return 0;
        else if(n == 1 || n == 2)
            return 1;
        else
            return fibonacci(n - 1) + fibonacci(n - 2);
    }

    public static long fibImproved(int n){
        if(alreadyDone[n] > 0) return alreadyDone[n];
        if(n> 1){
            alreadyDone[n] = fibImproved(n-1)+ fibImproved(n-2);
            return alreadyDone[n];
        }else{
            return n;
        }
    }
}
