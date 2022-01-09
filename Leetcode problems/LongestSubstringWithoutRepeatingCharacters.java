/**
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/
 */
import java.util.HashMap;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int longest = 0, left = 0;
        HashMap<Character, Integer> seen = new HashMap<>();
        
        for (int right = 0; right < s.length(); right++) {
            char current = s.charAt(right);
            
            if (seen.containsKey(current) && seen.get(current) >= left) {
                left = seen.get(current) + 1;
            }
            
            seen.put(current, right);
            longest = Math.max(longest, right - left + 1);
        }
        
        return longest;
    }
}
