package onsite;
/*
 * 给一个string s, 找出所有包含超过连续n个元音字母（a, e, i, o, u）的substring的个数，
 * 比如(“asaab” n = 2) ->"aa", "saa", "asaa", "aab", "saab, "asaab" -> output = 6
 */
public class CountSubStringContainsAllLetter {
	public int countSubStrings(String s,int n){
		if(n==0){
			return (int)Math.pow(2, s.length());
		}
		int res=0;
		int end=0;
		int lastCount=0;
		for(int start=0;start<s.length();start++){
			while(end<s.length()&&lastCount<n){
				if(isCorrectChar(s.charAt(end))){
					lastCount++;
				}
				else{
					lastCount=0;
				}
				end++;
			}
			if(lastCount==n){
				res=res+s.length()-end+1;
			}
			if(end-start==lastCount){
				lastCount--;
			}
		}
		return res;
	}
	public boolean isCorrectChar(char ch){
		return ch=='a'||ch=='e'||ch=='i'||ch=='o'||ch=='u';
	}
}
