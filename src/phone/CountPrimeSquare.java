package phone;
// company WMT lab
//intput 2d array. 
//output：return how many sub-square-matrix which only consist of prime number
public class CountPrimeSquare {
	public int countSqr(int[][] nums){
		if(nums==null||nums.length==0||nums[0].length==0){
			return 0;
		}
		int res=0;
		int[][] maxPrimeLen=new int[nums.length][nums[0].length];
		for(int c=0;c<nums[0].length;c++){
			for(int r=nums.length-1;r>=0;r--){
				int curr=0;
				if(isPrime(nums[r][c])){
					curr=1+(r<nums.length-1?maxPrimeLen[r+1][c]:0);
				}
				maxPrimeLen[r][c]=curr;
			}
		}
		for(int r=0;r<nums.length;r++){
			for(int c=0;c<nums[0].length;c++){
				res=res+findMaxPrimtSquare(nums,maxPrimeLen,r,c);
			}
		}
		return res;
	}
	public int findMaxPrimtSquare(int[][] nums,int[][] maxPrimeLen,int r,int c ){
		int res=0;
		int minHigh=Integer.MAX_VALUE;
		for(int c2=c;c2<nums[0].length;c2++){
			minHigh=Math.min(minHigh, maxPrimeLen[r][c2]);
			int width=c2-c+1;
			if(width<=minHigh){
				res++;
			}
		}
		return res;
	}
	public boolean isPrime(int val){
		if(val<2){
			return false;
		}
		for(int i=2;i<val;i++){
			if(val%i==0){
				return false;
			}
		}
		return true;
	}
}
