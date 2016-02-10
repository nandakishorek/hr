/**
 * 
 */
package com.hr;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/the-love-letter-mystery
 * 
 * @author kishore
 *
 */
public class Palindrome {

    /**
     * @param args
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            String str = sc.next();
            System.out.println(minOpsToPalindrome(str));
        }
        sc.close();
    }
    
    public static int minOpsToPalindrome(String str) {
        int count = 0;
        int i = 0;
        int j = str.length() - 1;
        while(i < j) {
            char l = str.charAt(i);
            char r = str.charAt(j);
            if (l < r) {
                count += r - l;
            } else {
                count += l - r;
            }
            ++i;
            --j;
        }
        
        return count;
    }

}
