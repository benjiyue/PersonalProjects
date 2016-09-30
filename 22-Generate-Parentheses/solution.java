public class Solution {
    public List<String> generateParenthesis(int n) {
        /*
        backtracking and we keep track of number of open and close paren left. at each step if there is a ( we can always add all until enhaustion, else keep addding ) until it matches the number of ( left
        */
        List<String> res = new LinkedList();
        gen(0,0,n,new StringBuilder(),res);
        return res;
        
    }
    
    public void gen(int usedOpen, int usedClose, int max, StringBuilder building, List<String> res){
        if(usedOpen==max&&usedClose==max){
            res.add(building.toString());
            return;
        }
        if(usedOpen==usedClose){
            building.append('(');
            gen(usedOpen+1, usedClose, max, building, res);
            building.deleteCharAt(building.length()-1);
        }else{
            if(usedOpen!=max){
                building.append('(');
                gen(usedOpen+1, usedClose, max, building, res);
                building.deleteCharAt(building.length()-1);
            }
            
            building.append(')');
            gen(usedOpen, usedClose+1, max, building, res);
            building.deleteCharAt(building.length()-1);
        }
        
    }
}