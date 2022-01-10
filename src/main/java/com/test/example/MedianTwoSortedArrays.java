package com.test.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MedianTwoSortedArrays {

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
       
        
        List<Integer> mergedList = new ArrayList<>(); 
       
        for(int a : nums1){
           mergedList.add(a);
        }
        for(int a : nums2){
           mergedList.add(a);
        }
        
        Collections.sort(mergedList);

        double median = mergedList.size() / 2;
        if(mergedList.size() %2 == 0){
            return mergedList.get((int)median) + mergedList.get((int)median+1);
        } else {
            return mergedList.get((int)median);
        }
    }
    
    public static void main(String[] args) {
        System.out.println(findMedianSortedArrays(new int[]{1,2}, new int[]{3,4}));
    }
}
