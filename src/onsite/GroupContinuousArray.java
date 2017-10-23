package onsite;
import java.util.*;
/*
 * Company: APPDynamics
 * Divide a list of numbers (no duplicates) into groups of consecutive numbers
 *Maintain the original order
 *Example: 8,2,4,7,1,0,3,6;
 *Output: [[2,4,1,0,3], [8,7,6]])
 */
public class GroupContinuousArray {
	public List<List<Integer>> group(int[] nums){
		List<List<Integer>> res=new ArrayList<List<Integer>>();
		if(nums.length==0){
			return res;
		}
		int min=Integer.MAX_VALUE;
		TreeMap<Integer,Integer> lToH=new TreeMap<Integer,Integer>();
        Map<Integer,Integer> hToL=new HashMap<Integer,Integer>();
        for(int i=0;i<nums.length;i++){
            int curr=nums[i];
            if(lToH.containsKey(curr)){
                continue;
            }
            lToH.put(curr,curr);
            hToL.put(curr,curr);
            int low=curr;
            int high=curr;
            if(lToH.containsKey(curr+1)){
                high=lToH.get(curr+1);
            }
            if(hToL.containsKey(curr-1)){
                low=hToL.get(curr-1);
            }
            lToH.put(low,high);
            hToL.put(high,low);
            min=Math.min(min, curr);
        }
        TreeMap<Integer,List<Integer>> ts=new TreeMap<Integer,List<Integer>>();
        Iterator<Integer> it=lToH.keySet().iterator();
        long last=Integer.MIN_VALUE-1L;
        while(it.hasNext()){
        	int curr=it.next();
        	if(curr==last+1){
        		last=curr;
        		continue;
        	}
        	else{
        		ts.put(curr, new ArrayList<Integer>());
        		last=curr;
        	}
        }
        for(int i=0;i<nums.length;i++){
        	int pre=ts.floorKey(nums[i]);
        	ts.get(pre).add(nums[i]);
        }
        for(int key:ts.keySet()){
        	res.add(ts.get(key));
        }
		return res;
	}
	public void display(List<List<Integer>> list){
		for(List<Integer> l:list){
			for(int num:l){
				System.out.print(num+",");
			}
			System.out.println();
		}
	}
}
