package onsite;
import java.util.*;
/*
 * Company: next capital OA
 * 
 * 输入一个 int pathLen 代表这段路有多长，比如 9，代表这段路有 9个units这么长
 * （刻度应该就是0，1，2，3，4，5，6，7，8，9，记不太清了)。 
 * 第二个输入是int[n][2] 。代表有n个花匠，每个花匠在[b,e)这个区间上种花，比如{{3, 5}, {1, 9}}, 
 * 代表有两个花匠，第一个在[3, 5)上种花，第二个在[1, 9)上种花，每个units最多只能允许三个花匠种花。
 * 求最多能有多少个花匠 能种花。
 */
public class PlantFlower {
	public int findMaxWorker(int pathLen,int[][] workers){
		Arrays.sort(workers,new Comparator<int[]>(){
			public int compare(int[] i1,int[] i2){
				return i1[0]-i2[0];
			}
		});
		PriorityQueue<int[]> pq=new PriorityQueue<int[]>(new Comparator<int[]>(){
			public int compare(int[] i1,int[] i2){
				return i2[1]-i1[1];
			}
		});
		int[] count=new int[pathLen+2];
		for(int i=0;i<workers.length;i++){
			int[] curr=workers[i];
			if(pq.isEmpty()||countMax(count,curr[0],curr[1])<3){
				pq.offer(new int[]{curr[0],curr[1]});
				count[curr[0]]++;
				count[curr[1]]--;
			}
			else{
				int[] toCompare=pq.peek();
				if(toCompare[1]>curr[1]){
					pq.poll();
					count[toCompare[0]]--;
					count[toCompare[1]]++;
					pq.offer(new int[]{curr[0],curr[1]});
					count[curr[0]]++;
					count[curr[1]]--;
				}
			}
		}
		return pq.size();
	}
	public int countMax(int[] count,int start,int end){
		int max=0;
		int curr=0;
		for(int i=0;i<end;i++){
			curr=curr+count[i];
			if(i>=start){
				max=Math.max(max, curr);
			}
		}
		return max;
	}
}
