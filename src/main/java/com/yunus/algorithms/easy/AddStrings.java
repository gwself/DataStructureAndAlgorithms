package com.yunus.algorithms.easy;

/**
 * @Author: gaoyunfeng
 * @date: 2019/3/13
 */
public class AddStrings {

    public static String addString(String num1, String num2) {
        int i = num1.length() - 1;
        int j = num2.length() - 1;
        int jin = 0;
        String result = "";
        while (i >= 0 && j >= 0) {
            int he = (num1.charAt(i) - '0') + (num2.charAt(j) - '0') + jin;
            if (he >= 10) {
                result = (he - 10) + result;
                jin = 1;
            } else {
                result = he + result;
                jin = 0;
            }
            i--;
            j--;
        }
        while (i >= 0) {
            int he = (num1.charAt(i) - '0') + jin;
            if (he >= 10) {
                result = (he - 10) + result;
                jin = 1;
            } else {
                result = he + result;
                jin = 0;
            }
            i--;
        }

        while (j >= 0) {
            int he = (num2.charAt(j) - '0') + jin;
            if (he >= 10) {
                result = (he - 10) + result;
                jin = 1;
            } else {
                result = he + result;
                jin = 0;
            }
            j--;
        }
        if (jin > 0) {
            return jin + result;
        }
        return result;
    }
}