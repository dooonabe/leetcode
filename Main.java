package com.dooonabe;

public class Main {
    public static int climbStairs(int len){
        if(len >0){
            return next(len);
        } else {
            return 0;
        }
    }

    private static int next(int len){
        int steps = 0;
        if(len == 1){
            steps += 1;
            return steps;
        } else if(len ==2){
            steps += 2;
            return steps;
        } else {
            steps += next(len-2);
            return steps + next(len-1);
        }
    }

    public static void main(String[] args) {
	// write your code here
        int ret = climbStairs(3);
        System.out.print(ret);
    }
}
