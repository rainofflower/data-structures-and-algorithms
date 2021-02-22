package com.yanghui.datastructure.tree;

import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Stack;

/**
 * 树的建立与遍历
 *
 *
 *
 * @author YangHui
 */
public class BTreeBuildAndTraversal {

    /**
     * 测试递归遍历方法
     */
    @Test
    public void test(){
        BinaryTreeNode<String> root = new BinaryTreeNode<>("A");
        BinaryTreeNode<String> n1 = new BinaryTreeNode<>("B");
        BinaryTreeNode<String> n2 = new BinaryTreeNode<>("C");
        BinaryTreeNode<String> n3 = new BinaryTreeNode<>("D");
        BinaryTreeNode<String> n4 = new BinaryTreeNode<>("E");
        root.lTree = n1;
        n1.rTree = n3;
        root.rTree = n2;
        n2.lTree = n4;
        /**
         *         A
         *       /    \
         *      B      C
         *       \    /
         *        D  E
         *
         */
        System.out.println("前序：");
        preOrderTraversal(root);
        System.out.println();
        System.out.println("中序:");
        inOrderTraversal(root);
        System.out.println();
        System.out.println("后序");
        postOrderTraversal(root);
        System.out.println();
        System.out.println("层序");
        layerTraversal(root);
        System.out.println();
        System.out.println("广度优先");
        breadthFirst(root);
        System.out.println();
        System.out.println("深度优先");
        depthFirst(root);
        System.out.println();

    }

    @Test
    public void test2(){
        String[] preOrder = {"A","B","D","C","E"};
        String[] inOrder = {"B","D","A","E","C"};
        String[] postOrder = {"D","B","E","C","A"};
        BinaryTreeNode<String> root = buildTree1(preOrder, inOrder);
//        postOrderTraversal(root);
//        preOrderTraversal(root);
        layerTraversal(root);
//        BinaryTreeNode<String> root2 = buildTree2(postOrder, inOrder);
//        preOrderTraversal(root2);
//        layerTraversal(root2);
//        depthFirst(root2);
//        depthFirstNoneRec(root2);
//        inOrderTraversalNoneRec(root2);
    }

    /**
     * 已知前序遍历和中序遍历，还原二叉树
     * @param preOrder 前序遍历
     * @param inOrder 中序遍历
     * @return
     */
    public static <T> BinaryTreeNode<T> buildTree1(T[] preOrder, T[] inOrder){
        if(preOrder == null || preOrder.length == 0){
            return null;
        }
        //前序遍历第一个值就是根节点
        BinaryTreeNode<T> root = new BinaryTreeNode<>(preOrder[0]);
        int inOrderIndex = 0;
        //找出中序遍历根节点的下标
        for(int i = 0; i<inOrder.length; i++){
            if(root.value.equals(inOrder[i])){
                inOrderIndex = i;
                break;
            }
        }
        //前序遍历左子树部分
        T[] leftPreOrder = Arrays.copyOfRange(preOrder, 1, inOrderIndex+1);
        //前序遍历右子树部分
        T[] rightPreOrder = Arrays.copyOfRange(preOrder, inOrderIndex+1, preOrder.length);
        //中序遍历左子树部分
        T[] leftInOrder = Arrays.copyOfRange(inOrder, 0, inOrderIndex);
        //中序遍历右子树部分
        T[] rightInOrder = Arrays.copyOfRange(inOrder, inOrderIndex+1, inOrder.length);
        //左子树
        BinaryTreeNode<T> leftTree = buildTree1(leftPreOrder, leftInOrder);
        //右子树
        BinaryTreeNode<T> rightTree = buildTree1(rightPreOrder, rightInOrder);
        root.lTree = leftTree;
        root.rTree = rightTree;
        return root;
    }

    /**
     * 已知后续遍历和中序遍历，还原二叉树
     * @param postOrder 后续遍历
     * @param inOrder 中序遍历
     * @return
     */
    public static <T> BinaryTreeNode<T> buildTree2(T[] postOrder, T[] inOrder){
        if(postOrder == null || postOrder.length == 0){
            return null;
        }
        //后续遍历最后一个值就是根节点
        BinaryTreeNode<T> root = new BinaryTreeNode<>(postOrder[postOrder.length-1]);
        int inOrderIndex = 0;
        //找出中序遍历根节点的下标
        for(int i = 0; i<inOrder.length; i++){
            if(root.value.equals(inOrder[i])){
                inOrderIndex = i;
                break;
            }
        }
        //后序遍历左子树部分
        T[] leftPostOrder = Arrays.copyOfRange(postOrder, 0, inOrderIndex);
        //后序遍历右子树部分
        T[] rightPostOrder = Arrays.copyOfRange(postOrder, inOrderIndex, postOrder.length-1);
        //中序遍历左子树部分
        T[] leftInOrder = Arrays.copyOfRange(inOrder, 0, inOrderIndex);
        //中序遍历右子树部分
        T[] rightInOrder = Arrays.copyOfRange(inOrder, inOrderIndex+1, inOrder.length);
        //左子树
        BinaryTreeNode<T> leftTree = buildTree2(leftPostOrder, leftInOrder);
        //右子树
        BinaryTreeNode<T> rightTree = buildTree2(rightPostOrder, rightInOrder);
        root.lTree = leftTree;
        root.rTree = rightTree;
        return root;
    }

