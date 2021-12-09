package com.test.example;

import java.util.Stack;

public class StringEncoding {
    public static void main(String[] args) {
        
        System.out.println("Decoded String of 3[a]2[bc] is >> "+decodeString("3[a]2[bc]"));
        System.out.println("Decoded String of 3[a2[c]] is >> "+decodeString("3[a2[c]]"));
        System.out.println("Decoded String of 2[abc]3[cd]ef is >> "+decodeString("2[abc]3[cd]ef"));
        System.out.println("Decoded String of abc3[cd]xyz is >> "+decodeString("abc3[cd]xyz"));
    }

    private static String decodeString(String encodedString) {
        Stack<String> charStack = new Stack<>();
        for(int i=0;i<encodedString.length();i++){
            if(encodedString.charAt(i) != ']'){
                charStack.push(""+encodedString.charAt(i));
            } else {
                buildStringFromStack(charStack);
            }
        }
        
        String outputString = new String();
        while(!charStack.isEmpty()){
            outputString = charStack.pop()+""+outputString;
        }
        return outputString;
    }

    private static void buildStringFromStack(Stack<String> charStack) {
        String c = charStack.pop();
        while(!charStack.isEmpty() && !"[".equals(charStack.peek().toString())){
            c = charStack.pop()+c+"";
        }
        charStack.pop();
        int repeatSequence = Integer.parseInt(charStack.pop().toString());
        StringBuilder outputString = new StringBuilder();
        for(int j=0;j<repeatSequence;j++){
            outputString.append(c);
        }
        charStack.push(outputString.toString());
        
    }
}
