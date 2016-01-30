/**
 * 
 */
package com.hr;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * https://www.hackerrank.com/challenges/pangrams
 * 
 * @author kishore
 *
 */
public class Pangrams {

    /**
     * @param args
     */
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int[] counts = new int[26];
            String str = br.readLine().toLowerCase();
            for(char c : str.toCharArray()) {
                int diff = c - 'a';
                if (diff >= 0 && diff <26) {
                    counts[diff] += 1;
                }
            }
            
            boolean isPangram = true;
            for (int i : counts) {
                if (i < 1) {
                    isPangram = false;
                    break;
                }
            }
            
            if (isPangram) {
                System.out.println("pangram");
            } else {
                System.out.println("not pangram");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
