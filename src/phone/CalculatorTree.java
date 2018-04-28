package phone;

import java.util.*;

/*
 * company: xcalar
 * 输入string "(3*(5-4))+((-6)/2)"
转化成一个tree
输出
             +
     *                /
3        -        -       2
       5   4       6
 */
public class CalculatorTree {
	public class TreeNode{
		String val;
		TreeNode left;
		TreeNode right;
		public TreeNode(String val){
			this.val=val;
		}
	}
	public TreeNode makeCalculatorTree(String s){
		if(s==null||s.length()==0){
			return null;
		}
		List<TreeNode> currNodes=new ArrayList<TreeNode>();
		Stack<List<TreeNode>> layers=new Stack<List<TreeNode>>();
		int index=0;
		while(index<s.length()){
			char ch=s.charAt(index);
			if(Character.isDigit(ch)){
				int start=index;
				while(index<s.length()&&Character.isDigit(s.charAt(index))){
					index++;
				}
				TreeNode toadd=new TreeNode(s.substring(start,index));
				currNodes.add(toadd);
			}
			else if(ch=='('){
				layers.push(currNodes);
				currNodes=new ArrayList<TreeNode>();
				index++;
			}
			else if(ch==')'){
				TreeNode root=makeTree(currNodes);
				currNodes=layers.pop();
				currNodes.add(root);
				index++;
			}
			else{
				TreeNode toadd=new TreeNode(s.substring(index,index+1));
				currNodes.add(toadd);
				index++;
			}
		}
		return makeTree(currNodes);
	}
	public TreeNode makeTree(List<TreeNode> list){
		if(list.isEmpty()){
			return null;
		}
		if(list.size()==1){
			return list.get(0);
		}
		if(list.size()==2){
			list.get(0).right=list.get(1);
			return list.get(0);
		}
		list.get(1).left=list.get(0);
		list.get(1).right=list.get(2);
		return list.get(1);
	}
	public String printTree(TreeNode curr){
		if(curr==null){
			return "";
		}
		StringBuilder sb=new StringBuilder();
		if(curr.left!=null&&!Character.isDigit((curr.left.val.charAt(0)))){
			sb.append('(');
			sb.append(printTree(curr.left));
			sb.append(')');
		}
		else {
			sb.append(printTree(curr.left));
		}
		sb.append(curr.val);
		if(curr.right!=null&&!Character.isDigit((curr.right.val.charAt(0)))){
			sb.append('(');
			sb.append(printTree(curr.right));
			sb.append(')');
		}
		else {
			sb.append(printTree(curr.right));
		}
		return sb.toString();
	}
}
