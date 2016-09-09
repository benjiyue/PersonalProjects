public class Solution {
    public int lengthLongestPath(String input) {
        //we use a stack to keep going down the path, and the delimiters are the \n which divide the string into documents, so the base is always start with the first thing dir, then we expect one \t in order to contnue, then we expect two \t to continue on that and whenever we're about to pop from the stack we compare the accumulated sum to a max counter, we pop the same number of times as the difference between the number of \t we expect and how many we get
        int maxLength = 0;
        int currentLength = 0;
        int expectedTabs = 0;
        String[] separated = input.split("\\n");
        //stack containing the length of that string
        Stack<Integer> stack = new Stack();
        for(String s:separated){
            int numberOfTabs = 0;
            int iterator = 0;
            while(iterator<s.length()
            		&&s.charAt(iterator)=='\t'){
                iterator++;
                numberOfTabs++;
            }
            int thisLength = s.length()-iterator;
            //if it's expected then push onto stack, and add to summer
            if(numberOfTabs!=expectedTabs){
                //this is less thsan the number i expected so pop the difference
                int diff = expectedTabs -numberOfTabs;
                while(diff-->0)
                    currentLength-=stack.pop();
                expectedTabs = numberOfTabs;
            }
            currentLength+=thisLength;
            stack.push(thisLength);
            if(s.contains("."))
                maxLength = Math.max(maxLength, currentLength+stack.size()-1);
            expectedTabs++;
        }
        return maxLength;
    }
}