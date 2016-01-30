/**
 * 
 */
package com.hr;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 
 * https://www.hackerrank.com/challenges/alternating-characters
 * 
 * @author kishore
 *
 */
public class AltChars {

    /**
     * @param args
     */
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int t = Integer.parseInt(br.readLine());
            while (t-- > 0) {
                String str = br.readLine();
                char[] input = str.toCharArray();
                int count = 0;
                char prevChar = input[0];
                for (int i = 1; i < input.length; ++i) {
                    if (input[i] == prevChar) {
                        ++count;
                    } else {
                        prevChar = input[i];
                    }
                }
                System.out.println(count);
            }
        } catch (NumberFormatException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
