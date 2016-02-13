/**
 * 
 */
package com.hr;

import java.util.Arrays;
import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/icecream-parlor
 * 
 * @author kishore
 *
 */
public class IceCreamParlor {

    /**
     * @param args
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int m = sc.nextInt();
            int n = sc.nextInt();
            Cost[] c = new Cost[n];
            for (int i = 0; i < c.length; ++i) {
                c[i] = new Cost(sc.nextInt(), i + 1);
            }
            printIndices(m, c);
        }
        sc.close();
    }
    
    public static void printIndices(int m, Cost[] c) {
        Arrays.sort(c);
        for (int i = 0; i < c.length - 1; ++i) {
            int key = m - c[i].getValue();
            int pos = -1;
            
            if (key > 0) {
                int low = i + 1;
                int high = c.length - 1;
                while (low <= high) {
                    int mid = (low + high) / 2;
                    if (c[mid].getValue() == key) {
                        pos = mid;
                        break;
                    } if (key < c[mid].getValue()) {
                        high = mid - 1;
                    } else {
                        low = mid + 1;
                    }
                }
            }
            
            if (pos > -1) {
                if (c[i].getIndex() < c[pos].getIndex()) {
                    System.out.println(c[i].getIndex() + " " + c[pos].getIndex());
                } else {
                    System.out.println(c[pos].getIndex() + " " + c[i].getIndex());
                }
                break;
            }
        }
    }
    
    private static class Cost implements Comparable<Cost>{
        private int mValue;
        private int mIndex;
        
        Cost(int value, int index) {
            mValue = value;
            mIndex = index;
        }

        @Override
        public int compareTo(Cost other) {
            if (this.mValue < other.mValue) {
                return -1;
            } else if (this.mValue > other.mValue) {
                return 1;
            }
            return 0;
        }
        
        public int getValue() {
            return mValue;
        }
        
        public int getIndex() {
            return mIndex;
        }
        
        @Override
        public String toString() {
            return "IceCreamParlor[ value = " + mValue + ", index = " + mIndex +"]";
        }
    }
}
