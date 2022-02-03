/**
 *https://leetcode.com/submissions/detail/622379237/s://leetcode.com/submissions/detail/622379237/
 */

class MyQueue {
    private Stack<Integer> stack1, stack2;
    
    public MyQueue() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }
    
    private void makeItToQueue() {
        if (stack2.size() != 0) return;
        while (stack1.size() > 0) stack2.push(stack1.pop());
    }
    
    public void push(int x) {
        stack1.push(x); 
    }
    
    public int pop() {
        makeItToQueue();
        return stack2.pop();
    }
    
    public int peek() {
        makeItToQueue();
        return stack2.peek();
    }
    
    public boolean empty() {
        return stack1.size() == 0 && stack2.size() == 0;
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
