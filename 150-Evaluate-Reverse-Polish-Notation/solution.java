public class Solution {
    public int evalRPN(String[] tokens) {
        //idea is to use a stack, when we see a number simply push when we see a operator we do the operator to the top 2 things and then push backto the stack
        
        Stack<Integer> stack = new Stack();
        
        for(int i=0;i<tokens.length;i++){
            String cur = tokens[i];
            if(cur.equals("+")){
                int sum = stack.pop()+stack.pop();
                stack.push(sum);
            }else if(cur.equals("-")){
                int diff = -1*stack.pop()+stack.pop();
                stack.push(diff);
            }else if(cur.equals("*")){
                int product = stack.pop()*stack.pop();
                stack.push(product);
            }else if(cur.equals("/")){
                int denom = stack.pop();
                int num = stack.pop();
                stack.push(num/denom);
            }else{
                stack.push(Integer.parseInt(cur));
            }
        }
        return stack.pop();
        
    }
}