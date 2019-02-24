package com.dooonabe.collection.array;

/**
 * Write a function that reverses a string. The input string is given as an array of characters char[].
 * Created on 2019/2/22.
 */
public class ReverseString {
    public void reverseString(char[] s) {
        int length = s.length;
        char temp;
        for(int i = 0; i<length/2;i++){
            temp = s[i];
            s[i] = s[length-i-1];
            s[length-i-1] = temp;
        }
    }
}
