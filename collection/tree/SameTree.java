package com.dooonabe.collection.tree;

/**
 * Created on 2019/2/18.
 */
public class SameTree {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        return p.val == q.val && isSameTree(p.right, q.right) && isSameTree(p.left, q.left);
    }
}
