package tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Author: mz
 * Date: 2018/10/29 17:22
 * Description: 二叉排序树
 */

class BSTreeNode{
    int data;
    BSTreeNode left;
    BSTreeNode right;
}

public class BinarySortTee {
    BSTreeNode root; // 树的根节点
    int size;     // 记录树的节点个数


    /*
     * 插入一个值为data的节点
     */
    public void insert(int data) {
        BSTreeNode bsTreeNode = new BSTreeNode();
        bsTreeNode.data = data;
        insert(bsTreeNode);
    }

    /*
     * 插入一个节点
     */
    public void insert(BSTreeNode bsTreeNode) {
        if (root == null) {
            root = bsTreeNode;
            size++;
            return;
        }
        BSTreeNode current = root;
        while (true) {
            if (bsTreeNode.data <= current.data) {
                // 如果插入节点的值小于当前节点的值，说明应该插入到当前节点左子树，而此时如果左子树为空，就直接设置当前节点的左子树为插入节点。
                if (current.left == null) {
                    current.left = bsTreeNode;
                    size++;
                    return;
                }
                current = current.left;
            } else {
                // 如果插入节点的值大于当前节点的值，说明应该插入到当前节点右子树，而此时如果右子树为空，就直接设置当前节点的右子树为插入节点。
                if (current.right == null) {
                    current.right = bsTreeNode;
                    size++;
                    return;
                }
                current = current.right;
            }
        }
    }

    /**
     * BST创建
     */
    public BSTreeNode create(int[] list) {
        for (int i : list) {
            insert(list[i]);
        }
        return root;
    }

    /*
     * 中序遍历
     */
    public void LDR(BSTreeNode bsTreeNode) {
        if (bsTreeNode != null) {
            // 遍历左子树
            LDR(bsTreeNode.left);

            // 输出节点数据
            System.out.print(bsTreeNode.data + " ");

            // 遍历右子树
            LDR(bsTreeNode.right);
        }
    }

    /**
     * 查找节点
     */
    public boolean search(BSTreeNode bsTreeNode, int key) {
        // 遍历完没有找到，查找失败
        if (bsTreeNode == null) {
            return false;
        }
        // 要查找的元素为当前节点，查找成功
        if (key == bsTreeNode.data) {
            return true;
        }
        // 继续去当前节点的左子树中查找，否则去当前节点的右子树中查找
        if (key < bsTreeNode.data) {
            return search(bsTreeNode.left, key);
        } else {
            return search(bsTreeNode.right, key);
        }
    }

    /**
     * 二叉树广度优先遍历——层序遍历
     */
    public static void layerTraversal(BSTreeNode root) {
        Queue<BSTreeNode> queue = new LinkedList<>();

        if (root != null) {
            queue.add(root);
            while (!queue.isEmpty()) {
                BSTreeNode currentNode = queue.poll();

                System.out.println(currentNode.data);

                if (currentNode.left != null) {
                    queue.add(currentNode.left);
                }

                if (currentNode.right != null) {
                    queue.add(currentNode.right);
                }
            }
        }
    }


}