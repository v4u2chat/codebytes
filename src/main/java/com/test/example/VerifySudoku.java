package com.test.example;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class VerifySudoku {
    
    public static void main(String[] a) {

        int[][] boardArray1 =   {{5,3,3,0,7,0,0,0,0}
                                ,{6,0,0,1,9,5,0,0,0}
                                ,{0,9,8,0,0,0,0,6,0}
                                ,{8,0,0,0,6,0,0,0,3}
                                ,{4,0,0,8,0,3,0,0,1}
                                ,{7,0,0,0,2,0,0,0,6}
                                ,{0,6,0,0,0,0,2,8,0}
                                ,{0,0,0,4,1,9,0,0,5}
                                ,{0,0,0,0,8,0,0,7,9}};

        int[][] boardArray2 =   {{5,3,0,0,7,0,0,0,0}
                                ,{6,0,0,1,9,5,0,0,0}
                                ,{0,9,8,0,0,0,0,6,0}
                                ,{8,0,0,0,6,0,0,0,3}
                                ,{4,0,0,8,0,3,0,0,1}
                                ,{7,0,0,0,2,0,0,0,6}
                                ,{0,6,0,0,0,0,2,8,0}
                                ,{0,0,0,4,1,9,0,0,5}
                                ,{0,0,0,0,8,0,0,7,9}};  
        
        // System.out.println("boardArray2 is "+validateSudoku(boardArray1));
        System.out.println("boardArray2 is "+validateSudoku(boardArray2));                                                
    }

    public static boolean validateSudoku(int[][] inputArray) {

        // Validate Rows & Columns
        for (int i = 0; i < 9; i++) {
            if (isValidArray(inputArray[i])) {
                System.out.println(Arrays.toString(inputArray[i]) + ">> VALID ROW");

                int[] colArray = new int[9];
                for (int j = 0; j < 9; j++) {
                    colArray[j] = inputArray[j][i];
                }
                if (!isValidArray(colArray)) {
                    System.out.println(Arrays.toString(colArray) + ">> INVALID COL");
                    return false;
                } else {
                    System.out.println(Arrays.toString(colArray) + ">> VALID COL");
                }
            } else {
                System.out.println(Arrays.toString(inputArray[i]) + ">> VALID ROW");
            }
        }

        // Validate each 3X3 matrix
        int matrixRowNo=0;
        int matrixColNo=0;

        do{

            for(int i=matrixRowNo*3; i<(matrixRowNo*3 + 3); i++){
            
                do{
                    for(int j=matrixColNo*3;j<(matrixColNo*3 + 3); j++){
                        System.out.println("Checking matrixRowNo : "+i + "\t matrixColNo : "+j);
                    }
                    matrixColNo++;
                    System.out.println("------------------------------------------------------------------------");
                }while(matrixColNo<3);
                
                matrixColNo=0;
            }
            matrixRowNo++;
        }while(matrixRowNo<3);
        
        return true;
    }

    public static boolean isValidArray(int[] input) {
        Set<Integer> integers = new HashSet<>();
        for (int i = 0; i < 9; i++) {
            if (input[i] == 0 || integers.contains(input[i])) {
                integers.add(input[i]);
            } else {
                return false;
            }
        }
        return true;
    }
    
    
}
