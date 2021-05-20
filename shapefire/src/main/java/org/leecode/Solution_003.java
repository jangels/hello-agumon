package org.leecode;

import java.util.HashMap;
import java.util.Map;

/**
 * 3. 无重复最大公共子串
 */
public class Solution_003 {

    public int lengthOfLongestSubstring(String s) {
       Map<Character, Integer> map = new HashMap<>();

       int len=0, left = 0, right=0;
       while(right<s.length()){
           char c = s.charAt(right);
           if(map.containsKey(c)){
               left = Math.max(left,map.get(c)+1);
           }

           map.put(c,right++);

           len = Math.max(len,right-left);
       }

       for(int i = left; i<right; i++){
           System.out.println(s.charAt(i));
       }

       return len ;
    }

    public static void main(String[] args) {
        System.out.println(new Solution_003().lengthOfLongestSubstring("google"));
    }

}
