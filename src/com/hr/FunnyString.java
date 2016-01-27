package com.hr;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Problem Statement

Suppose you have a string S that has the length N. It is indexed from 0 to N−1. String R is the reverse of string S. The string S is funny if the condition |Si−Si−1|=|Ri−Ri−1| is true for every i from 1 to N−1.

Note: Given a string str, stri denotes the ascii value of the ith character (0-indexed) of str. Here, |x| denotes the absolute value of an integer x.

Input Format

The first line of input will contain an integer T, the number of test cases. Each of the next T lines contains one string S.

Constraints

    1<=T<=10
    2<=length of S<=10000

Output Format

For each string, print Funny or Not Funny on separate lines.

 * @author kishore
 *
 */
public class FunnyString {

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int t = Integer.parseInt(br.readLine());
            while(t-- > 0) {
                char[] str = br.readLine().toCharArray();
                int i;
                for (i = 0 ; i < str.length - 1; ++i) {
                    int j = str.length - i - 1;
                    if (Math.abs(str[i] - str[i+1]) != Math.abs(str[j] - str[j-1])) {
                        System.out.println("Not Funny");
                        break;
                    }
                }
                if (i == str.length - 1) {
                    System.out.println("Funny");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
