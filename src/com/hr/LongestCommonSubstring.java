package com.hr;

public class LongestCommonSubstring {

    public static void main(String[] args) {
        
        String lcs = longestCommonSubstring("aabcb", "cabab");
        System.out.println(lcs);
    }
    
    /**
     * Returns the longest common substring between str1 and str2 if there is any otherwise empty string.
     * @param str1
     * @param str2
     * @return
     */
    public static String longestCommonSubstring(String str1, String str2) {
        String lcSubStr = "";
        int maxLen = 0;
        
        int[][] lengths = new int[str1.length()][str2.length()];     
        
        for (int i = 0; i < str1.length(); ++i) {
            for (int j = 0; j < str2.length(); ++j) {
                if (str1.charAt(i) == str2.charAt(j)) {
                    if (i == 0 || j == 0) {
                        lengths[i][j] = 1;
                    } else { 
                        lengths[i][j] = lengths[i - 1][j - 1] + 1;
                    }
                    if (lengths[i][j] > maxLen) {
                        maxLen = lengths[i][j];
                        lcSubStr = str1.substring(i - maxLen + 1, i + 1);
                    }
                } else {
                    lengths[i][j] = 0;
                }
            }
        }
        return lcSubStr;
    }

}
