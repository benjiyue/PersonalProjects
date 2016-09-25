public class Solution {
    public boolean isValid(String s) {
        /*
        the idea is to use a stack to keep track of the last open paren, if we encounter a close paren it must be the conjugate for the peek else there's an error return false; go to end and return stack.isEmpty
        
        {()}[]
        stack:
        
        */
        Stack<Character> stack = new Stack();
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(c=='('||c=='{'||c=='[')
                stack.push(c);
            else{
                char popped = stack.isEmpty()?'1':stack.pop();
                if((c==']'&&popped!='[')||(c==')'&&popped!='(')||(c=='}'&&popped!='{'))
                    return false;
            }
        }
        return stack.isEmpty();
    }
}