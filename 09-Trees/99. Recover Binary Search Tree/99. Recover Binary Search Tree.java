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
17    TreeNode prev = null;
18    TreeNode g1first = null;
19    TreeNode g1second = null;
20    TreeNode g2first =null;
21    TreeNode g2second = null;
22    int wrong =0;
23    public void recoverTree(TreeNode root) {
24        fun(root);
25        // Inside your main recoverTree method after calling fun(root)
26    if (g2second != null) {
27    // Two non-adjacent nodes were swapped
28        swap(g1first, g2second);
29    } else {
30    // Two adjacent nodes were swapped
31        swap(g1first, g1second);
32        }
33    }
34    public void fun(TreeNode root) {
35    if (root == null) return;
36    
37    fun(root.left);
38    
39    if (prev != null) {
40        // If we find a swapped pair
41        if (root.val < prev.val) {
42            if (g1first == null) {
43                // First violation: Record both nodes
44                g1first = prev;
45                g1second = root;
46            } else {
47                // Second violation: We only need to update the second node
48                g2second = root;
49            }
50        }
51    }
52    prev = root;
53    
54    fun(root.right);
55}
56    public void swap(TreeNode g1,TreeNode g2){
57        int temp= g1.val; 
58        g1.val=g2.val;
59        g2.val=temp;
60    }
61}