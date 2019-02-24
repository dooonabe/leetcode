package com.dooonabe.collection.array;

/**
 * 557. Reverse Words in a String III
 * Given a string, you need to reverse the order of characters in each word within a sentence while still preserving whitespace and initial word order.
 * Created on 2019/2/24.
 */
public class ReverseWordsInAStringIII {
    public String reverseWords(String s) {
        if(s == null) return s;
        StringBuffer output = new StringBuffer("");
        String[] words = s.split(" ");
        for (String word : words){
            output.append(new StringBuffer(word).reverse()).append(" ");
        }
        output.deleteCharAt(output.length()-1);
        return output.toString();
    }
}
