package phone;
import java.util.*;
/*
 * Suppose we are given N different types of stickers. 
 * Each sticker type has a word on it, for example, 
 * we could have 4 sticker types that say “math”, “science”, “english”, and “history” respectively. 
 * You would like to spell out the target word “learning” by cutting out individual letters from 
 * your collection of stickers and rearranging them. 
 * If you are allowed to use more than one sticker of a given type to form the target word, 
 * what is the minimum number of total stickers you will require? In the example above,
 * one possible optimal solution is to use 1 “math” sticker, 2 “english” stickers, 
 * and 1 “history” sticker, for a total of 4 stickers.
 */
public class AssembleStrings {
	public int findMinStickersRequired(String target,String[] dic){
		Set<String> strs=new HashSet<String>();
		List<int[]> dics=new ArrayList<int[]>();
		
		for(int i=0;i<dic.length;i++){
			char[] temp=dic[i].toCharArray();
			Arrays.sort(temp);
			strs.add(String.valueOf(temp));
		}
		
		int[] targetCount=new int[256];
		int needed=0;
		for(int i=0;i<target.length();i++){
			targetCount[target.charAt(i)]++;
		}
		for(int i=0;i<256;i++){
			if(targetCount[i]>0){
				needed++;
			}
		}
		for(String s:strs){
			int[] count=new int[256];
			for(int i=0;i<s.length();i++){
				count[s.charAt(i)]++;
			}
			dics.add(count);
		}
		
		int[] min={Integer.MAX_VALUE};
		findMinPath(targetCount,needed,dics,0,new int[256],0,min);
		return min[0]==Integer.MAX_VALUE?-1:min[0];
	}

	private void findMinPath(int[] targetCount, int needed, List<int[]> dics, int index, int[] currCount,int used,int[] min) {
		if(needed==0){
			min[0]=Math.min(min[0], used);
			return;
		}
		if(index==dics.size()){
			return;
		}
		for(int i=index;i<dics.size();i++){
			if(canContinue(targetCount,currCount,dics.get(i))){
				int[] temp=new int[256];
				int tempneed=needed;
				for(int j=0;j<256;j++){
					temp[j]=dics.get(i)[j]+currCount[j];
					if(currCount[j]<targetCount[j]&&temp[j]>=targetCount[j]){
						tempneed--;
					}
				}
				findMinPath(targetCount,tempneed,dics,i,temp,used+1,min);
			}
		}
	}
	public boolean canContinue(int[] targetCount,int[] currCount,int[] curr){
		for(int i=0;i<curr.length;i++){
			if(curr[i]>0&&currCount[i]<targetCount[i]){
				return true;
			}
		}
		return false;
	}
}
