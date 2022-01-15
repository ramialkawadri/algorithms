/**
 * https://leetcode.com/problems/valid-palindrome-ii/
 */

class Solution {
    public boolean validPalindrome(String s) {
        int start = 0, end = s.length() - 1;
        
        while (start < end) {
            /* 
              Looping until finding unmatching character and then we
              check both sides.
            */
            if (s.charAt(start) != s.charAt(end))
            {
                return isPalindrome(s, start + 1, end) || 
                    isPalindrome(s, start, end - 1);
            }
            else {
                start++; end--;
            }
        }
        return true;
    }
    
    // Checking if a string is palindrome between two indices.
    private static boolean isPalindrome(String s, int start, int end) {
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) return false;
            start++; end--;
        }
        return true;
    }
}

