import java.util.Scanner;

public class FlippingBits {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0) {
            System.out.println(flipBits(sc.nextLong()));
        }
        sc.close();
    }
    
    public static long flipBits(long n) {
        return ~n & 0xFFFFFFFFL;
    }

}
