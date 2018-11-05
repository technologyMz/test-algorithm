package programskills;

/**
 * Author: mz
 * Date: 2018/11/5 10:38
 * Description:
 *  n / 2 等价于 n >> 1
 *  n / 4 等价于 n >> 2
 *  n / 8 等价于 n >> 3
 */
public class BitOperation {

    public static void main(String[] args) {
        int n = 32;
        System.out.println(n >> 1);
        System.out.println(n >> 2);
        System.out.println(n >> 3);

    }
}
