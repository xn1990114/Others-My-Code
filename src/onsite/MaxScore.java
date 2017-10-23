package onsite;
import java.util.*;
/*
 * 给一数组，例如[1, 2, 2, 1, 3, 3]，当取出一个数Ai时，可以得到Ai * count(Ai), 同时Ai + 1, Ai - 1, 不能再被选，
 * 如取出1时，可以得到 1 * 2, 但是2和3都不能在选，求能得到的最大的值
 */
		
public class MaxScore {
	public int calMaxScore(int[] nums){
		if(nums.length==0){
			return 0;
		}
		Map<Integer,Integer> map=new HashMap<Integer,Integer>();
		for(int i=0;i<nums.length;i++){
			if(!map.containsKey(nums[i])){
				map.put(nums[i], 0);
			}
			map.put(nums[i], map.get(nums[i])+1);
		}
		List<Integer> keys=new ArrayList<Integer>(map.keySet());
		Collections.sort(keys);
		int last1=0;
		int last2=0;
		for(int i=0;i<keys.size();i++){
			int curr=last1;
			if(i>0&&keys.get(i-1)!=keys.get(i)-1){
				curr=Math.max(curr, last1+keys.get(i)*map.get(keys.get(i)));
			}
			else{
				curr=Math.max(curr, last2+keys.get(i)*map.get(keys.get(i)));
			}
			last2=last1;
			last1=curr;
		}
		return last1;
	}
}
