package tree;

/**
 * Author: mz
 * Date: 2018/10/29 14:49
 * Description: 平衡二叉搜索树
 *
 * 具有的特点:
 *  1. 若它的左子树不为空，则左子树上所有的节点值都小于根节点的值
 *  2. 若它的右子树不为空，则右子树上所有的节点值都大于跟节点的值
 *  3. 它的左子树、右子树也可以分别充当二叉树
 *  4. 每个节点的左子树和右子树的高度差至多等于1
 *
 * 旋转方式:
 *  1. 左-左型：做右旋。
 *  2. 右-右型：做左旋转。
 *  3. 左-右型：先做左旋，后做右旋。
 *  4. 右-左型：先做右旋，再做左旋。
 *
 */

class AvlNode{
    int data;
    AvlNode lchild; //左孩子
    AvlNode rchild; //右孩子
    int height;     //节点高度
}

public class AVLTree {

    /* 计算节点高度 */
    static int height(AvlNode T){
        if(T == null){
            return -1;
        }else {
            return T.height;
        }
    }

    /* 左左型： 右旋转 */
    static AvlNode R_Rotate(AvlNode K2){
        AvlNode K1;

        // 进行旋转
        K1 = K2.lchild;
        K2.lchild = K1.rchild;
        K1.rchild = K2;

        // 重新计算节点的高度
        K2.height = Math.max(height(K2.lchild), height(K2.rchild)) + 1;
        K1.height = Math.max(height(K1.lchild), height(K1.rchild)) + 1;

        return K1;
    }

    /* 右右型： 左旋转 */
    static AvlNode L_Rotate(AvlNode K2){
        AvlNode K1;

        K1 = K2.rchild;
        K2.rchild = K1.lchild;
        K1.lchild = K2;

        K2.height = Math.max(height(K2.lchild), height(K2.rchild)) + 1;
        K1.height = Math.max(height(K1.lchild), height(K1.rchild)) + 1;

        return K1;
    }

    /* 左-右型：进行右旋，再左旋 */
    static AvlNode R_L_Rotate(AvlNode K3) {

        // 先对其孩子进行左旋
        K3.lchild = R_Rotate(K3.lchild);

        // 再进行右旋
        return L_Rotate(K3);
    }

    /* 右-左型：先进行左旋，再右旋 */
    static AvlNode L_R_Rotate(AvlNode K3) {

        // 先对孩子进行左旋
        K3.rchild = L_Rotate(K3.rchild);

        // 在右旋
        return R_Rotate(K3);
    }

    /* 插入数值操作 */
    static AvlNode insert(int data, AvlNode T) {

        if (T == null) {
            T = new AvlNode();
            T.data = data;
            T.lchild = T.rchild = null;
        } else if(data < T.data) {

            // 向左孩子递归插入
            T.lchild = insert(data, T.lchild);

            // 进行调整操作
            // 如果左孩子的高度比右孩子大2
            if (height(T.lchild) - height(T.rchild) == 2) {

                // 左-左型
                if (data < T.lchild.data) {
                    T = R_Rotate(T);
                } else {
                    // 左-右型
                    T = R_L_Rotate(T);
                }
            }
        } else if (data > T.data) {
            T.rchild = insert(data, T.rchild);

            // 进行调整
            // 右孩子比左孩子高度大2
            if(height(T.rchild) - height(T.lchild) == 2)
                // 右-右型
                if (data > T.rchild.data) {
                    T = L_Rotate(T);
                } else {
                    T = L_R_Rotate(T);
                }
        }
        // 否则，这个节点已经在书上存在了，我们什么也不做

        // 重新计算T的高度
        T.height = Math.max(height(T.lchild), height(T.rchild)) + 1;
        return T;
    }
}
