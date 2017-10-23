package onsiteTester;

import static org.junit.Assert.*;

import org.junit.Test;

import onsite.MaxScore;

public class MaxScoreTester {

	@Test
	public void test() {
		MaxScore tester=new MaxScore();
		int[] nums1={1, 2, 2, 1, 3, 3};
		assertTrue(tester.calMaxScore(nums1)==8);
		int[] nums2={1, 2, 2, 1, 3, 3,2,2,2};
		assertTrue(tester.calMaxScore(nums2)==10);
	}

}
