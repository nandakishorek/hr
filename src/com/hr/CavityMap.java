/**
 * 
 */
package com.hr;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/cavity-map
 * 
 * @author kishore
 *
 */
public class CavityMap {

    /**
     * @param args
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        char[][] map = new char[n][];

        for (int i = 0; i < n; ++i) {
            String line = sc.next();
            map[i] = line.toCharArray();
        }

        for (int i = 1; i < n - 1; ++i) {
            for (int j = 1; j < n - 1; ++j) {
                if (map[i][j] > map[i - 1][j] &&
                        map[i][j] > map[i + 1][j] &&
                        map[i][j] > map[i][j+1] &&
                        map[i][j] > map[i][j-1]){
                    map[i][j] = 'X';
                }
            }
        }
        
        for (int i = 0; i < n; ++i) {
            System.out.println(map[i]);
        }
        
        sc.close();
    }

}
