/**
 * 
 */
package com.hr;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/fibonacci-modified
 * 
 * @author kishore
 *
 */
public class FibonacciModified {

    /**
     * @param args
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int n = sc.nextInt();
        
        if (n == 1) {
            System.out.println(a);
        } else if (n == 2) {
            System.out.println(b);
        } else {
            int i = 3; 
            BigInteger prev1 = new BigInteger(Integer.toString(a));
            BigInteger prev = new BigInteger(Integer.toString(b));
            BigInteger cur = prev1.add(prev.pow(2));
            while (i < n) {
                prev1 = prev;
                prev = cur;
                cur = prev1.add(prev.pow(2));
                ++i;
            }
            System.out.println(cur.toString());
        }
        sc.close();
    }

}
