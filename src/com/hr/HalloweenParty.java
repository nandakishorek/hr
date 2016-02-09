/**
 * 
 */
package com.hr;

import java.util.Scanner;

/**
 * 
 * https://www.hackerrank.com/challenges/halloween-party
 * 
 * @author kishore
 *
 */
public class HalloweenParty {

    /**
     * @param args
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0) {
            int k = sc.nextInt();
            System.out.println(numOfPieces(k));
        }
        sc.close();
    }

    public static long numOfPieces(int k) {
        long n = 0;
        
        if (k > 1) {
           double temp = k / 2.00;
           n = (long)(Math.ceil(temp) * Math.floor(temp));
        }
        return n;
    }

}
