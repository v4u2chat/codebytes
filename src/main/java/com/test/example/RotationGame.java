package com.test.example;

import java.util.Scanner;

public class RotationGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] line = scanner.nextLine().split(" ");
         
        int[] numbers = new int[Integer.parseInt(line[0])];
        for(int i=0;i<numbers.length;i++){
            numbers[i] = Integer.parseInt(line[i+1]);
        }
        
        int noOfRotations = scanner.nextInt();
        numbers = reverse(0, numbers.length-1, numbers);
        System.out.println(" Totla Reversed ");
        printArray(numbers);

        int subArrayIndex = noOfRotations % numbers.length ;


        System.out.println("Reversing from 0 to "+subArrayIndex);
        numbers = reverse(0, subArrayIndex-1, numbers);
        System.out.println(" 1Half Reversed ");
        printArray(numbers);

        System.out.println("Reversing from "+subArrayIndex+" to "+(numbers.length-1));
        numbers = reverse(subArrayIndex, numbers.length-1, numbers);
        System.out.println(" 2 Half Reversed ");
        printArray(numbers);

        
        scanner.close();
    }

    public static int[] reverse(int start, int end, int[] a){

        while(start < end){
            int temp = a[start];
            a[start] = a[end];
            a[end] = temp;

            start++;
            end --;
        }

        printArray(a);
        return a;
    }


    public static void printArray(int[] numbers) {
        for(int i=0;i<numbers.length;i++){
            System.out.print(numbers[i] + " ");
        }
        System.out.println("\n------------------");
    }
}
