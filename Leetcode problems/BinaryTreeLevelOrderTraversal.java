/**
 * https://leetcode.com/problems/binary-tree-level-order-traversal/
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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new LinkedList<List<Integer>>();
        if (root == null) return ans;
        
        Queue<TreeNode> curr = new LinkedList<>();
        curr.add(root);
        
        while(!curr.isEmpty()) {
            int length = curr.size();
            LinkedList<Integer> currentLevelElement = new LinkedList<>();
            
            for (int i = 0; i < length; i++) {
                TreeNode currentNode = curr.remove();
                currentLevelElement.add(currentNode.val);
                
                if (currentNode.left != null) curr.add(currentNode.left);
                if (currentNode.right != null) curr.add(currentNode.right);
            }
            ans.add(currentLevelElement);
        }
        
        return ans;
    }
}
