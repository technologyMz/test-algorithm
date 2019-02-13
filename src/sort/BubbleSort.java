package sort;

import java.util.Arrays;

/**
 * Author: mz
 * Date: 2019/2/13 10:08
 * Description: 冒泡排序
 */
public class BubbleSort {
    public static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void bubble(int[] a, int n){
        for(int j = 0; j<n-1; j++){
            for(int i = 0; i<n-1-j; i++){
                if(a[i]>a[i+1]){
                    swap(a, i, i+1);
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 6, 4, 5, 3, 8, 9, 7};
        bubble(arr,arr.length);
        System.out.println(Arrays.toString(arr));
    }
}
