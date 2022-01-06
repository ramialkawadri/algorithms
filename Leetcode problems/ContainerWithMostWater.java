/**
 * https://leetcode.com/problems/container-with-most-water/
 */

class Solution {
    public int maxArea(int[] height) {
        int maxVal = 0;
        int i = 0, j = height.length - 1;  // pointers
        
        while (i < j) {
            if (height[i] < height[j]) {
                maxVal = Math.max(maxVal, height[i] * (j - i));
                i++;
            } else {
                maxVal = Math.max(maxVal, height[j] * (j - i));
                j--;
            }
        }
        
        return maxVal;
    }
}

