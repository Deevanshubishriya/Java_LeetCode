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
17    boolean res = false;
18    public boolean hasPathSum(TreeNode root, int targetSum) {
19        res = false;
20        fun(root,0,targetSum);
21            return res;
22    }
23    public void fun(TreeNode root,int sum , int target){
24        if(root==null) return;
25        sum += root.val;
26        if(root.left==null&& root.right ==null){
27            if(sum==target){
28                res = true;
29                return;
30            }
31        }
32        fun(root.left,sum,target);
33        fun(root.right,sum,target);
34        return;
35    }
36}