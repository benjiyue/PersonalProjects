public class Solution {
	public int compareVersion(String version1, String version2) {
		//split then compare as for as needed until on number is greater than the other 

		String[] a = version1.split("\\.");
		String[] b = version2.split("\\.");
		int iter = 0;
		while(iter<a.length&&iter<b.length){
			int first = Integer.parseInt(a[iter]);
			int second = Integer.parseInt(b[iter]);
			if(first!=second)
				return first-second<0?-1:1;
			else{
				iter++;
			}
		}
		while(iter<b.length){
		    if(Integer.parseInt(b[iter++])>0)
		        return -1;
		}
		while(iter<a.length){
		    if(Integer.parseInt(a[iter++])>0)
		        return 1;
		}
		return 0;
	}
}