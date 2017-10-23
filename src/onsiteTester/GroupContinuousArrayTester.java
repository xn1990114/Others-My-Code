package onsiteTester;

import org.junit.Test;

import onsite.GroupContinuousArray;

public class GroupContinuousArrayTester {

	@Test
	public void test() {
		GroupContinuousArray tester=new GroupContinuousArray();
		int[] num1={8,2,4,7,1,0,3,6};
		tester.display(tester.group(num1));
		System.out.println();
		int[] num2={3,-6,-2,-5,8,-4,5,-9,2,7,0};
		tester.display(tester.group(num2));
	}

}
