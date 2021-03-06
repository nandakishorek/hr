package com.hr;
import java.util.Scanner;

public class MaximizingXOR {

    static int maxXor(int l, int r) {
        int maxVal = -1;
        for (int i = l; i <= r; ++i) {
            for (int j = l; j <= r; ++j) {
                if ((i ^ j) > maxVal) {
                    maxVal = i ^ j;
                }
            }
        }
        return maxVal;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int res;
        int _l;
        _l = Integer.parseInt(in.nextLine());
        
        int _r;
        _r = Integer.parseInt(in.nextLine());
        
        res = maxXor(_l, _r);
        System.out.println(res);
        in.close();
    }

}
