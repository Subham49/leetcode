/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int moves = 0;
    int fun(TreeNode root){
        if(root == null) return 0;
        int l = fun(root.left);
        int r = fun(root.right);
        int t = l+r+root.val-1;
        moves += Math.abs(t);
        return t;
    }
    public int distributeCoins(TreeNode root) {
        fun(root);
        return moves;
    }
}