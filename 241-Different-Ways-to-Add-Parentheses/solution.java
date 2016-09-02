public class Solution {
    Map<String, List<Integer>> map;
	public List<Integer> diffWaysToCompute(String input) {
		if(input==null||input.length()==0)
			return new LinkedList();
        map = new HashMap();
		return divide(input, 0, input.length()-1);

	}

	public List<Integer> divide(String in, int begin, int end){
		List<Integer> res = new LinkedList();
		String key = begin+","+end;
		
		if(map.containsKey(key))
		    return map.get(key);
		    
	    if(isDigit(in, begin, end)){
			res.add(Integer.parseInt(in.substring(begin, end+1)));
			map.put(key, res);
			return res;
		}
		
		for(int i=begin;i<=end;i++){
			char c =in.charAt(i);
			if(!Character.isDigit(c)){
				List<Integer> left = divide(in, begin, i-1);
				List<Integer> right = divide(in, i+1, end);
				for(Integer l:left){
					for(Integer r:right){
						if(c=='*')
							res.add(l*r);
						else if(c=='+')
							res.add(l+r);
						else
							res.add(l-r);
					}
				}
			}
		}
		map.put(key, res);
		return res;
	}
	
	public boolean isDigit(String in, int begin, int end){
	    for(int i=begin;i<=end;i++){
	        char c = in.charAt(i);
	        if(c=='+'||c=='*'||c=='-')
	            return false;
	    }
	    return true;
	}
}