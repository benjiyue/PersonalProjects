public class MinStack {
    /*
    Idea is that we store the old min when we encounter a new or equal min
    
    */
    /** initialize your data structure here. */
    Stack<Integer> values;
    Stack<Integer> min;
    public MinStack() {
        values = new Stack();
        min = new Stack();
    }
    
    public void push(int x) {
        values.push(x);
        if(min.isEmpty()||x<=min.peek())
            min.push(x);
    }
    
    public void pop() {
        if(values.isEmpty())
            return;
        int popped = values.pop();
        if(popped==min.peek())
            min.pop();
    }
    
    public int top() {
        return values.peek();
    }
    
    public int getMin() {
        return min.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */