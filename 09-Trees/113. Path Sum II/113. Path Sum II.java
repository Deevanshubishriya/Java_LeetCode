1/**
2 * Definition for a binary tree node.
3 * public class TreeNode {
4 *     int val;
5 *     TreeNode left;
6 *     TreeNode right;
7 *     TreeNode() {}
8 *     TreeNode(int val) { this.val = val; }
9 *     TreeNode(int val, TreeNode left, TreeNode right) {
10 *         this.val = val;
11 *         this.left = left;
12 *         this.right = right;
13 *     }
14 * }
15 */
16class Solution {
17    // Make your result list global so your recursive function can access it
18    List<List<Integer>> res = new ArrayList<>();
19    
20    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
21        // Create the current path list
22        List<Integer> currentPath = new ArrayList<>();
23        
24        // Start the recursive function
25        fun(root, 0, targetSum, currentPath);
26        
27        return res;
28    }
29    
30    public void fun(TreeNode node, int currentSum, int target, List<Integer> currentPath) {
31        if (node == null) return;
32        
33        // 1. Add the current node to our path and sum
34        currentSum += node.val;
35        currentPath.add(node.val);
36        
37        // 2. Check if it's a leaf node and if the sum matches the target
38        if (node.left == null && node.right == null && currentSum == target) {
39            // We found a valid path! Add a COPY of currentPath to our results.
40            res.add(new ArrayList<>(currentPath));
41        } else {
42            // 3. If not a leaf, or sum doesn't match, continue down the left and right subtrees
43            fun(node.left, currentSum, target, currentPath);
44            fun(node.right, currentSum, target, currentPath);
45        }
46        
47        // 4. BACKTRACK: Remove the current node from the path before we go back up the tree
48        currentPath.remove(currentPath.size() - 1);
49    }
50}