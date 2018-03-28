package onsiteTester;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import onsite.RankOfPermutation;

public class RankOfPermutationTester {

	@Test
	public void test1() {
		RankOfPermutation tester=new RankOfPermutation();
		String s="bac";
		assertTrue(tester.findRank(s)==3);
	}
	@Test
	public void test2() {
		// 5*4*3*2*1   120*2 240
		//2*4*3*2*1                  48
		//2*3*2*1					12
		//2*2						4
		//
		RankOfPermutation tester=new RankOfPermutation();
		String s="cdefab";
		System.out.println(tester.findRank(s));
		assertTrue(tester.findRank(s)==305);
	}
	@Test
	public void test3() {
		RankOfPermutation tester=new RankOfPermutation();
		String s="";
		assertTrue(tester.findRank(s)==1);
	}
}
