/**
 * https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
 */

class Solution {
    public int[] searchRange(int[] nums, int target) {
        int index = binarySearch(nums, target, 0, nums.length - 1);
        int[] ans = {index, index};
        
        if (index == -1) return ans;

        // Finding the lower index
        int temp = binarySearch(nums, target, 0, index - 1);
        while (temp != -1) {
            ans[0] = temp;
            temp = binarySearch(nums, target, 0, temp - 1);
        }
        
        // Finding the upper index
        temp = binarySearch(nums, target, index + 1, nums.length - 1);
        while (temp != -1) {
            ans[1] = temp;
            temp = binarySearch(nums, target, temp + 1, nums.length - 1);
        }
        
        return ans;
    }

    public static int binarySearch(int[] nums, int target, int low, int high) {
        
        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums[mid] == target) return mid;
            else if (nums[mid] > target) high = mid - 1;
            else low = mid + 1;
        }
        return -1;
    }
}