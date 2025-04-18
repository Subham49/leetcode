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
    private int getSwaps(int[] arr) {
    int n = arr.length;
    int[] sortedArr = Arrays.copyOf(arr, n);
    Arrays.sort(sortedArr);
    Map<Integer, Integer> idxMap = new HashMap<>();
    for (int i = 0; i < n; i++) {
        idxMap.put(arr[i], i);
    }
    int count = 0;
    for (int i = 0; i < n; i++) {
        if (arr[i] != sortedArr[i]) {
            int j = idxMap.get(sortedArr[i]);
            idxMap.put(arr[i], j);
            arr[j] = arr[i];
            count++;
        }
    }
    return count;
}
    public int minimumOperations(TreeNode root) {
        int count = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            int[] levelValues = new int[size];
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                levelValues[i] = node.val;
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }

            count += getSwaps(levelValues);
        }
        return count;
    }
}