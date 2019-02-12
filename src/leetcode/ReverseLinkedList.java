package leetcode;

/**
 * Author: mz
 * Date: 2019/2/12 09:47
 * Description: 实现单链表的反转
 */
public class ReverseLinkedList {
    private static class Node{
        int data;
        Node next;

        Node(int data){
            this.data = data;
        }
    }

    private static Node head;

    public static void main(String[] args) {
        //初始化单向链表
        head = new Node(3);
        head.next = new Node(5);
        Node temp = head.next;
        temp.next = new Node(1);
        temp = temp.next;
        temp.next = new Node(4);
        temp = temp.next;
        temp.next = new Node(9);

//        temp = head;
//        while (temp != null){
//            System.out.println(temp.data);
//            temp = temp.next;
//        }

        reverse();

        temp = head;
        while (temp != null){
            System.out.println(temp.data);
            temp = temp.next;
        }
    }

    public static void reverse(){
        if(head == null || head.next == null){
            return;
        }

        Node p1 = head;
        Node p2 = head.next;
        Node p3 = null;

        while(p2 != null){
            p3 = p2.next;
            p2.next = p1;
            p1 = p2;
            p2 = p3;
        }

        head.next = null;
        head = p1;
    }

}
