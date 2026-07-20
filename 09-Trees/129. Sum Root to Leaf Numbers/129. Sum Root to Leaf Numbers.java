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
17    int result =0;
18    public int sumNumbers(TreeNode root) {
19        result=0;
20        fun(root,0);
21        return result;
22    }
23    public void fun(TreeNode root,int sum){
24        if(root == null) return;
25        sum = sum *10 +root.val;
26        if(root.left== null && root.right==null){
27            result += sum;
28        }
29        fun(root.left, sum);
30        fun(root.right,sum);
31        
32    }
33    
34}