/**
 * https://leetcode.com/problems/binary-tree-right-side-view/
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
// DFS
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        ArrayList<Integer> ans = new ArrayList<>();
        if (root == null) return ans;
        
        rightSideViewDFS(root, ans, 0);
        return ans;
    }
    
    public void rightSideViewDFS(TreeNode root, ArrayList<Integer> ans, int count) {
        if (root == null) return;
        else if (count >= ans.size()) ans.add(root.val);
        
        rightSideViewDFS(root.right, ans, count + 1);
        rightSideViewDFS(root.left, ans, count + 1);
    }
}

// BFS
/*
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        ArrayList<Integer> ans = new ArrayList<>();
        if (root == null) return ans;
        
        Queue<TreeNode> nodes = new LinkedList<>();
        nodes.add(root);
        while (!nodes.isEmpty()) {
            int length = nodes.size(), count = 0;
            
            TreeNode currentNode = null;
            while (count < length) {
                currentNode = nodes.remove();
                if (currentNode.left != null) nodes.add(currentNode.left);
                if (currentNode.right != null) nodes.add(currentNode.right);
                count++;
            }
            ans.add(currentNode.val);
        }
        
        return ans;
    }
}
*/
