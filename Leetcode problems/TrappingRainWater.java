/**
 * https://leetcode.com/problems/trapping-rain-water/
 */

class Solution {
    public int trap(int[] height) {
        int result = 0, pL = 0, pR = height.length - 1, 
        toAdd = 0, maxLeft = height[pL], maxRight = height[pR];
            
        while (pL < pR) {
            toAdd = 0;
            
            if (height[pL] < height[pR]) {
                toAdd = Math.min(maxLeft, maxRight) - height[pL];
                pL++;
            } else {
                toAdd = Math.min(maxLeft, maxRight) - height[pR];
                pR--;
            }
            
            if (toAdd > 0) result += toAdd;
            
            maxLeft = Math.max(height[pL], maxLeft);
            maxRight = Math.max(height[pR], maxRight);
        }
        
        return result;
    }
}

