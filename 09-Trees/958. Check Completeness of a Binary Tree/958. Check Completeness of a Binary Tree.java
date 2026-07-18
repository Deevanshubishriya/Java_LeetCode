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
17    public boolean isCompleteTree(TreeNode root) {
18        if (root == null) {
19            return true;
20        }
21        
22        Queue<TreeNode> q = new LinkedList<>();
23        q.add(root);
24        boolean foundNull = false;
25
26        while (!q.isEmpty()) {
27            TreeNode t = q.poll();
28
29            if (t == null) {
30                // Once we encounter a null node, we mark the flag as true.
31                foundNull = true;
32            } else {
33                // If we encounter a non-null node AFTER a null node, the tree is not complete.
34                if (foundNull) {
35                    return false;
36                }
37                // Add left and right children to the queue, even if they are null.
38                q.add(t.left);
39                q.add(t.right);
40            }
41        }
42        
43        // If we processed all nodes without violating the rule, it is complete.
44        return true; 
45    }
46}