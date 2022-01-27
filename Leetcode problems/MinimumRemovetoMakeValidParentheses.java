/**
 * https://leetcode.com/problems/minimum-remove-to-make-valid-parentheses/
 */

class Solution {
    public String minRemoveToMakeValid(String s) {
        if (s.length() == 0) return s;
        
        Stack<Integer> positions = new Stack<>();
        char[] res = new char[s.length()];
        
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                positions.add(i);
            } else if (s.charAt(i) == ')') {
                if (positions.size() > 0) positions.pop();
                else {
                    res[i] = '0';
                    continue;
                }
            } 
            res[i] = s.charAt(i);
        }
        
        // Values == 0 means empty.
        while (positions.size() > 0) {
            res[positions.pop()] = '0';
        }

        return String.valueOf(res).replace("0", "");
    }
}