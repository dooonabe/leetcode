package com.dooonabe.collection.stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 20. Valid Parentheses
 * Created on 2019/2/18.
 */
public class ValidParentheses {
    private static Map<Byte, Byte> map;

    static {
        map = new HashMap<>(3);
        map.put(new Byte("40"), new Byte("41")); //()
        map.put(new Byte("123"), new Byte("125")); //{}
        map.put(new Byte("91"), new Byte("93"));//[]
    }

    public boolean isValid(String s) {
        Stack<Byte> stack = new Stack();
        byte[] input = s.getBytes();

        for (int i = 0; i < input.length; i++) {
            if (map.containsKey(input[i])) {
                stack.push(input[i]);
            } else {
                if (!stack.isEmpty()) {
                    if (map.get(stack.peek()) == input[i]) {
                        stack.pop();
                    } else return false;
                } else return false;
            }
        }
        if (!stack.isEmpty()) {
            return false;
        } else return true;

    }

    public boolean anotherIsValid(String s){
        Stack<Character> stack = new Stack<Character>();
        for (char c : s.toCharArray()) {
            if (c == '(')
                stack.push(')');
            else if (c == '{')
                stack.push('}');
            else if (c == '[')
                stack.push(']');
            else if (stack.isEmpty() || stack.pop() != c)
                return false;
        }
        return stack.isEmpty();
    }
}
