package com.yanghui.datastructure.tree;

import org.junit.Test;

/**
 * 二叉排序树/二叉查找树（Binary search tree）
 *
 * why how
 * 由于链表查询效率低O(n)（两端插入删除效率高0(1)），顺序表插入删除效率低O(n)（查询效率高O(1)），
 * 两者都有一定的缺陷，为了得到一种查询效率，插入删除效率兼顾，且都还不错的数据结构，二叉排序树应运而生
 * 插入和查找效率都是 0(log2n)
 *
 *  what
 *  一棵空树或者具有以下性质的二叉树：
 *  1、若它的左子树不为空，则左子树上所有结点的值均小于它的根节点的值
 *  2、若它的右子树不为空，则右子树上所有结点的值均大于它的根节点的值
 *  3、左、右子树也分别为二叉排序树
 *  4、没有键值相等的结点
 *
 *  第4个性质不允许有重复的元素，如果非要表示有两个相同的元素集合，可以在外部标记树中该元素有两份
 *
 * @author YangHui
 */
public class BinarySearchTree {

    @Test
    public void test(){
//        Integer[] array = {70, 67, 46, 105, 100, 99, 104, 103, 115, 110, 108, 112};
        Integer[] array = {5,9,3,7,1,4,6,8,2};
        BinaryTreeNode<Integer> root = null;
        for (int i = 0; i<array.length; i++) {
            root = insert(root, array[i]);
        }
        //中序遍历二叉排序树会得到从小到大排好序的列表
        BTreeBuildAndTraversal.inOrderTraversal(root);
        System.out.println();
//        BTreeBuildAndTraversal.preOrderTraversal(root);
//        System.out.println();
        BTreeBuildAndTraversal.layerTraversal(root);
        System.out.println();
        BinaryTreeNode<Integer> search = search(root, 67);
        if(search != null){
            System.out.println(search.value);
        }
        int deleteItem = 70;
        boolean delete = delete(root, deleteItem);
        System.out.println("删除结点: "+deleteItem+" 是否成功："+delete);
        BTreeBuildAndTraversal.layerTraversal(root);
    }

    /**
     * 按二叉排序树的性质 插入 元素
     * @param node 树的根节点，如果为null,认为是一个空树，建立根结点
     * @param item
     * @param <T>
     * @return 树的根节点
     */
    public static <T extends Comparable<T>> BinaryTreeNode<T> insert(BinaryTreeNode<T> node, T item){
        if(node == null){
            return new BinaryTreeNode<>(item);
        }
        final BinaryTreeNode<T> parent = searchParent(node, item);
        if(parent == null){
            //item等于根节点，直接返回
            return node;
        }
        if(parent.value.compareTo(item) > 0){
            //双亲结点值更大，应该作为左孩子
            if(parent.lTree == null){
                //不存在才插入，存在就不处理
                parent.lTree = new BinaryTreeNode<>(item);
            }
        }else{
            //双亲结点值更小，应该作为右孩子
            if(parent.rTree == null){
                parent.rTree = new BinaryTreeNode<>(item);
            }
        }
        return node;
    }

    /**
     * 删除 结点
     * @param root
     * @param item
     * @param <T>
     */
    public static <T extends Comparable<T>> boolean delete(BinaryTreeNode<T> root, T item){
        if(root == null){
            return false;
        }
        final BinaryTreeNode<T> parent = searchParent(root, item);
        if(parent == null){
            if(root.lTree == null && root.rTree == null){
                //只有根结点,释放根结点数据
                root.value = null;
            }else{
                //如果根节点还有子树，目前实现为不允许删除
                return false;
            }
        }else{
            if(parent.lTree != null && parent.lTree.value.compareTo(item) == 0){
                //双亲结点的左节点是要删除的结点
                doDelete(parent, parent.lTree, true);
            }else if(parent.rTree != null && parent.rTree.value.compareTo(item) == 0){
                //双亲结点的右节点是要删除的结点
                doDelete(parent, parent.rTree, false);
            }else{
                //未找到要删除的结点
                return false;
            }
        }
        return true;
    }

    private static <T extends Comparable<T>> void doDelete(BinaryTreeNode<T> parent, BinaryTreeNode<T> curr, boolean left){
        if(curr.lTree == null){
            if(left){
                parent.lTree = curr.rTree;
            }else{
                parent.rTree = curr.rTree;
            }
            curr.value = null;
            curr.lTree = null;
            curr.rTree = null;
        }else if(curr.rTree == null){
            if(left){
                parent.lTree = curr.lTree;
            }else{
                parent.rTree = curr.lTree;
            }
            curr.value = null;
            curr.lTree = null;
            curr.rTree = null;
        }else{
            /**
             * 要删除结点左右子树都不为空
             * 有两种方案处理，这里采用 将要删除结点的直接前驱替换要删除的结点的方式，另一种方式是使用直接后继
             * 某一个结点的直接前驱指的是中序遍历得到的有序顺序表中这个结点的前一个结点
             */
            //前驱
            BinaryTreeNode<T> predecessor = curr.lTree;
            BinaryTreeNode<T> predecessorParent = curr;
            BinaryTreeNode<T> temp = curr.lTree;
            while(temp.rTree != null){
                predecessor = temp.rTree;
                predecessorParent = temp;
                temp = temp.rTree;
            }
            curr.value = predecessor.value;
            if(predecessor == curr.lTree){
                //前驱结点就是要删除结点的左子树
                curr.lTree = predecessor.lTree;
            }else{
                //前驱结点不是要删除结点的直接子树
                predecessorParent.rTree = predecessor.lTree;
            }
            predecessor.value = null;
            predecessor.lTree = null;
            predecessor.rTree = null;
        }
    }

    /**
     * 搜索
     * @param node 树
     * @param item 要查找的值
     * @param <T>
     * @return 找到的结点
     */
    public static <T extends Comparable<T>> BinaryTreeNode<T> search(BinaryTreeNode<T> node, T item) {
        if (node == null) {
            return null;
        } else if (node.value.compareTo(item) == 0) {
            return node;
        } else if (node.value.compareTo(item) > 0) {
            return search(node.lTree, item);
        } else {
            return search(node.rTree, item);
        }
    }

    /**
     * 搜索某一个值的双亲结点
     * @param root 根节点
     * @param item 要查找的值
     * @param <T>
     * @return 双亲结点
     */
    public static <T extends Comparable<T>> BinaryTreeNode<T> searchParent(BinaryTreeNode<T> root, T item) {
        if(root == null){
            throw new IllegalArgumentException();
        }
        return doSearchParent(root, null, item);
    }

    private static <T extends Comparable<T>> BinaryTreeNode<T> doSearchParent(BinaryTreeNode<T> node, BinaryTreeNode<T> parent, T item) {
        if (node == null) {
            return parent;
        } else if (node.value.compareTo(item) == 0) {
            //当根节点等于item时，parent为null,否则就是双亲结点
            return parent;
        } else if (node.value.compareTo(item) > 0) {
            return doSearchParent(node.lTree, node, item);
        } else {
            return doSearchParent(node.rTree, node, item);
        }
    }
}
