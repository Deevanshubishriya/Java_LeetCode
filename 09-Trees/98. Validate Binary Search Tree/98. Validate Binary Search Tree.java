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
17    public boolean isValidBST(TreeNode root) {
18        return valid(root,null,null);
19    }
20    public boolean valid(TreeNode root,Integer low,Integer right ){
21        if(root==null)return true;
22        if((low!=null&&root.val<=low)||(right!=null&&root.val>=right))return false;
23        return valid(root.left,low,root.val)&& valid(root.right,root.val,right);
24    }
25
26}