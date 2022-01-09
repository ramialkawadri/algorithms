/**
 * https://leetcode.com/problems/backspace-string-compare/
 */

class Solution {
    public boolean backspaceCompare(String s1, String s2) {
        int p1 = s1.length() - 1, p2 = s2.length() - 1, skip1 = 0, skip2 = 0;
        
        while (p1 >= 0 || p2 >= 0) {
            p1 = escapeHashes(s1, p1);
            p2 = escapeHashes(s2, p2);
            
            if ((p1 >= 0 && p2 >= 0 && s1.charAt(p1) != s2.charAt(p2))
               || (p1 >= 0) != (p2 >= 0))
                return false;
            p1--; 
            p2--;
        }
        
        return true;
    }
    
    public static int escapeHashes(String s, int startIndex) {
        int skip = 0, i = startIndex;
        while (i >= 0) {
            if (s.charAt(i) == '#') skip++;
            else if (skip > 0) skip--;
            else break;
            i--;
        }
        return i;
    }
}

