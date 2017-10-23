package phone;
import java.util.*;
/*
 * Company: Rubrik
 * Quenstion 1: 找所有local maximum，array满足两个条件
 * 1. |a[i] - a[i-1]| = 1
 * 2. The local maxima are sparse
 * 1 2 3 4 5 6 7 8 7 6 5 4 3 4 5 6 7 6 5 => [8 7]  
 * 类似binary search，给了hint才做出来的。比较abs(arr[left]-arr[right])是不是等于right - left, 来判断中间是不是有local maximum。
 * 要注意boundary，楼主就忘记了，然后interviewer问才加的。。。
 */
public class FindLocalMax {
	public List<Integer> findMax(int[] nums){
		List<Integer> res=new ArrayList<Integer>();
		binaryFind(nums,0,nums.length-1,res);
		return res;
	}
	public void binaryFind(int[] nums, int start,int end,List<Integer> res){
		if(start>end){
			return;
		}
		if((start==0||nums[start-1]<nums[start])&&(start==nums.length-1||nums[start]>nums[start+1])){
			res.add(nums[start]);
		}
		if(start!=end&&(end==0||nums[end-1]<nums[end])&&(end==nums.length-1||nums[end]>nums[end+1])){
			res.add(nums[end]);
		}
		if(Math.abs(start-end)==Math.abs(nums[start]-nums[end])){
			return;
		}
		int mid=start+(end-start)/2;
		binaryFind(nums,start+1,mid,res);
		binaryFind(nums,mid+1,end-1,res);
	}
}
