package com.dooonabe.collection.tree;

/**
 * 103. Symmetric Tree
 * Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).
 * Created on 2019/2/20.
 */
public class SymmetricTree {
    class Solution {
        public boolean isSymmetric(TreeNode root) {
            if (root == null) return true;
            return isSame(root.left, root.right);
        }

        private boolean isSame(TreeNode left, TreeNode right) {
            if (left == null && right == null) {
                return true;
            } else if (left != null && right != null) {
                if(left.val == right.val){
                    return isSame(left.right, right.left);
                } else {
                    return false;
                }
            } else return false;
        }
    }
}
