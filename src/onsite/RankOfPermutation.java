package onsite;
/*
 * 给一个字符串，问这个字符串在组成字母的全排列里面排第几个，
 * 比如给出字符串cdefab，问其在abcdef的全排列里面的位置（按照字典顺序排列）
 */
// assuming no duplicate
public class RankOfPermutation {
	public int findRank(String s){
		int res=0;
		boolean[] count=new boolean[256];
		for(int i=0;i<s.length();i++){
			count[s.charAt(i)]=true;
		}
		for(int i=0;i<s.length();i++){
			int countSmall=countSmaller(count,s.charAt(i));
			res=res+countSmall*calFactorial(s.length()-i-1);
		}
		return res+1;
	}
	public int calFactorial(int n){
		int res=1;
		for(int i=1;i<=n;i++){
			res=res*i;
		}
		return res;
	}
	public int countSmaller(boolean[] count,char ch){
		count[ch]=false;
		int res=0;
		for(int i=0;i<ch;i++){
			if(count[i]){
				res++;
			}
		}
		return res;
	}
}
