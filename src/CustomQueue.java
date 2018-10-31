import java.util.Stack;

/**
 * Author: mz
 * Date: 2018/10/29 13:09
 * Description: 使用两个栈实现一个队列
 */
public class CustomQueue {

    private Stack<Integer> stackA = new Stack<>();
    private Stack<Integer> stackB = new Stack<>();

    /**
     * 入队操作,时间复杂度为 O(1)
     */
    public Integer pushElement(Integer elem){

        return stackA.push(elem);
    }

    /**
     * 出队操作,如果没有元素转移，时间复杂度为O(1);如果有元素转移，时间复杂度为O(n);
     */
    public Integer popElement(){
        if(stackB.empty()){
           if(stackA.empty()){
               return null;
           }
           transfer();
        }
        return stackB.pop();
    }

    /**
     * A栈元素转移到B栈
     */
    public void transfer(){
        while (!stackA.empty()){
            stackB.push(stackA.pop());
        }
    }

    public static void main(String[] args) {
        CustomQueue queue = new CustomQueue();
        queue.pushElement(5);
        queue.pushElement(6);
        queue.pushElement(7);
        queue.pushElement(8);
        queue.pushElement(9);
        System.out.println(queue.popElement());
        System.out.println(queue.popElement());
        System.out.println(queue.popElement());
        System.out.println(queue.popElement());
    }
}
