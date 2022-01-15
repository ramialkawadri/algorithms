/**
 * https://leetcode.com/problems/valid-palindrome/
 */

class Solution {
    public boolean isPalindrome(String s) {
        int start = 0, end = s.length() - 1;
        s = s.toLowerCase();
        while (start < end) {
            // Skipping on-alphanumeric characters.
            while (start < s.length() && !isAlphanumeric(s.charAt(start))) start++;
            while (end >= 0 && !isAlphanumeric(s.charAt(end))) end--;
            
            if (start >= s.length() || end < 0) break;
            else if (s.charAt(start) != s.charAt(end)) return false;
            start++; end--;
        }
        return true;
    }
    
    private static boolean isAlphanumeric(char c) {
        return Character.isAlphabetic(c) || Character.isDigit(c);
    }
}

