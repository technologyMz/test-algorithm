package sort;

import java.util.Arrays;

/**
 * Author: mz
 * Date: 2019/2/13 11:29
 * Description: 插入排序
 */
public class InsertSort {
    public static void swap(int[] arr, int i, int j){
        arr[i] = arr[i] + arr[j];
        arr[j] = arr[i] - arr[j];
        arr[i] = arr[i] - arr[j];
    }

    public static void sort(int[] arr){
        for(int i=1;i<arr.length;i++){
            int j=i;
            while (j > 0 && arr[j] < arr[j - 1]){
                swap(arr,j,j-1);
                j--;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 6, 4, 5, 3, 8, 9, 7};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
