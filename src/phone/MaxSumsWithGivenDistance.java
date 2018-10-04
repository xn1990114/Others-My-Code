package phone;
import java.util.*;
/*
 * 给一个数组，找到 最大的M个 距离大于L的pair 的sum。A = [ 8, 5, 12, 3, 4 ], L = 2, M = 2, M << A.length
 * 一共有 (8,3), (8,4), (5,4) 三个 pair，M=2，所以返回最大的两个sum。return [12, 11]
 */
// below solution worst case is N^2*log N
// brute force is N^2*log M
public class MaxSumsWithGivenDistance {
	public List<Integer> findMaxSums(int[] nums,int L,int M){
		List<Integer> res=new ArrayList<Integer>();
		if(nums==null||nums.length==0) {
			return res;
		}
		int[][] array=new int[nums.length][2];
		for(int i=0;i<nums.length;i++) {
			array[i][0]=nums[i];
			array[i][1]=i;
		}
		Arrays.sort(array,new Comparator<int[]>() {
			public int compare(int[] i1,int[] i2) {
				return -(i1[0]-i2[0]);
			}
		});
		// index 0 base value, index 1 base index
		// index 2 current moving index in array, index 3 total sum;
		PriorityQueue<int[]> pq=new PriorityQueue<int[]>(new Comparator<int[]>() {
			public int compare(int[] i1,int[] i2) {
				return -(i1[3]-i2[3]);
			}
		});
		for(int i=0;i<array.length-1;i++) {
			pq.offer(new int[] {array[i][0],i,i+1,array[i][0]+array[i+1][0]});
		}
		while(res.size()<M) {
			int[] top=pq.poll();
			int index1=top[1];
			int index2=top[2];
			int diff=array[index1][1]-array[index2][1];
			if(Math.abs(diff)>L) {
				res.add(top[3]);
			}
			index2++;
			if(index2<array.length) {
				pq.offer(new int[] {array[index1][0],index1,index2,array[index1][0]+array[index2][0]});
			}
		}
		return res;
	}
}
