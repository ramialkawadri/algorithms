/**
 * https://leetcode.com/problems/kth-largest-element-in-an-array/
 */

class Solution {
    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }
}

// Solutin #2
/*
class Solution {
    public int findKthLargest(int[] nums, int k) {
        return quickselect(nums, 0, nums.length - 1, nums.length - k);
    }
    
    // Hoare's quickselect algorithm
    public static int quickselect(int[] nums, int start, int end, int k) {
        if (start >= end) return nums[end];
        int p = partition(nums, start, end);
        if (p == k) return nums[p];
        else if (p > k) return quickselect(nums, start, p - 1, k);
        else return quickselect(nums, p + 1, end, k);
    }
    
    public static int partition(int[] nums, int start, int end) {
        int i = start - 1, pivot = nums[end];
        
        for (int j = start; j < end; j++) {
            if (nums[j] < pivot) {
                i++;
                int temp = nums[j];
                nums[j] = nums[i];
                nums[i] = temp;
            }
        }
        
        i++;
        int temp = nums[i];
        nums[i] = nums[end];
        nums[end] = temp;
        return i;
    }
}
/*