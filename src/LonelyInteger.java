import java.util.Scanner;

/**
 * Problem Statement
 * 
 * There are N integers in an array A. All but one integer occur in pairs. Your
 * task is to find the number that occurs only once.
 * 
 * Input Format
 * 
 * The first line of the input contains an integer N, indicating the number of
 * integers. The next line contains N space-separated integers that form the
 * array A.
 * 
 * Constraints
 * 
 * 1≤N<100 N % 2=1 (N is an odd number) 0≤A[i]≤100,∀i∈[1,N]
 * 
 * Output Format
 * 
 * Output S, the number that occurs only once.
 * 
 * @author kishore
 *
 */
public class LonelyInteger {
    
    static int lonelyinteger(int[] a) {
        
        int candidate = a[0];
        for(int i = 1; i < a.length; ++i) {
            candidate ^= a[i];
        }
        
        return candidate;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int res;

        int _a_size = Integer.parseInt(in.nextLine());
        int[] _a = new int[_a_size];
        int _a_item;
        String next = in.nextLine();
        String[] next_split = next.split(" ");

        for (int _a_i = 0; _a_i < _a_size; _a_i++) {
            _a_item = Integer.parseInt(next_split[_a_i]);
            _a[_a_i] = _a_item;
        }

        res = lonelyinteger(_a);
        System.out.println(res);

    }

}
