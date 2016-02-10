/**
 * 
 */
package com.hr;

import java.util.Arrays;
import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/pairs
 * 
 * @author kishore
 *
 */
public class Pairs {

    static int pairs(int[] a, int k) {
        // my logic
        int count = 0;
        Arrays.sort(a);
        int[] diffs = new int[a.length - 1];
        for (int i = 0; i < a.length - 1; ++i) {
            diffs[i] = a[i + 1] - a[i];
        }
        
        int sum = 0;
        for (int i = 0; i < diffs.length; ++i) {
            if (diffs[i] == k) {
                sum = 0;
                ++count;
            } else {
                sum += diffs[i];
                if (sum == k) {
                    ++count;
                    sum = diffs[i];
                } else if (sum > k) {
                    if (diffs[i] > k) {
                        sum = 0;
                    } else {
                        sum = diffs[i];
                    }
                }
            }
        }
        
        return count;
    }

    /**
     * This was provided in the template
     * 
     * @param args
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int res;

        String n = in.nextLine();
        String[] n_split = n.split(" ");

        int _a_size = Integer.parseInt(n_split[0]);
        int _k = Integer.parseInt(n_split[1]);

        int[] _a = new int[_a_size];
        int _a_item;
        String next = in.nextLine();
        String[] next_split = next.split(" ");

        for (int _a_i = 0; _a_i < _a_size; _a_i++) {
            _a_item = Integer.parseInt(next_split[_a_i]);
            _a[_a_i] = _a_item;
        }

        res = pairs(_a, _k);
        System.out.println(res);
    }

}
