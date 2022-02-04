public class Binomialkoeffizient {

    public static void main(String[] args) {

        long e = binom(21,6);
        System.out.println(e);

    }

    public static long fact(long n){
        long ex = 1;
        if(n == ex){
            return ex;
        }
        return fact(n-ex)*n;
    }

    public static long binom(long n, long k){

        long upper = fact(n);
        long lower = fact(k) * fact((n-k));
        return upper/lower;
    }
}
