package org.leecode;

/**
 * 344. 反转字符串
 */
public class Solution_344 {


    public void reverseString(char[] s) {
        for (int left = 0, right = s.length - 1; left < right; ++left, --right) {
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;
        }
    }

    public static void main(String[] args) {
        char[] s = {'h', 'e', 'l'};
        new Solution_344().reverseString(s);

        System.out.println(s);
    }
}
