public class Solution {
	//idea is to break down a word into its component positions then get the number for that 000 position and then go down to the next position
	private final String[] lessThan20 = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
	private final String[] tens = {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
	private final String[] position = {"", "Thousand", "Million", "Billion"};

	public String numberToWords(int num) {
		if(num==0)
			return "Zero";
		StringBuilder res = new StringBuilder();
		if(num<20)
			return lessThan20[num];
		//always insert to front
		int position = 0;
		while(num>0){
			int subset = num%1000;
			if(subset>0){
				res.insert(0, getNum(subset)+this.position[position]+" ");
			}
			num/=1000;
			position++;
		}
		return res.toString().trim();
	}

	public String getNum(int num){
		if(num==0)
			return "";
		StringBuilder thisNum = new StringBuilder();
		if(num<20)
			thisNum.append(lessThan20[num]+" ");
		else if(num<100){
			int tens = num/10;
			thisNum.append(this.tens[tens]+" ");
			thisNum.append(getNum(num%10));
		}else{//<1000
			int hundredVal = num/100;
			thisNum.append(lessThan20[hundredVal]+" Hundred ");
			thisNum.append(getNum(num%100));
		}
		return thisNum.toString();
	}
}