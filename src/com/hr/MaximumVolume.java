/**
 * 
 */
package com.hr;

import java.util.Scanner;

/**
 * @author kishore
 *
 */
public class MaximumVolume {

    /**
     * @param args
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int part = n / 3;
        if (n % 3 == 0) {
            System.out.println((int)Math.pow(part, 3));
        } else if ((n - 1) % 3 == 0){
            long vol = part * part * (part + 1);
            System.out.println(vol);
        } else {
            long vol = (part + 1) * (part + 1) * part;
            System.out.println(vol);
        }
    }

}
