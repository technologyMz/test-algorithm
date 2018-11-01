package leetcode.arrayhandle;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * Author: mz
 * Date: 2018/11/1 17:04
 * Description: 在 O(1)的空间下，在原地移除数组中指定数值的元素
 */
public class RemoveElem {

    /**
     * 删除指定的元素，并返回移除元素后数组的有效长度
     */
    public static int removeElem(int[] arr, int val){

        int i = 0;
        if(arr == null || arr.length == 0)
            return 0;
        else {
            for(int j = arr.length-1;j > 0;j--){
                if(arr[j] != val && i <= j){
                    if(arr[i] == val){
                        arr[i] = arr[j];
                    }
                    i++;
                }
            }
        }
        System.out.println("valid length: "+(arr.length - i));
        return i;
    }

    public static void main(String[] args) {
        int[] arr = {0,0,2,3,4,5,9,8,7,0,0,6,0};
        removeElem(arr,0);
        for (int i: arr) {
            System.out.print(i + ", ");
        }
    }
}
