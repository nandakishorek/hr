package com.hr;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Given a time in AM/PM format, convert it to military (24-hour) time.

Note: Midnight is 12:00:00AM on a 12-hour clock and 00:00:00 on a 24-hour clock. Noon is 12:00:00PM on a 12-hour clock and 12:00:00 on a 24-hour clock.

Input Format

A time in 12-hour clock format (i.e.: hh:mm:ssAM or hh:mm:ssPM), where 01≤hh≤12.

Output Format

Convert and print the given time in 24-hour format, where 00≤hh≤23.

 * @author kishore
 *
 */
public class TimeConversion {

    public static void main(String[] args) {
        
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.println(convertTo24Hr(br.readLine()));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    
    
    public static String convertTo24Hr(String time){
        
        String[] vals = time.split(":");
        int hr = Integer.parseInt(vals[0]);
        
        int pIndex = vals[2].indexOf('P');
        int aIndex = vals[2].indexOf('A');
        boolean isAM = (aIndex > -1)? true : false;
        
        if (isAM) {
            if (hr == 12) {
                return "00" + time.substring(2, time.length() - 2);
            } else {
                // 1 to 11 am
                return time.substring(0, time.length() - 2);
            }
        } else {
            if (hr < 12) {
                // 1 to 11 pm
                return (hr + 12) + time.substring(2, time.length() - 2);
            } else {
                return time.substring(0, time.length() - 2);
            }
        }
        
    }

}
