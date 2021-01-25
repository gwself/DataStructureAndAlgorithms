package com.yunus.foo;

/**
 * @author gaoyunfeng
 * @Description:
 * @date 2020/11/25 15:34
 */
public class Test {
    public static void main(String[] args) {
        Test test = new Test();
        test.test("hello world");
    }

    public void test(String str) {
        if (str.length() == 0) {
            return;
        } else {
            str = str.substring(0, str.length() - 1);
            test(str);
            System.out.println(str);
        }
    }
}
