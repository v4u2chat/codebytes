package com.test.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SalesforceEmailRange {

    public static void main(String[] args) {
        
        mergeIntervals("1:4 , 5:10,11:20");
        mergeIntervals("5:10,1:2");
           
    }

    private static void mergeIntervals(String inputString) {
        
        String[] input = inputString.replaceAll(" ", "").split(",");
        
        int[][] intervals = new int[input.length][2];
        for(int i=0; i<input.length;i++){
            String[] interval = input[i].split(":");
            intervals[i][0] =Integer.parseInt(interval[0]);
            intervals[i][1] =Integer.parseInt(interval[1]);
        }

        Arrays.sort(intervals, (i1, i2) -> Integer.compare(i1[0], i2[0]));

        List<int[]> mergedIntervals = new ArrayList<>();
        mergedIntervals.add(intervals[0]);
        
        for(int i=1;i<intervals.length;i++){
            int[] prevInterval = mergedIntervals.get(mergedIntervals.size()-1);
            
            if(intervals[i][0] <= prevInterval[1] || intervals[i][0] - prevInterval[1] == 1){
                prevInterval[0] = intervals[i][0] < prevInterval[0] ? intervals[i][0] : prevInterval[0];
                prevInterval[1] = intervals[i][1] > prevInterval[1] ? intervals[i][1] : prevInterval[1];

                mergedIntervals.set(mergedIntervals.size()-1,prevInterval);

            } else {
                mergedIntervals.add(intervals[i]);
            }
        }
        
        System.out.println("\n"+inputString +"............"+Arrays.deepToString(mergedIntervals.toArray()));
    }
}
