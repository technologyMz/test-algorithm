package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Author: mz
 * Date: 2019/2/27 16:50
 * Description: 约瑟夫环问题
 */
public class Josephus {
    public static void josephusGen(int[] arr, int m){
        System.out.println("原始数组： " +Arrays.toString(arr));

        List<Integer> list = new ArrayList();
        List<Integer> re = new ArrayList();
        for(int i=0;i<arr.length;i++){
            list.add(arr[i]);
        }

        //从第k个元素开始
        int k = 0;
        while(list.size() > 0){
            k += m;

            //第m人的索引位置
            k = k % (list.size()) - 1;

            // 判断是否到队尾
            if(k < 0){
                re.add(list.get(list.size()-1));
                list.remove(list.size()-1);
                k = 0;
            }else {
                re.add(list.get(k));
                list.remove(k);
            }
        }
        for (Integer i:re) {
            System.out.println(i);
        }
    }


    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8};
        josephusGen(arr, 4);
    }
}
