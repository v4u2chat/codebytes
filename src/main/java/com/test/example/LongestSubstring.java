package com.test.example;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

public class LongestSubstring {

    public static void main(String[] args) {
        System.out.println("abcabcbb-----"+lengthOfLongestSubstring("abcabcbb"));
        System.out.println("bbbbb-----"+lengthOfLongestSubstring("bbbbb"));
        System.out.println("pwwkew-----"+lengthOfLongestSubstring("pwwkew"));
        System.out.println("au-----"+lengthOfLongestSubstring("au"));
        System.out.println("dvdf-----"+lengthOfLongestSubstring("dvdf"));
        System.out.println("  -----"+lengthOfLongestSubstring("  "));
        System.out.println("-----"+lengthOfLongestSubstring(""));
    }
    
    public static int lengthOfLongestSubstring(String s) {

        
        
        int longestSubStringCount = 0;
        int runnigSubStringCount = 0;
        Set<Character> chars = new LinkedHashSet<>();
        
        char[] charArray = s.toCharArray();
        if(charArray.length <2){
            return charArray.length;
        }
        for(int i=0; i<charArray.length;i++){
            
            if(chars.contains(charArray[i])){
                if(runnigSubStringCount > longestSubStringCount){
                    longestSubStringCount = runnigSubStringCount;
                }
                
                Iterator<Character>  charItr = chars.iterator();
                while(charItr.hasNext()){
                    char c = charItr.next();
                    charItr.remove();
                    if(c == charArray[i]){
                        break;
                    }
                }
                chars.add(charArray[i]);
                runnigSubStringCount = chars.size();
                
            }else {
                chars.add(charArray[i]);
                runnigSubStringCount++;
            }
            // System.out.println(charArray[i]+"-----"+chars+"-----"+runnigSubStringCount);
        }
        return longestSubStringCount > runnigSubStringCount ? longestSubStringCount : runnigSubStringCount;
    }
}
