package phone;
/*
 * 给一个数组A代表糊墙的形状，就是挨在一起的n个矩形，第i个高度为A，宽为1，然后横着刷墙，每一笔宽度为1，
 * 问最少要多少笔？
e.g.
[1,3,2,3,2]->横着4笔
   1   1
   1 1 1 1
 1 1 1 1 1
[1,1,1,1]->1
[5,8]->8
要求：时间和空间复杂度不大于O(N)
 */
public class PaintWall {
	public int brushNeeded(int[] walls){
		int res=0;
		int preHeight=0;
		for(int i=0;i<walls.length;i++){
			int currHeight=walls[i];
			res=res+Math.max(0, currHeight-preHeight);;
			preHeight=currHeight;
		}
		return res;
	}
}
