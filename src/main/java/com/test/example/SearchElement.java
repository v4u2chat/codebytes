package com.test.example;

import java.util.*;

public class SearchElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int noOfTestCases = Integer.parseInt(scanner.nextLine());

        for(int j=0; j<noOfTestCases; j++){
            String[] line = scanner.nextLine().split(" ");
            if(line.length > 0){
                int[] numbers = new int[Integer.parseInt(line[0])];
                for(int i=0;i<numbers.length;i++){
                    numbers[i] = Integer.parseInt(line[i+1]);
                }

                boolean isFound = false;
                int numToSearch = Integer.parseInt(scanner.nextLine());
                for(int i=0;i<numbers.length;i++){
                    if(numToSearch==numbers[i]){
                        isFound = true;
                        break;
                    }
                }
                System.out.println(isFound ? 1 : 0);
            }
        }

        scanner.close();
    }

//     1 
// 5 4 1 5 9 1
// 5
}
