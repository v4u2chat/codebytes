package com.test.example;

public class SquareRoot {
    public static void main(String[] args) {
        int n = 1065024;
        System.out.println("SQRT of "+ n +" is "+ sqrt(n));
    }

    public static int sqrt(int num) {

        Long start = 2L;
        Long end = num/2L;

        while(start+1 != end){

            Long medium = (start + end)/2;
            
            long m2 = medium*medium;
            System.out.println(num+"\t"+start +"\t"+end+"\t"+medium+"\t"+m2);
            if( m2> num){
                end = medium;
            } else if(m2 < num){
                start = medium;
            } else {
                return medium.intValue();
            }
        }
        
        return (start * start == num) ? start.intValue() : ((end * end == num) ? end.intValue() : -1);
        
    }
}
