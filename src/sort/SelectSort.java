package sort;

import java.util.Arrays;

/**
 * Author: mz
 * Date: 2019/2/13 11:20
 * Description: 选择排序
 */
public class SelectSort {
    public static void swap(int[] arr, int i, int j){
        arr[i] = arr[i] + arr[j];
        arr[j] = arr[i] - arr[j];
        arr[i] = arr[i] - arr[j];
    }

    public static void sort(int[] arr){
        for(int i=0;i<arr.length-1;i++){
            //每一趟循环比较时，min用于存放较小元素的数组下标，这样当前批次比较完毕最终存放的就是此趟内最小的元素的下标，避免每次遇到较小元素都要进行交换。
            int min = i;

            for(int j=i+1;j<arr.length;j++){
                if (arr[j] < arr[min]) {
                    min = j;
                }
            }

            //进行交换，如果min发生变化，则进行交换
            if (min != i) {
                swap(arr,min,i);
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 6, 4, 5, 3, 8, 9, 7};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
