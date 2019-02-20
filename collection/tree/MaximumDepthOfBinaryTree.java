package com.dooonabe.collection.tree;

/**
 * 104. Maximum Depth of Binary Tree
 * Given a binary tree, find its maximum depth.
 * The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
 * Note: A leaf is a node with no children.
 * Created on 2019/2/20.
 */
public class MaximumDepthOfBinaryTree {
    /**
     * continue find the max number, every time recursive
     * @param root rootnode
     * @return maxdepth
     */
    public int maxDepth(TreeNode root) {
        int maxDepth = 0;
        if (root!=null){
            System.out.println(root.val);
            maxDepth += 1;
            int leftDepth = maxDepth(root.left);
            int rightDepth = maxDepth(root.right);
            if(leftDepth >= rightDepth){
                maxDepth += leftDepth;
            } else {
                maxDepth += rightDepth ;
            }
        }
        return maxDepth;
    }


    public int anotherMaxDepth(TreeNode root){
        if(root == null) return 0;
        // Math.max is so fast!!!!
        return 1+Math.max(anotherMaxDepth(root.left), anotherMaxDepth(root.right));
    }
}



