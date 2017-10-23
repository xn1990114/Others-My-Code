package phone;
import java.util.*;

/*
 * Company: databricks
 * Traverse a binary tree with O(1) memory. Each node has left, right, parent pointers.
 */
public class TranverseCustomizedTree {
	public class TreeNode {
		public int val;
		public TreeNode left;
		public TreeNode right;
		public TreeNode parent;
		public TreeNode(int val){
			this.val=val;
		}
	}
	public List<Integer> tranverseTree(TreeNode root){
		List<Integer> res=new ArrayList<Integer>();
		TreeNode last=null;
		TreeNode curr=root;
		while(curr!=null){
			if(last==null||last==curr.parent){
				res.add(curr.val);
				last=curr;
				if(curr.left!=null){
					curr=curr.left;
				}
				else if(curr.right!=null){
					curr=curr.right;
				}
				else{
					curr=curr.parent;
				}
			}
			else if(last==curr.left){
				last=curr;
				if(curr.right!=null){
					curr=curr.right;
				}
				else{
					curr=curr.parent;
				}
			}
			else if(last==curr.right){
				last=curr;
				curr=curr.parent;
			}
		}
		return res;
	}
}
