package com.yanghui.datastructure.tree;

/**
 * 二叉树结构
 *
 * 大多采用链表存储，本实现类也一样
 * 当然也可以采用数组、或者数组加链表实现
 *
 * @author YangHui
 */
public class BinaryTreeNode<T> {

    T value;

    /**
     * 左子树
     */
    BinaryTreeNode<T> lTree;

    /**
     * 右子树
     */
    BinaryTreeNode<T> rTree;

    public BinaryTreeNode(){}

    public BinaryTreeNode(T value){
        this.value = value;
    }

    public BinaryTreeNode(T value, BinaryTreeNode<T> lTree, BinaryTreeNode<T> rTree){
        this.value = value;
        this.lTree = lTree;
        this.rTree = rTree;
    }

}
