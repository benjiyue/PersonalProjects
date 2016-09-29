public class Solution {
	public String intToRoman(int integer) {
		/*
        map all the numbers then try subtracting the largest number if after subtraction the difference still about 0, then add it to res, else try the current thing minus next smallest and see if that's above 0 if so subtract the smaller->bigger then move on. else move on

        but for the 5's and things those cannot ever be subtracted so ignore those and get the next, we can write a if statement to skip those wheen looking
		 */

		List<Integer> num = new ArrayList();
		List<Character> roman = new ArrayList();
		num.add(1000);roman.add('M');
		num.add(500);roman.add('D');
		num.add(100);roman.add('C');
		num.add(50);roman.add('L');
		num.add(10);roman.add('X');
		num.add(5);roman.add('V');
		num.add(1);roman.add('I');

		StringBuilder res = new StringBuilder();
		for(int i=0;i<num.size();i++){
			//subtract it
			while(num.get(i)<=integer){
				res.append(roman.get(i));
				integer-=num.get(i);
			}
			if(i!=num.size()-1){
				int nextSmaller = num.get(i+1);
				int nextIndex = i+1;
				if(nextSmaller==500){
					nextSmaller = 100;
					nextIndex = i+2;
				}
				if(nextSmaller==50){
					nextSmaller = 10;
					nextIndex = i+2;
				}
				if(nextSmaller==5){
					nextSmaller = 1;
					nextIndex = i+2;
				}
				int inverse = num.get(i)-nextSmaller;
				if(integer>=inverse){
					res.append(roman.get(nextIndex));
					res.append(roman.get(i));
					integer-=inverse;
				}
			}
		}
		return res.toString();
	}
}