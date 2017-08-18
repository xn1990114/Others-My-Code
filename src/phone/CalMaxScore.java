package phone;

import java.util.*;

/*
 * Company: Turn
 * 给一个string和一个function，这个function接受一子串，返回一个得分。问怎样把这个String分成k段，使得总收入最大。并且要返回分段的方法。
 *先dp找最大值再返回去找分段方法。
 */
public class CalMaxScore {
	public List<Integer> findCutWay(String s, int k) {
		int[] max = new int[s.length()];
		List<List<Integer>> path = new ArrayList<List<Integer>>();
		for (int i = 0; i < s.length(); i++) {
			path.add(new ArrayList<Integer>());
			path.get(i).add(i);
			max[i]=calScore(s.substring(0,i+1));
		}
		for (int i = 1; i < k; i++) {
			int[] newMax = new int[s.length()];
			List<List<Integer>> newPath = new ArrayList<List<Integer>>();
			for (int j = 0; j < s.length(); j++) {
				newPath.add(new ArrayList<Integer>());
			}
			for (int currEnd = i ; currEnd < s.length(); currEnd++) {
				int tempMax=-1;
				List<Integer> tempPath=null;
				for(int lastEnd=i-1;lastEnd<=currEnd-1;lastEnd++){
					int tailScore=calScore(s.substring(lastEnd+1,currEnd+1));
					if(tailScore+max[lastEnd]>tempMax){
						tempMax=tailScore+max[lastEnd];
						tempPath=path.get(lastEnd);
					}
				}
				newPath.get(currEnd).addAll(tempPath);
				newPath.get(currEnd).add(currEnd);
				newMax[currEnd]=tempMax;
				
			}
			path=newPath;
			max=newMax;
		}
		
		return path.get(path.size()-1);
	}

	public int calScore(String s) {
		int max = 0;
		int min = 256;
		for (int i = 0; i < s.length(); i++) {
			max = Math.max(max, (int)s.charAt(i));
			min = Math.min(min, (int)s.charAt(i));
		}
		return max - min;
	}
	public void display(List<Integer> list){
		for(int num:list){
			System.out.println(num+"\t");
		}
		System.out.println();
	}
}
