/**
 * 
 */
package com.hr;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/find-digits
 * 
 * @author kishore
 *
 */
public class FindDigits {

    /**
     * @param args
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0) {
            int n = sc.nextInt();
            int tempN = n;
            int count = 0;
            while(tempN > 0) {
                int digit = tempN % 10;
                if (digit > 0 && n %  digit == 0) {
                    ++count;
                }
                tempN /= 10;
            }
            System.out.println(count);
        }
        sc.close();
    }
    

}
