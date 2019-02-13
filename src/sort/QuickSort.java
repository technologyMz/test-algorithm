package sort;

import java.util.Arrays;

/**
 * Author: mz
 * Date: 2019/2/13 11:04
 * Description: 快速排序
 */
public class QuickSort {
    public static void qsort(int[] arr,int left,int right){
        int x=arr[left], i=left, j=right;
        if(left >= right) return;
        while (i<j){
            while (i<j && arr[j]>=x) j--;  //注意此处，必须控制 i<j
            arr[i] = arr[j];
            while (i<j && arr[i]<=x) i++;  //注意此处，必须控制 i<j
            arr[j] = arr[i];
        }
        arr[i] = x;
        qsort(arr, left, i-1);
        qsort(arr, i+1, right);
    }

    public static void main(String[] args) {
        int[] arr = {1, 6, 4, 5, 3, 8, 9, 7};
        qsort(arr, 0, arr.length-1);
        System.out.println(Arrays.toString(arr));
    }
}
