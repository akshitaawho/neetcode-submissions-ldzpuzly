class Solution {
    public int evalRPN(String[] tokens) {
        int finalanswer = 0;
        Stack<Integer> stack = new Stack<>();

        for (String c : tokens){
            int result = 0;
            int a = 0;
            int b = 0;

            if (c.equals("+") || c.equals("-") || c.equals("*") || c.equals("/")){
                if (c.equals("+")){
                    a = stack.pop();
                    b = stack.pop();
                    result = a + b;
                    stack.push(result);
                }
                else if (c.equals("-")){
                    a = stack.pop();
                    b = stack.pop();
                    result = b - a;
                    stack.push(result);
                }
                else if (c.equals("*")){
                    a = stack.pop();
                    b = stack.pop();
                    result = a * b;
                    stack.push(result);
                }
                else if (c.equals("/")){
                    a = stack.pop();
                    b = stack.pop();
                    result = b / a;
                    stack.push(result);
                }
            }

            else{
                stack.push(Integer.parseInt(c));
            }
        }

        finalanswer = stack.pop();

        return (finalanswer);
    }
}
