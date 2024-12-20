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
    public TreeNode reverseOddLevels(TreeNode root) {
        if(root == null)
            return root;
        ArrayDeque<TreeNode> q = new ArrayDeque<>();
        q.add(root);

        int level = 0;
        while(!q.isEmpty())
        {
            int s = q.size();
            for(int i=0; i<s; i++)
            {
                TreeNode temp = q.remove();
                if(temp.left!=null)
                    q.add(temp.left);
                if(temp.right!=null)
                    q.add(temp.right);
            }
            level++;
            if(level%2 == 1)
            {
                int a[] = new int[q.size()];
                int i=0;
                for(TreeNode t : q)
                {
                    a[i++] = t.val;
                }

                i = q.size()-1;
                for(TreeNode t : q)
                {
                    t.val = a[i--];
                }
            }
        }
        return root;
    }
}