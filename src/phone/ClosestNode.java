package phone;

import onsite.BinaryTreeToBST.TreeNode;

/*
 * Company: databricks
 * Given a node target and the root of a tree, 
 * please find the closest leaf Node to target in the tree.
 */
public class ClosestNode {
	public class TreeNode {
		public int val;
		public TreeNode left;
		public TreeNode right;
		public TreeNode(int val){
			this.val=val;
		}
	}
	class Element{
		TreeNode node;
		int dis;
		public Element(TreeNode node,int dis){
			this.node=node;
			this.dis=dis;
		}
	}
	public TreeNode findClosest(TreeNode root,TreeNode target){
		if(root==null||target==null){
			return null;
		}
		Element res=new Element(null,Integer.MAX_VALUE-1);
		search(root,target,res);
		return res.node;
	}
	public Element search(TreeNode curr,TreeNode target,Element res){
		if(curr==null){
			return new Element(null,Integer.MAX_VALUE-1);
		}
		if(curr.left==null&&curr.right==null){
			return new Element(curr,0);
		}
		Element l=search(curr.left,target,res);
		l.dis++;
		Element r=search(curr.right,target,res);
		r.dis++;
		if(curr==target){
			if(l.dis<res.dis){
				res.node=l.node;
				res.dis=l.dis;
			}
			if(r.dis<res.dis){
				res.node=r.node;
				res.dis=r.dis;
			}
			return new Element(curr,0);
		}
		else if((l.node==target||r.node==target)&&l.node!=null&&r.node!=null){
			int totaldis=l.dis+r.dis;
			if(totaldis<res.dis){
				res.dis=totaldis;
				res.node=l.node==target?r.node:l.node;
			}
			return l.node==target?l:r;
		}
		if(l.dis<r.dis){
			return l;
		}
		return r;
	}
}
