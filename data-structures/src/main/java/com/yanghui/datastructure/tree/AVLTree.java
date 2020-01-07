package com.yanghui.datastructure.tree;

import org.junit.Test;

/**
 * AVL树 即 平衡二叉查找(排序)树
 *
 * why
 * 二叉搜索树可能出现查找效率极低的情况，比如刚好构建一颗左/右 斜树，那么查找效率将会变成 O(n)
 * 实例：根据序列 1,2,3,4,5,6,7 创建一颗二叉搜索树，则刚好得到一颗右斜树，查找7需要比较7次
 * 平衡二叉搜索树就是为了解决这个问题
 *
 * what
 * AVL树本质上还是一棵二叉搜索树，它的特点是：
 * 1.本身首先是一棵二叉搜索树。
 * 2.带有平衡条件：每个结点的左右子树的高度之差的绝对值（平衡因子 bf - balance factor）最多为1。
 * 也就是说，AVL树，本质上是带了平衡功能的二叉查找树（二叉排序树，二叉搜索树）。
 *
 * Self-Balancing Binary Search Tree
 * Height-Balanced Binary Search Tree
 *
 * @author YangHui
 */
public class AVLTree {

    /**
     * 创建普通的二叉搜索树，发现生成的结构搜索效率低
     */
    @Test
    public void problem(){
        //该序列生成的二叉搜索树查询效率低
        Integer[] array = {3,2,1,4,5,6,7,10,9,8};
        BinaryTreeNode<Integer> root = null;
        for (int i = 0; i<array.length; i++) {
            root = BinarySearchTree.insert(root, array[i]);
        }
        BTreeBuildAndTraversal.inOrderTraversal(root);
        System.out.println();
        BTreeBuildAndTraversal.layerTraversal(root);
        System.out.println();
    }

}
