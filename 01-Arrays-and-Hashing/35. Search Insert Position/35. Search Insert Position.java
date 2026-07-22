1class Solution {
2    public int searchInsert(int[] nums, int target) {
3        int start = 0;
4        int end = nums.length -1;
5        int ans = nums.length;
6        while (start <= end){
7            int mid = start + (end - start)/2;
8            if(nums[mid]>=target){
9                ans = mid;
10                end = mid-1;
11            }
12            else{
13                start = mid +1;
14            }
15
16        }
17            return ans;
18    }
19}