package com.dooonabe.search;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Given a string, find the length of the longest substring without repeating characters.
 *
 * @date 2020/3/15 11:48
 */
public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        if(s == null || s.length() == 0){
            return 0;
        }
        List<Character> input = s
                .chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.toList());
        List<Character> result;
        int max = 0;
        for (int i = 0; i < input.size(); i++) {
            result = new ArrayList<>();
            result.add(input.get(i));
            for (int j = i + 1; j < input.size(); j++) {
                if(!result.contains(input.get(j))){
                    result.add(input.get(j));
                } else {
                    break;
                }
            }
            max = Math.max(max, result.size());
        }
        return max;
    }
}
