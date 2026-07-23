1class Solution {
2    public int[] searchRange(int[] nums, int target) {
3        int first = findBound(nums, target, true);
4        int last = findBound(nums, target, false);
5        return new int[]{first, last};
6    }
7
8    public int findBound(int[] nums, int target, boolean isFirst) {
9        int low = 0, high = nums.length - 1;
10        int bound = -1;
11
12        while (low <= high) {
13            int mid = low + (high - low) / 2;
14
15            if (nums[mid] == target) {
16                bound = mid; // Record match, but keep searching for boundaries
17                if (isFirst) {
18                    high = mid - 1; // Search left half for earlier occurrence
19                } else {
20                    low = mid + 1;  // Search right half for later occurrence
21                }
22            } else if (nums[mid] < target) {
23                low = mid + 1;
24            } else {
25                high = mid - 1;
26            }
27        }
28        return bound;
29    }
30}