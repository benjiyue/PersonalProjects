public class Solution {
    public String simplifyPath(String path) {

        Deque<String> stack = new LinkedList();
        int iter = 0;
        //look for the first non / character
        
        while(iter<path.length()){
            
            //look for the first non / character and that's you anchor
            while(iter<path.length()&&path.charAt(iter)=='/')
        	    iter++;
            if(iter==path.length())
                break;
            //iter is pointing to an actual character
            int i = iter+1;
            
            //keep going till you hit another /
            while(i<path.length()&&path.charAt(i)!='/')
                i++;
                
            //read the in between
            String substr = path.substring(iter, i);
            if(substr.equals("")||substr.equals(".")||substr.equals("/")){
                
            }else if(substr.equals("..")){
                stack.pollLast();
            }else{
                stack.add(substr);
            }
            iter = i+1;
        }
        StringBuilder res = new StringBuilder();
        while(!stack.isEmpty()){
            res.append("/"+stack.removeFirst());
        }
        if(res.length()==0)
            res.append("/");
        return res.toString();
    }
}