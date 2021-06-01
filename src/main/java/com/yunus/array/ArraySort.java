package com.yunus.array;

import java.util.Random;

/**
 * 排序算法
 *
 * @author gaoyunfeng
 */
public class ArraySort {
    /**
     * 插入排序
     *
     * @param arr
     */
    public static void insertSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int current = arr[i];
            int index = i;
            for (int j = i - 1; j >= 0; j--) {
                if (current < arr[j]) {
                    arr[j + 1] = arr[j];
                } else {
                    break;
                }
                index = j;
            }
            arr[index] = current;
        }
    }

    /**
     * 冒泡排序
     *
     * @param arr 原数组
     */
    public static void bubSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j + 1] < arr[j]) {
                    int temp = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }

    /**
     * 选择排序
     *
     * @param arr 数组
     */
    public static void selectSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    int tmp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = tmp;
                }
            }
        }
    }


    /**
     * 快速排序
     *
     * @param nums 数组
     * @param l    开始位置   0
     * @param r    结束位置   nums.length - 1
     * @return
     */
    public void randomizedQuicksort(int[] nums, int l, int r) {
        if (l < r) {
            int pos = randomizedPartition(nums, l, r);
            randomizedQuicksort(nums, l, pos - 1);
            randomizedQuicksort(nums, pos + 1, r);
        }
    }

    public int randomizedPartition(int[] nums, int l, int r) {
        // 随机选一个作为我们的主元
        int i = new Random().nextInt(r - l + 1) + l;
        swap(nums, r, i);
        return partition(nums, l, r);
    }

    public int partition(int[] nums, int l, int r) {
        int pivot = nums[r];
        int i = l - 1;
        for (int j = l; j <= r - 1; ++j) {
            if (nums[j] <= pivot) {
                i = i + 1;
                swap(nums, i, j);
            }
        }
        swap(nums, i + 1, r);
        return i + 1;
    }

    /**
     * 堆排序
     *
     * @param nums
     */
    public void heapSort(int[] nums) {
        int len = nums.length - 1;
        buildMaxHeap(nums, len);
        for (int i = len; i >= 1; --i) {
            swap(nums, i, 0);
            len -= 1;
            maxHeapify(nums, 0, len);
        }
    }

    public void buildMaxHeap(int[] nums, int len) {
        for (int i = len / 2; i >= 0; --i) {
            maxHeapify(nums, i, len);
        }
    }

    public void maxHeapify(int[] nums, int i, int len) {
        for (; (i << 1) + 1 <= len; ) {
            int lson = (i << 1) + 1;
            int rson = (i << 1) + 2;
            int large;
            if (lson <= len && nums[lson] > nums[i]) {
                large = lson;
            } else {
                large = i;
            }
            if (rson <= len && nums[rson] > nums[large]) {
                large = rson;
            }
            if (large != i) {
                swap(nums, i, large);
                i = large;
            } else {
                break;
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }


    /**
     * 归并排序
     *
     * @param nums nums
     * @param l    left  0
     * @param r    right nums.length - 1
     */
    public void mergeSort(int[] nums, int l, int r) {
        if (l >= r) {
            return;
        }
        int mid = (l + r) >> 1;
        mergeSort(nums, l, mid);
        mergeSort(nums, mid + 1, r);
        int[] tmp = new int[nums.length];
        int i = l, j = mid + 1;
        int cnt = 0;
        while (i <= mid && j <= r) {
            if (nums[i] < nums[j]) {
                tmp[cnt++] = nums[i++];
            } else {
                tmp[cnt++] = nums[j++];
            }
        }
        while (i <= mid) {
            tmp[cnt++] = nums[i++];
        }
        while (j <= r) {
            tmp[cnt++] = nums[j++];
        }
        for (int k = 0; k < r - l + 1; ++k) {
            nums[k + l] = tmp[k];
        }
    }

    /*
     *   ########################非优化版快排start################################
     */

    /**
     * @param nums
     * @param low
     * @param high
     */
    public void quickSort(int[] nums, int low, int high) {

        if (low < high) {
            int index = partition2(nums, low, high);
            quickSort(nums, low, index - 1);
            quickSort(nums, index + 1, high);
        }

    }

    public int partition2(int[] nums, int low, int high) {

        int pivot = nums[low];
        while (low < high) {
            //移动high指针
            while (low < high && nums[high] >= pivot) {
                high--;
            }
            //填坑
            if (low < high) {
                nums[low] = nums[high];
            }
            while (low < high && nums[low] <= pivot) {
                low++;
            }
            //填坑
            if (low < high) {
                nums[high] = nums[low];
            }
        }
        //基准数放到合适的位置
        nums[low] = pivot;
        return low;
    }

    public int partition3(int[] nums, int low, int high) {

        int pivot = nums[low];
        int start = low;

        while (low < high) {
            while (low < high && nums[high] >= pivot) {
                high--;
            }
            while (low < high && nums[low] <= pivot) {
                low++;
            }
            if (low >= high) {
                break;
            }
            swap(nums, low, high);
        }
        //基准值归位
        swap(nums, start, low);
        return low;
    }

    /*
     *   ########################非优化版快排end################################
     */

}