class MinStack {
    Stack<Integer> stack = new Stack<>();
    Stack<Integer> minstack = new Stack<>();

    public MinStack() {

    }
    
    public void push(int val) {
        stack.push(val);

        if (minstack.isEmpty() || minstack.peek() > val){
            minstack.push(val);
        }

        else{
            minstack.push(minstack.peek());
        }
    }
    
    public void pop() {
        stack.pop();
        minstack.pop();
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return minstack.peek();
    }
}
