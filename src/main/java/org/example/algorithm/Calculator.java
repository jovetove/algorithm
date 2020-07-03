package org.example.algorithm;

import java.util.Queue;
import java.util.Stack;

/**
 * 1. 输入一个字符串，可以包含+ - * /、数字、括号以及空格，你的算法返回运算结构。
 * 2. 要符合运算法则，括号的优先级最高，先乘除后加减。
 * 3. 除号是整数除法，无论正负都向 0 取整（5/2=2，-5/2=-2）。
 * 4. 可以假定输入的算式一定合法，且计算过程不会出现整型溢出，不会出现除数为 0 的意外情况。
 * @author minglan
 */
public class Calculator {
    /**
     * 简单计算器 输入 2—3+4 类型
     * 关键点就是判断是否为数字
     * @param str
     * @return
     */
    public static int calculator1(String str){
        int len = str.length();
        if(len == 0){
            return 0;
        }
        int res=0;
        int num = 0;  // 用来暂存数字
        int sign = 1;
        for(int i = 0; i < len; i++){
            char c = str.charAt(i);
            if(isdigit(c)){
                num = num *10 + (c-'0');
            }
            if((!isdigit(c) && c != ' ') || i == len -1){
                res += num*sign;
                if(c == '+'){
                    sign = 1;
                }
                if(c == '-'){
                    sign = -1;
                }
                num = 0;
            }
        }
        return res;
    }

    /**
     * 判断是否属于数字
     * @param c
     * @return
     */
    public static boolean isdigit(char c){
        return c - '0' <= 9 && c - '0' >= 0;
    }
}
