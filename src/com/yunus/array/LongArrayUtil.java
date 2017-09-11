package com.yunus.array;

import java.util.Arrays;

/**
 * Created by yunus on 2017/9/11.
 * 对long数组的操作封装
 */
public class LongArrayUtil {
    // 操作数组
    private long[] arr;
    // 记录元素个数
    private int elems;

    public LongArrayUtil() {
        arr = new long[10];
    }

    public LongArrayUtil(int max) {
        arr = new long[max];
    }

    // 插入
    public void insert(long value) {
        // 扩容
        expansion();
        arr[elems++] = value;
    }

    // 删除
    public void remove(long value) {
        int index = find(value);
        if(index == -1){
            System.out.println("该元素不存在");
        }else{
            for(int i = index;i<elems;i++){
                arr[index] = arr[index+1];
            }
            arr[elems-1]=0;
        }

    }

    // 有序数组插入
    public void sortInsert(long value){
        // 扩容
        expansion();
        // 找到插入点
        int i ;
        for(i = 0 ;i <elems;i++){
            if(arr[i]>value){
                break;
            }
        }
        // 从第i下标开始整体向后移动
        for(int j=elems;j>i;j--){
            arr[elems] = arr[elems-1];
        }
        arr[i] = value;
        elems++;
    }
    // 查找 (第一次出现时的下标)
    public int find(long seachKey) {
        int i;
        for (i = 0; i < elems; i++) {
            if (arr[i] == seachKey) {
                break;
            }
        }
        if (i == elems) {
            return -1;
        } else {
            return i;
        }
    }
    // 显示
    public void display(){
        for (int i = 0;i<elems;i++){
            System.out.println(arr[i]);
        }
    }

    // 简单扩容
    private void expansion() {
        if (elems == arr.length) {
            arr = Arrays.copyOf(arr, (3 * arr.length) / 2);
        }
    }

}
