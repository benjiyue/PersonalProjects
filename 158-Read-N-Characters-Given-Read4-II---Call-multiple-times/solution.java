/* The read4 API is defined in the parent class Reader4.
      int read4(char[] buf); */

public class Solution extends Reader4 {
	char[] fromLastTime;
	public int read(char[] buf, int n) {
		if(n==0)
			return 0;
		//the difference from the last implementatino is that i have to save the remainder of what was saw last time and read that before anything else
		int nextPos = 0;
		char[] read = new char[4];
		int howMany;
		if(fromLastTime!=null){
			//just set up next buffer and return here
			if(n<fromLastTime.length){
			    int i = 0;
				for(;i<n;i++)
					buf[nextPos++] = fromLastTime[i];
				setUpNext(i,fromLastTime.length-i,fromLastTime);
				return n;
			}
			//the new range is more than the buffer i have left, so it'll read it all and then some
			else{
				for(int i=0;i<fromLastTime.length;i++)
					buf[nextPos++] = fromLastTime[i];
				fromLastTime = null;
			}

		}

		//inside of here i can read whole chunks, the only thing is that if there's no more to read 
		while(nextPos+4<=n){
			howMany = read4(read);
			for(int i=0;i<howMany;i++)
				buf[nextPos++] = read[i];
			if(howMany<4){
				return nextPos;
			}
		}

		//you need to read less than 4
		howMany = read4(read);
		//you will only put in the minimum between spaces left and the number returned
		int min = Math.min(howMany, n-nextPos);
		for(int i=0;i<min;i++)
			buf[nextPos++] = read[i];
		if(min<howMany){
			/*fromLastTime = new char[howMany-min];
            for(int i=0;i<howMany-min;i++)
                fromLastTime[i] = read[howMany-min-i]*/
			setUpNext(min, howMany-min, read);
		}
		return nextPos;
	}

	public void setUpNext(int start, int howMany, char[] buffer){
		char[] newFromLastTime = new char[howMany];
		for(int i=0;i<howMany;i++)
			newFromLastTime[i] = buffer[start+i];
		fromLastTime = newFromLastTime;
	}
}