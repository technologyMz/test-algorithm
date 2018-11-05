package programskills;

import java.sql.Timestamp;
import java.util.Date;

/**
 * Author: mz
 * Date: 2018/11/5 10:47
 * Description: 关于递归的一些优化
 */
public class RecursiveOptimize {

    /**
     * 这种递归十分消耗性能
     * eg: 一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法？
     */
    public static int f1(int n) {
        if (n <= 2) {
            return n;
        } else {
            return f1(n - 1) + f1(n - 2);
        }
    }


    /**
     * 1. 备忘录法（对于可以递归的问题考虑状态保存）
     *     数组的大小根据具体情况来，由于int数组元素的的默认值是0
     *     因此我们不用初始化
     */
    static int[] arr = new int[1000];
    public static int f2(int n) {
        if (n <= 2) {
            return n;
        } else {
            if (arr[n] != 0) {
                return arr[n];//已经计算过，直接返回
            } else {
                arr[n] = f2(n-1) + f2(n-2);
                return arr[n];
            }
        }
    }


    /**
     * 2. 递推法
     */
    public static int f3(int n) {
        if(n <= 2)
            return n;

        int n1 = 1;
        int n2 = 2;
        int sum = 0;

        for (int i = 3; i <= n; i++) {
            sum = n1 + n2;
            n1 = n2;
            n2 = sum;
        }
        return sum;
    }


    public static void main(String[] args) {
        Date start = new Date();
        long start_time = start.getTime();

        int n = 50;
//        int i = f1(n);  // expend time: too long
//        int i = f2(n);  // expend time: 0
        int i = f3(n);    // expend time: 0

        Date end = new Date();
        long end_time = end.getTime();

        System.out.println(i);

        System.out.println(start_time);
        System.out.println(end_time);
        System.out.println("expend time: "+ (end_time - start_time));
    }

}
