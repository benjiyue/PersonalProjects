public class Solution {
	public String fractionToDecimal(int num, int den) {
		long numerator = num;
		long denominator = den;

		boolean isNeg = false;
		if(numerator<0){
			isNeg^=true;
			numerator = numerator*-1;}
		if(denominator<0){   
			isNeg^=true;
			denominator = denominator*-1;
		}

		StringBuilder res = new StringBuilder();

		Map<String, Integer> map = new HashMap();

		if(numerator/denominator>0){
			res.append(numerator/denominator);
			numerator%=denominator;
		}else
			res.append("0");

		boolean firstTime = true;
		while(numerator!=0){
			if(firstTime){
				res.append(".");
				firstTime=  false;
			}
			numerator*=10;

			if(map.containsKey(numerator+","+denominator)){
				res.insert(map.get(numerator+","+denominator),"(");
				res.append(")");
				break;
			}
			map.put(numerator+","+denominator, res.length());

			res.append(numerator/denominator);
			numerator%=denominator;
		}
		if(isNeg&&!res.toString().equals("0")){
			res.insert(0, "-");
		}
		return res.toString();
	}
}