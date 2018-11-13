package programskills;

import java.util.HashMap;

/**
 * Author: mz
 * Date: 2018/11/13 15:52
 * Description: LRU算法
 */


public class LRUCache {

    private class Node{
        private Node pre;
        private Node next;
        private String key;
        private String value;

        private Node(String key, String value) {
            this.key = key;
            this.value = value;
        }
    }

    private Node head;
    private Node end;

    // 缓存存储上限
    private int limit;

    private HashMap<String,Node> hashMap;

    // 构造LRU缓存数据结构
    private LRUCache(int limit){
        this.limit = limit;
        hashMap = new HashMap<String,Node>();
    }

    public String get(String key){
        Node node = hashMap.get(key);
        if(node == null)
            return null;
        //刷新被访问节点的位置
        refreshNode(node);

        return node.value;
    }

    public void remove(String key){
        Node node = hashMap.get(key);
        removeNode(node);
        hashMap.remove(key);
    }

    public void put(String key, String value){
        Node node = hashMap.get(key);
        if(node == null){
            //如果key不存在，则插入key-value
            if(hashMap.size() >= limit){
                String oldkey = removeNode(head);
                hashMap.remove(oldkey);
            }
            node = new Node(key,value);
            addNode(node);
            hashMap.put(key,node);
        }else {
            //如果key存在，则刷新key-value
            node.value = value;
            refreshNode(node);
        }
    }

    /**
     * 刷新被访问节点的位置
     * @param node
     */
    public void refreshNode(Node node){

        //若访问节点为尾节点则无需移动
        if(node == end)
            return;
        //移除节点
        removeNode(node);
        //重新插入节点
        addNode(node);
    }

    /**
     * 删除节点
     * @param node
     * @return
     */
    public String removeNode(Node node){
        if(node == end){
            //移除尾节点
            end = end.pre;
        }else if(node == head){
            //移除头节点
            head = head.next;
        }else {
            //移除中间节点
             node.pre.next = node.next;
             node.next.pre = node.pre;
        }
        return node.key;
    }

    /**
     * 尾部插入
     * @param node
     */
    public void addNode(Node node){
        if(end != null){
            end.next = node;
            node.pre = end;
            node.next = null;
        }
        end = node;
        if(head == null){
            head = node;
        }
    }

    public static void main(String args[]){
        LRUCache lruCache = new LRUCache(5);
        lruCache.put("001","用户1信息");
        lruCache.put("002","用户1信息");
        lruCache.put("003","用户1信息");
        lruCache.put("004","用户1信息");
        lruCache.put("005","用户1信息");
        lruCache.get("002");
        lruCache.put("004","用户2信息更新");
        lruCache.put("006","用户3信息");

        System.out.println(lruCache.get("002"));
        System.out.println(lruCache.get("006"));
    }

}
