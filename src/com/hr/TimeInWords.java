package com.hr;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/the-time-in-words
 * 
 * @author kishore
 *
 */
public class TimeInWords {

    public static void main(String[] args) {

        String[] nums = {"", "one ", "two ", "three ", "four ", "five ", "six ", "seven ", "eight ", "nine ", "ten ", "eleven ",
                "twelve ", "thirteen ", "fourteen ", "fifteen ", "sixteen ", "seventeen ", "eighteen ", "nineteen ", "twenty "};
        String[] special = {"o' clock ", "half ", "past ", "quarter ", "to ", "minute ", "minutes "};
        
        Scanner in = new Scanner(System.in);
        int h = in.nextInt();
        int m = in.nextInt();
        
        StringBuilder output = new StringBuilder();

        if (m == 0) {
            output.append(nums[h]);
            output.append(special[0]);
        } else if (m == 15) {
            output.append(special[3]); // quarter
            output.append(special[2]); // past
            output.append(nums[h]);
        } else if (m == 30){
            output.append(special[1]); // half
            output.append(special[2]); // past
            output.append(nums[h]);
        } else if (m == 45) {
            output.append(special[3]); // quarter
            output.append(special[4]); // to
            output.append(nums[(h + 1) % 12]);
        } else if (m > 30){
            int diff = 60 - m;
            
            if (diff == 1) {
                output.append(nums[diff]);
                output.append(special[5]); // minute
            } else {
                if (diff <= 20) {
                    output.append(nums[diff]);
                } else {
                    output.append(nums[20]); // twenty
                    output.append(nums[diff % 20]);
                }
                output.append(special[6]); // minutes
            }
            output.append(special[4]); // to
            output.append(nums[(h + 1) % 12]);
        } else {
            if (m == 1) {
                output.append(nums[m]);
                output.append(special[5]); // minute
            } else {
                if (m <= 20) {
                    output.append(nums[m]);
                } else {
                    output.append(nums[20]); // twenty
                    output.append(nums[m % 20]);
                }
                output.append(special[6]); // minutes
            }
            output.append(special[2]); // to
            output.append(nums[h]);
        }
        
        System.out.println(output.toString());
        in.close();
    }

}
