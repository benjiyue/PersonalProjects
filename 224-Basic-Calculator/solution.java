public class Solution {
    public int calculate(String s) {
        //idea is stack for when we encounter a paren
        //then also have a sign indicator for whether we're adding or subtracting
        //then iterate throught the string when we see a + we change the int to 1, else we change to - then when we see nubmer we simply use the indicator to + or - the number we read and add to accumulator
        //when we see a ( we push the accumulated so far to the stack along with the sign
        //then when wee a ) we pop sign then number from stack and modify the current accumulator to add the current accumualtor and the popped
        s = s.replace(" ", "");
        int counter = 0;
        int sum = 0;
        int sign = 1;
        Stack<Integer> stack = new Stack();
        
        while(counter<s.length()){
            char c = s.charAt(counter);
            if(c=='+')
                sign = 1;
            else if(c=='-')
                sign = -1;
            else if(c=='('){
                stack.push(sum);
                stack.push(sign);
                sum = 0;
                sign = 1;
            }else if(c==')'){
                int applyToCurSum = stack.pop();
                int beforeSum = stack.pop();
                sum = beforeSum+applyToCurSum*sum;
                sign = 1;
            }else{
                //there's a number
                int thisNum = c-'0';
                counter++;
                while(counter<s.length()&&s.charAt(counter)-'0'>=0&&s.charAt(counter)-'0'<=9){
                    thisNum*=10;
                    thisNum+=s.charAt(counter)-'0';
                    counter++;
                }
                sum+=sign*thisNum;
                counter--;
            }
            counter++;
        }
        return sum;
    }
}