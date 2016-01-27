package com.hr;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class SubSetSum {

    public static void main(String[] args) {
        int[] data =  {1, 3, 2, 5, 4, 9};
        int m = 9;
        Set<List<Integer>> subsets = subSetSum(data, m);
        System.out.println(subsets.size());
    }
    
    /**
     * 
     * @param input
     * @param m  The sum
     * @return
     */
    public static Set<List<Integer>> subSetSum(int[] input, int m){
        Set<List<Integer>> output = new HashSet<List<Integer>>();
        
        // bit set to determine whether an element is included in the subset or not
        boolean[] inc = new boolean[input.length];
        
        // sort the input
        Arrays.sort(input);
        
        subSetSumHelper(input, 0, sum(input), 0, m, output, inc);
        return output;
    }
    
    public static void subSetSumHelper(int[] input, long curSum, long remSum, int curPos, int m, Set<List<Integer>> output, boolean[] inc) {
        // include current element
        inc[curPos] = true;
        if (curSum + input[curPos] == m) {
            addSetToOutput(output, input, inc);
        } else if (curPos + 1 < input.length && curSum + input[curPos] + input[curPos + 1] <= m) {
            subSetSumHelper(input, curSum + input[curPos], remSum - input[curPos], curPos + 1, m, output, inc);
        }
        
        // don't include current element
        inc[curPos] = false;
        if (curPos + 1 < input.length && curSum + remSum - input[curPos] >= m && curSum + input[curPos + 1] <= m) {
            subSetSumHelper(input, curSum, remSum, curPos + 1, m, output, inc);
        }
    }
    
    /**
     * Method to add the subset the output
     * 
     * @param output
     * @param input
     * @param inc
     */
    public static void addSetToOutput(Set<List<Integer>> output, int[] input, boolean[] inc) {
        List<Integer> subSet = new LinkedList<Integer>();
        for (int i = 0; i < inc.length; ++i) {
            if (inc[i]) {
                subSet.add(input[i]);
            }
        }
        output.add(subSet);
    }
    
    private static long sum(int[] input) {
        long sum = 0L;
        for(int i : input) {
            sum += i;
        }
        return sum;
    }

}
