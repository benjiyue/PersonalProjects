public class Solution {
    public int longestValidParentheses(String s) {
        /*
        every time the sum isn't 0 i add it to the stack with the index. Then if im a close and the peek index is a ( then i can pop which would be the ( and look at the next peek to determine the last time it failed and the result if the diff between current index and the peek. but if the peek is not a ( then simply push
        */
        
        Stack<Integer> stack = new Stack();
        int max = 0;
        stack.push(-1);
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            
            if(c=='(')
                stack.push(i);
            else{
                if(!stack.isEmpty()&&stack.peek()!=-1&&s.charAt(stack.peek())=='('){
                    stack.pop();
                    max = Math.max(max, i-stack.peek());
                }else
                    stack.push(i);
            }
            
        }
        return max;
    }
}