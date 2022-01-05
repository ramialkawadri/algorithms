/**
 * https://leetcode.com/problems/two-sum/
 */
import java.util.Map;
import java.util.HashMap;

public class TwoSum {

    // Time complexity: O(n), space complexity: O(n)
    public int[] twoSum(int[] nums, int target) {
        int[] indices = new int[2];
        Map<Integer, Integer> values = new HashMap<>();
        
        for (int i = 0; i < nums.length; i++) {
            int diff = target - nums[i];
            if (values.containsKey(diff))
            {
                indices[0] = values.get(diff);
                indices[1] = i;
                return indices;
            }
            else values.put(nums[i], i);
        }

        return null;
    }
}
