package com.yanghui.leetcode;

import org.junit.Test;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class Problem111 {

    @Test
    public void test(){
//        TreeNode n9 = new TreeNode(9);
//        TreeNode n15 = new TreeNode(15);
//        TreeNode n7 = new TreeNode(7);
//        TreeNode n20 = new TreeNode(20, n15, n7);
//        TreeNode root = new TreeNode(3, n9, n20);

        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        TreeNode n3 = new TreeNode(3);
        TreeNode n2 = new TreeNode(2, n4, n5);
        TreeNode root = new TreeNode(1, n2, n3);

        System.out.println(minDepth(root));
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }

        public int getVal() {
            return val;
        }
    }

    public int minDepth(TreeNode root) {
        if(root == null) return 0;
        int depth = 1;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            System.out.println("===="+depth+"=====");
            System.out.println(toString(queue));
            int size = queue.size();
            for(int i=0; i<size; i++){
                TreeNode curr = queue.poll();
                if(curr.left == null && curr.right == null){
                    return depth;
                }
                if(curr.left != null){
                    queue.offer(curr.left);
                }
                if(curr.right != null){
                    queue.offer(curr.right);
                }
            }
            depth++;
        }
        return depth;
    }

    public String toString(Queue<TreeNode> queue) {
        Iterator<TreeNode> it = queue.iterator();
        if (! it.hasNext())
            return "[]";

        StringBuilder sb = new StringBuilder();
        sb.append('[');
        for (;;) {
            TreeNode e = it.next();
            sb.append(e.getVal());
            if (! it.hasNext())
                return sb.append(']').toString();
            sb.append(',').append(' ');
        }
    }

}
