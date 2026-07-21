1class Solution {
2    public int search(int[] nums, int target) {
3        int low = 0;
4        int high = nums.length - 1;
5        
6        // Use <= to ensure the element is checked even when low and high point to the same index
7        while (low <= high) {
8            int mid = low + (high - low) / 2;
9            
10            if (nums[mid] == target) {
11                return mid;
12            } 
13            else if (nums[mid] < target) {
14                low = mid + 1;
15            } 
16            else {
17                high = mid - 1;
18            }
19        }
20        return -1;
21    }
22}