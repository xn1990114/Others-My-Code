package phoneTester;

import java.util.List;

import org.junit.Test;

import phone.TranverseCustomizedTree;
import phone.TranverseCustomizedTree.TreeNode;
/*
 * 						1
 * 			2						7
 * 	3				4					8
 * 				5					  9   10
 * 				  6
 * 
 * 
 * 
 * 
 */
public class TranverseCustomizedTreeTester {

	@Test
	public void test() {
		TranverseCustomizedTree tester=new TranverseCustomizedTree();
		TreeNode n1=tester.new TreeNode(1);TreeNode n2=tester.new TreeNode(2);
		TreeNode n3=tester.new TreeNode(3);TreeNode n4=tester.new TreeNode(4);
		TreeNode n5=tester.new TreeNode(5);TreeNode n6=tester.new TreeNode(6);
		TreeNode n7=tester.new TreeNode(7);TreeNode n8=tester.new TreeNode(8);
		TreeNode n9=tester.new TreeNode(9);TreeNode n10=tester.new TreeNode(10);
		n1.left=n2;n1.right=n7;n2.left=n3;n2.right=n4;n4.left=n5;n5.right=n6;n7.right=n8;
		n8.left=n9;n8.right=n10;n2.parent=n1;n3.parent=n2;n4.parent=n2;n5.parent=n4;
		n6.parent=n5;n7.parent=n1;n8.parent=n7;n9.parent=n8;n10.parent=n8;
		List<Integer> r1=tester.tranverseTree(n1);
		for(int num:r1){
			System.out.print(num+" ");
		}
	}

}
