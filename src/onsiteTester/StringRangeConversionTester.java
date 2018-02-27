package onsiteTester;

import static org.junit.Assert.*;

import org.junit.Test;

import onsite.StringRangeConversion;

public class StringRangeConversionTester {
//abcdefghijklmnopqrstuvwxyz
	@Test
	public void test1() {
		StringRangeConversion tester=new StringRangeConversion();
		String s="abcdeerf";
		String[][] ops={{"4","7","L"},
						{"4","7","L"}};
		String r="abcdccpd";
		assertTrue(tester.convertString(s, ops).equals(r));
	}
	@Test
	public void test2() {
		StringRangeConversion tester=new StringRangeConversion();
		String s="abcdeerf";
		String[][] ops={{"4","7","L"},
						{"4","7","L"},
						{"0","5","L"}};
		String r="zabcbbpd";
		assertTrue(tester.convertString(s, ops).equals(r));
	}
	@Test
	public void test3() {
		StringRangeConversion tester=new StringRangeConversion();
		String s="abcdeerf";
		String[][] ops={{"4","7","L"},
						{"4","7","L"},
						{"0","5","L"},
						{"4","5","R"}};
		String r="zabcccpd";
		assertTrue(tester.convertString(s, ops).equals(r));
	}
	@Test
	public void test4() {
		StringRangeConversion tester=new StringRangeConversion();
		String s="abcdeerfz";
		String[][] ops={{"4","7","L"},
						{"4","7","L"},
						{"0","5","L"},
						{"4","8","R"}};
		String r="zabcccqea";
		assertTrue(tester.convertString(s, ops).equals(r));
	}
}
