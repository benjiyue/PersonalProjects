public class Solution {
    
    class Obj{
		String s;
		int pos;
		public Obj(String in, int index){
			s = in;
			pos = index;
		}
	}
    
	public List<String> removeInvalidParentheses(String orig) {
	    if (isValid(orig))
	        return Collections.singletonList(orig);
		List<String> res = new LinkedList();
		if(orig==null||orig.length()==0)
			return res;
		Queue<Obj> queue= new LinkedList<Obj>();
		queue.add(new Obj(orig, 0));
		boolean alreadyFoundValid = false;
		while(!queue.isEmpty()){
			Obj cur = queue.remove();
			for(int i=cur.pos;i<cur.s.length();i++){
				char c = cur.s.charAt(i);
				if(c!=')'&&c!='(')	continue;
				//select the first from a sequence, either im the first so i have to select myself if im a (or)
				//or I am iterating and the thing directly in front of me is the same thing as me
				if(i!=cur.pos&&c==cur.s.charAt(i-1))	continue;

				//mking it here means im a ( or ) and the thing before me is not me
				String next = cur.s.substring(0,i)+cur.s.substring(i+1);
				if(isValid(next)){
					res.add(next);
				}
				else if(res.isEmpty()){
					queue.add(new Obj(next, i));
				}
			}
		}
		return res;
	}
	
	public boolean isValid(String s){
		int count =0;
		for(int i=0;i<s.length();i++){
			char c = s.charAt(i);
			if(c=='(')
				count++;
			else if(c==')')
				count--;
			if(count<0)
				return false;
		}
		return count==0;
	}
}