    /**
     * 前序遍历树
     * 顺序：根左右
     */
    public static <T> void preOrderTraversal(BinaryTreeNode<T> tree){
        System.out.print(tree.value+" ");
        if(tree.lTree != null){
            //遍历左子树
            preOrderTraversal(tree.lTree);
        }
        if(tree.rTree != null){
            //遍历右子树
            preOrderTraversal(tree.rTree);
        }
    }

    /**
     * 中序遍历树
     * 顺序：左根右
     */
    public static <T> void inOrderTraversal(BinaryTreeNode<T> tree){
        if(tree.lTree != null){
            //遍历左子树
            inOrderTraversal(tree.lTree);
        }
        System.out.print(tree.value+" ");
        if(tree.rTree != null){
            //遍历右子树
            inOrderTraversal(tree.rTree);
        }
    }

    /**
     * 中序遍历树-非递归
     * 使用栈
     * @param tree
     */
    public static <T> void inOrderTraversalNoneRec(BinaryTreeNode<T> tree){
        Stack<BinaryTreeNode<T>> stack = new Stack<>();
        BinaryTreeNode<T> node = tree;
        while(node != null || !stack.isEmpty()){
            if(node != null){
                stack.push(node);
                node = node.lTree;
            }
            else{
                node = stack.pop();
                System.out.print(node.value+" ");
                node = node.rTree;
            }
        }
    }

    /**
     * 后序遍历树
     * 顺序：左右根
     */
    public static <T> void postOrderTraversal(BinaryTreeNode<T> tree){
        if(tree.lTree != null){
            //遍历左子树
            postOrderTraversal(tree.lTree);
        }
        if(tree.rTree != null){
            //遍历右子树
            postOrderTraversal(tree.rTree);
        }
        System.out.print(tree.value+" ");
    }

    /**
     * 层序遍历
     * 从顶层往底层、从左向右遍历
     * 使用队列-先进先出
     * 一个节点的孩子一块进去，然后依次出来
     * @param tree
     */
    public static <T> void layerTraversal(BinaryTreeNode<T> tree){
        if(tree == null){
            return;
        }
        LinkedList<BinaryTreeNode<T>> queue = new LinkedList<>();
        queue.add(tree);
        while (!queue.isEmpty()){
            BinaryTreeNode<T> node = queue.poll();
            System.out.print(node.value+" ");
            if(node.lTree != null){
                queue.add(node.lTree);
            }
            if(node.rTree != null){
                queue.add(node.rTree);
            }
        }
    }

    /**
     * 深度优先（其实就是先序遍历） - 递归实现
     * 深度：探到最深处后再折回。一棵树一个分支遍历到底部再回溯
     * @param tree
     */
    public static <T> void depthFirst(BinaryTreeNode<T> tree){
        preOrderTraversal(tree);
    }

    /**
     * 深度优先（其实就是先序遍历） - 非递归实现
     * 使用栈-后进先出
     * @param tree
     */
    public static <T> void depthFirstNoneRec(BinaryTreeNode<T> tree){
        Stack<BinaryTreeNode<T>> stack = new Stack<>();
        stack.push(tree);
        while(!stack.isEmpty()){
            BinaryTreeNode<T> node = stack.pop();
            System.out.print(node.value+" ");
            //因为栈后进先出，因此右孩子先入栈，左孩子后入栈
            if(node.rTree != null){
                stack.push(node.rTree);
            }
            if(node.lTree != null){
                stack.push(node.lTree);
            }
        }
    }

    /**
     * 广度优先 - 层序遍历
     * 广度：遍历完一层后再往下遍历（水平面铺开，推广）
     * @param tree
     */
    public static <T> void breadthFirst(BinaryTreeNode<T> tree){
        layerTraversal(tree);
    }


}
