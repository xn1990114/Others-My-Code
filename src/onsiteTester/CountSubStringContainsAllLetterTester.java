package onsiteTester;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import onsite.CountSubStringContainsAllLetter;

public class CountSubStringContainsAllLetterTester {

	@Test
	public void test1() {
		CountSubStringContainsAllLetter tester=new CountSubStringContainsAllLetter();
		assertTrue(tester.countSubStrings("asaab", 2)==6);
	}
	@Test
	public void test2() {
		CountSubStringContainsAllLetter tester=new CountSubStringContainsAllLetter();
		assertTrue(tester.countSubStrings("aeaab", 2)==9);
	}
	@Test
	public void test3() {
		CountSubStringContainsAllLetter tester=new CountSubStringContainsAllLetter();
		assertTrue(tester.countSubStrings("asacab", 2)==0);
	}
	@Test
	public void test4() {
		CountSubStringContainsAllLetter tester=new CountSubStringContainsAllLetter();
		assertTrue(tester.countSubStrings("asb", 0)==8);
	}
	@Test
	public void test5() {
		CountSubStringContainsAllLetter tester=new CountSubStringContainsAllLetter();
		assertTrue(tester.countSubStrings("asaabi", 2)==9);
	}
	@Test
	public void test6() {
		CountSubStringContainsAllLetter tester=new CountSubStringContainsAllLetter();
		assertTrue(tester.countSubStrings("asaabi", 1)==6+4+4+3+1+1);
	}
	@Test
	public void test7() {
		CountSubStringContainsAllLetter tester=new CountSubStringContainsAllLetter();
		assertTrue(tester.countSubStrings("asaai", 3)==3);
	}
}
