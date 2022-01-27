/**
 * https://leetcode.com/problems/valid-parentheses/
 */

class Solution {
    public boolean isValid(String s) {
        Stack<Character> stk = new Stack<>();
        
        for (int i = 0; i < s.length(); i++) {
            char current = s.charAt(i);
            if (current == '(' || current == '{' || current == '[') {
                stk.push(current);
            } else {
                if (stk.empty()) {
                    return false;
                }
                char removeVal = stk.pop();
                if ((current == ')' && removeVal != '(') || 
                   (current == '}' && removeVal != '{') || 
                   (current == ']' && removeVal != '[')) {
                    return false;
                }
            }
        }
        return stk.empty();
    }
}
