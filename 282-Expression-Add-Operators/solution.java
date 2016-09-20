public class Solution {
    public List<String> addOperators(String num, int target) {
        //actually we also need to keep trackof more since we need to preserve order of op, we keep track of the last poeuct/sum added to the totals and if it's plus simply add to sum and replace the las thing done as self
        //else if it's mult or divide subtract the last thing from the total and then readd product, then add product as the last thing done
        //seeing a zero must mean we have to treat the thing as a 0, nothing else is possible. else you recurse with the updated index with all 3 operators. and update the stringbuilder
        //make sure to check for division by 0
        
        List<String> res = new LinkedList();
        dfs(num, 0, target, 0, 0,'+', res, new StringBuilder());
        return res;
    }
    //it reads the number and does the operator to it, then it takes the total ,and the last number and then reads all the possible next number and for each it does all 3 to each
    public void dfs(String num, int index, long target, long total, long lastThing, char operator, List<String> res, StringBuilder building){
        if(index==num.length()){
        	if(total==target&&operator=='*')
        		res.add(building.substring(1, building.length()).toString());
            return;
        }
        int iter = index+1;
        //read as far as possible while not seeing an operator
        while(iter<=num.length()){
            long next = Long.parseLong(num.substring(index, iter));
            
            //now do the operator operation on next from the last total, lastThing values
            long newTotal;
            long newLastThing;
            if(operator=='*'){
                newLastThing = lastThing*next;
                newTotal = total-lastThing+newLastThing;
            }else if(operator=='-'){
                newLastThing = -1*next;
                newTotal=total+newLastThing;
            }else{
                newLastThing = next;
                newTotal=total+newLastThing;
            }
            
            String asString = num.substring(index, iter);
            
            building.append(operator+asString);
            dfs(num, iter, target, newTotal, newLastThing, '+', res, building);
            
            dfs(num, iter, target, newTotal, newLastThing, '-', res, building);
            
            dfs(num, iter, target, newTotal, newLastThing, '*', res, building);
            building.delete(building.length()-(asString.length()+1), building.length());
            if(next==0)
                break;
            iter++;
        }
    }
}