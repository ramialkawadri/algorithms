/**
 * https://leetcode.com/problems/count-complete-tree-nodes/
 */

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
    public int countNodes(TreeNode root) {
        if (root == null) return 0;
        int height = heightOfCompleteTree(root);
        if (height == 0) return 1;

        int upperCount = (int)(Math.pow(2, height) - 1);
        int left = 0, right = upperCount;
        
        while (left < right) {
            int mid = (int)(Math.ceil((left + right) / 2.0));
            if (NodeExist(mid, root, height)) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        
        return upperCount + left + 1;
    }
    
    public boolean NodeExist(int index, TreeNode root, int height) {
        int left = 0, right = (int)(Math.pow(2, height) - 1), count = 0;
        
        while (count < height) {
            int mid = (int)(Math.ceil((left + right) / 2.0));
            if (index >= mid) {
                root = root.right;
                left = mid;
            } else {
                root = root.left;
                right = mid - 1;
            }
            count++;
        }
        
        return root != null;
    }
    
    public int heightOfCompleteTree(TreeNode root) {
        int height = 0;
        while (root.left != null) {
            height++;
            root = root.left;
        }
        
        return height;
    }
}
