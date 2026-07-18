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
17    public boolean isBalanced(TreeNode root) {
18        // Agar helper function -1 return karta hai, toh tree unbalanced hai
19        return checkHeight(root) != -1;
20    }
21
22    private int checkHeight(TreeNode node) {
23        // Base case: null node ki height 0 hoti hai
24        if (node == null) {
25            return 0;
26        }
27
28        // Left subtree check karo
29        int leftHeight = checkHeight(node.left);
30        if (leftHeight == -1) {
31            return -1; // Agar left subtree unbalanced hai, seedha -1 return kar do
32        }
33
34        // Right subtree check karo
35        int rightHeight = checkHeight(node.right);
36        if (rightHeight == -1) {
37            return -1; // Agar right subtree unbalanced hai, seedha -1 return kar do
38        }
39
40        // Current node par balancing check karo
41        if (Math.abs(leftHeight - rightHeight) > 1) {
42            return -1; // Difference 1 se zyada hai, toh unbalanced (return -1)
43        }
44
45        // Agar sab theek hai, toh normal height return karo
46        return 1 + Math.max(leftHeight, rightHeight);
47    }
48}