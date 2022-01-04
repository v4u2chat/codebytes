package com.test.example;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class FindCommonElements {
    private static void findCommonElemet(String[] arr1,  String[] arr2) {
        Set<String> set = new HashSet<>();
        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr2.length; j++) {
                if (arr1[i] == arr2[j]) {
                    set.add(arr1[i]);
                    break;
                }
            }
        }
        for (String i : set) {
            System.out.print(i + " ");
        }
    }

    // main method
    public static void main(String[] args) {

        String[] arr1 = { "Article", "in", "Geeks", "for", "Geeks" };
        String[] arr2 = { "Geeks", "for", "Geeks" };

        System.out.println("Array 1: " + Arrays.toString(arr1));
        System.out.println("Array 2: " + Arrays.toString(arr2));

        System.out.print("Common Elements: ");

        findCommonElemet(arr1, arr2);
    }

    // public String[] solve(String[] arr1,  String[] arr2) {
        
    //     ArrayList<Integer> commonElements = new ArrayList<>();
    //     for(Integer i : a){
    //         if(b.contains(i)){
    //             commonElements.add(i);
    //             b.remove(b.indexOf(i));
    //         }
    //     }
    //     return commonElements;
    // }
}
