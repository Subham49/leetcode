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
    int cam = 0;
    int fun(TreeNode root){
        if(root == null) return 0;
        int l = fun(root.left);
        int r = fun(root.right);

        if(l == -1 || r == -1) //left have no cam or right has no camera
        {
            cam++;
            return 1; //install camera
        }
        if(l == 1 || r == 1) return 0; //left has cam or right has cam
        return -1; //no camera cover
    }
    public int minCameraCover(TreeNode root) {
        return fun(root)==-1?cam+1:cam;
    }
}