public class Solution {
	public List<String> fullJustify(String[] words, int maxWidth) {
		//try to fit as many words into a line as possible as long as its character length +words already length+nextword is less than the maxWidth. If so continue, else you've reach the end and now need to pad the spaces.There are words-1 spaces and if we divide we get how many each space should get, and the mod number goes to each spot until it's all used up. Now actually make the string put one space between words and the mod+remained-- to each spot
		List<String> res = new LinkedList();
		int wordsLength=0;
		List<String> thisLine = new ArrayList();
		//words: abcd, c, ef
		//spaces = 5
		/*
        wordLength = 4
        thisLine = abcd
        totalSpacesUsed = 4+1-1 = 4
        left = 1
        additionalSpaces = 
        "ab  c"
		 */
		for(int i=0;i<words.length;i++){
			String curWord = words[i];
			if(wordsLength+thisLine.size()+curWord.length()<=maxWidth){
				thisLine.add(curWord);
				wordsLength+=curWord.length();
			}
			else{
				//cannot add this word
				append(thisLine, wordsLength, res, maxWidth, false);
				i--;
				thisLine = new ArrayList();
		        wordsLength = 0;
			}
		}
		//take care of last line
        append(thisLine, wordsLength, res, maxWidth, true);
		return res;
	}
	
	public void append(List<String> thisLine, int wordsLength, List<String> res, int maxWidth, boolean lastLine){
		int totalSpacesUsed = wordsLength+thisLine.size()-1;
		int left = maxWidth-totalSpacesUsed;
		StringBuilder temp = new StringBuilder();
		if(thisLine.size()==1||lastLine){
		    for(int i=0;i<thisLine.size();i++){
		        temp.append(thisLine.get(i));
		        if(i+1!=thisLine.size())
		            temp.append(' ');
		    }
		    while(temp.length()<maxWidth)
		        temp.append(' ');
		}else{
    		int additionalSpacesEach = thisLine.size()-1==0?0:left/(thisLine.size()-1);
    		int justTheFront = thisLine.size()-1==0?0:left%(thisLine.size()-1);
    		for(int j=0;j<thisLine.size();j++){
    			String s = thisLine.get(j);
    			temp.append(s);
    			if(j+1==thisLine.size())
    				break;
    			temp.append(' ');
    			for(int a=0;a<additionalSpacesEach;a++)
    				temp.append(' ');
    			if(justTheFront-->0)
    				temp.append(' ');
    		}
		}
		res.add(temp.toString());
		//rest values
	}
}