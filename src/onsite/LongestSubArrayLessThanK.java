package onsite;
import java.util.*;
/*
 * company: coursera oa
 * 给一组数和一个数k，找到最长的sub array，array里的数加起来小于等于k
 */
public class LongestSubArrayLessThanK {
	public int findLength(int[] nums,int k){
		TreeMap<Integer,Integer> tm=new TreeMap<Integer,Integer>();
		int res=0;
		tm.put(0, -1);
		int total=0;
		for(int i=0;i<nums.length;i++){
			total=total+nums[i];
			Integer ceil=tm.ceilingKey(total-k);
			if(ceil!=null){
				res=Math.max(res, i-tm.get(ceil));
			}
			if(total>tm.lastKey()){
				tm.put(total, i);
			}
		}
		return res;
	}
}
