package leetcode;

/**
 * Author: mz
 * Date: 2019/2/12 15:09
 * Description: 使用跳跃表来维护一组 有序 的int数据集合，实现快速插入、删除、查找
 */

/* 结点 */
class Node{
    int value = -1;
    int level;    //需要跨越的层数
    Node[] next;  //指向下一个结点

    public Node(int value, int level){
        this.value = value;
        this.level = level;
        this.next = new Node[level];
    }
}

/* 跳跃表 */
public class SkipList {
    int maxlevel = 16;                          //允许的最大层数
    Node head = new Node(-1, 16);   //头结点充当辅助
    int size = 0;                               //当前跳跃表结点的个数
    int levelCount =1;                          //当前跳跃表的层数，初始化为1层

    public Node find(int value){
        Node temp = head;
        for(int i = levelCount-1; i >= 0; i--){
            while(temp.next[i] != null && temp.next[i].value < value){
                temp = temp.next[i];
            }
        }
        //判断是否有该元素存在
        if(temp.next[0] != null && temp.next[0].value == value){
            System.out.println(value + " 查找成功");
            return temp.next[0];
        }else{
            return null;
        }
    }

    //为了方便，跳跃表在插入的时候，插入的结点在当前跳跃表是不存在的
    //不允许插入重复值的结点
    public void insert(int value){
        int level = getLevel();
        Node newNode = new Node(value, level);
        //update用于记录要插入的结点前驱
        Node[] update = new Node[level];

        Node temp = head;
        for(int i = level-1;i >= 0;i--){
            while(temp.next[i] != null && temp.next[i].value < value){
                temp = temp.next[i];
            }
            update[i] = temp;
        }
        //把插入结点的每一层连接起来
        for(int i = 0; i < level;i++){
            newNode.next[i] = update[i].next[i];
            update[i].next[i] = newNode;
        }
        //判断是否需要更细跳跃表的层数
        if(level > levelCount){
            levelCount = level;
        }
        size++;
        System.out.println(value + " 插入成功");
    }

    public void delete(int value){
        Node[] update = new Node[levelCount];
        Node temp = head;

        for(int i = levelCount-1;i >= 0; i--){
            while(temp.next[i] != null && temp.next[i].value < value){
                temp = temp.next[i];
            }
            update[i] = temp;
        }

        if(temp.next[0] != null && temp.next[0].value == value){
            size--;
            System.out.println(value + " 删除成功");
            for(int i = levelCount-1;i >= 0;i--){
                if(update[i].next[i] != null && update[i].next[i].value == value){
                    update[i].next[i] = update[i].next[i].next[i];
                }
            }
        }
    }

    //打印所有结点
    public void printAllNodes(){
        Node temp = head;
        while(temp.next[0] != null){
            System.out.println(temp.next[0].value + " ");
            temp = temp.next[0];
        }
    }

    //模拟抛硬币
    public int getLevel(){
        int level = 1;
        while (true){
            int t = (int)(Math.random() * 100);
            if(t%2 == 0){
                level++;
            }else {
                break;
            }
        }
        System.out.println("当前level："+level);
        return level;
    }

    //测试
    public static void main(String[] args) {
        SkipList list = new SkipList();
        for(int i = 0;i < 6;i++){
            list.insert(i);
        }
        list.printAllNodes();
        list.delete(4);
        list.printAllNodes();
        System.out.println(list.find(3));
        System.out.println(list.size +" "+list.levelCount);
    }

}


