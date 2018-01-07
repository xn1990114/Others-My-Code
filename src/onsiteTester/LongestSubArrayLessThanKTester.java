package onsiteTester;

import static org.junit.Assert.*;

import org.junit.Test;

import onsite.LongestSubArrayLessThanK;

public class LongestSubArrayLessThanKTester {
	@Test
	public void test1() {
		LongestSubArrayLessThanK tester=new LongestSubArrayLessThanK();
		int[] nums={-1,-5,7,-2,-10};
		int k=-5;
		int r=5;
		assertTrue(tester.findLength(nums, k)==r);
	}
	@Test
	public void test2() {
		LongestSubArrayLessThanK tester=new LongestSubArrayLessThanK();
		int[] nums={-1,5,7,-2,7};
		int k=4;
		int r=2;
		assertTrue(tester.findLength(nums, k)==r);
	}
	@Test
	public void test3() {
		LongestSubArrayLessThanK tester=new LongestSubArrayLessThanK();
		int[] nums={5,6,2,7,-10,6,2};
		int k=7;
		int r=5;
		assertTrue(tester.findLength(nums, k)==r);
	}
	@Test
	public void test4() {
		LongestSubArrayLessThanK tester=new LongestSubArrayLessThanK();
		int[] nums={5,6,2,7,-10,6,2};
		int k=5;
		int r=4;
		assertTrue(tester.findLength(nums, k)==r);
	}
	@Test
	public void test5() {
		LongestSubArrayLessThanK tester=new LongestSubArrayLessThanK();
		int[] nums={};
		int k=5;
		int r=0;
		assertTrue(tester.findLength(nums, k)==r);
	}
	@Test
	public void test6() {
		LongestSubArrayLessThanK tester=new LongestSubArrayLessThanK();
		int[] nums={6,5,3,7,8,-6};
		int k=2;
		int r=1;
		assertTrue(tester.findLength(nums, k)==r);
	}
	@Test
	public void test7() {
		LongestSubArrayLessThanK tester=new LongestSubArrayLessThanK();
		int[] nums={6,5,3,7,8,6};
		int k=2;
		int r=0;
		assertTrue(tester.findLength(nums, k)==r);
	}
}
