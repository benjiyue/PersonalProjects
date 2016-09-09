/* The read4 API is defined in the parent class Reader4.
      int read4(char[] buf); */

public class Solution extends Reader4 {
	char[] read = new char[4];
	int size;
	int nextPosition;
	public int read(char[] buf, int n) {
		int count = 0;
		while(count<n){
			if(nextPosition==0)
				size = read4(read);
			if(size==0)	break;
			while(nextPosition<size&&count<n)
				buf[count++] = read[nextPosition++];
			if(nextPosition==size)
				nextPosition = 0;	
		}
		return count;
	}
}