package onsite;
import java.util.*;
/*
 * Company IXL learning
 * Given a binary tree, 
 * convert it into a binary search tree which has the exaclty same shape as the original 
 * binary tree
 */
public class BinaryTreeToBST {
	public class TreeNode {
		public int val;
		public TreeNode left;
		public TreeNode right;
		public TreeNode(int val){
			this.val=val;
		}
	}
	public void convertToBST(TreeNode root){
		List<Integer> list=new ArrayList<Integer>();
		inorderTra(root,false,list);
		Collections.sort(list);
		inorderTra(root,true,list);
	}
	public void inorderTra(TreeNode root,boolean updateTree,List<Integer> list){
		TreeNode curr=root;
		int index=0;
		while(curr!=null){
			if(curr.left==null){
				if(updateTree){
					curr.val=list.get(index);
					index++;
				}
				else{
					list.add(curr.val);
				}
				curr=curr.right;
			}
			else{
				TreeNode l=curr.left;
				while(l.right!=null&&l.right!=curr){
					l=l.right;
				}
				if(l.right==null){
					l.right=curr;
					curr=curr.left;
				}
				else{
					l.right=null;
					if(updateTree){
						curr.val=list.get(index);
						index++;
					}
					else{
						list.add(curr.val);
					}
					curr=curr.right;
				}
			}
		}
	}
	public void displayTree(TreeNode root){
		Queue<TreeNode> qu=new LinkedList<TreeNode>();
		qu.offer(root);
		while(!qu.isEmpty()){
			int size=qu.size();
			for(int i=0;i<size;i++){
				TreeNode top=qu.poll();
				if(top==null){
					System.out.print("null,");
				}
				else{
					System.out.print(top.val+",");
					qu.offer(top.left);
					qu.offer(top.right);
				}
			}
			System.out.println();
		}
	}
}
