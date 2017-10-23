package onsiteTester;

import static org.junit.Assert.*;

import org.junit.Test;

import onsite.StockMultiBuyOneSell;

public class StockMultiBuyOneSellTester {

	@Test
	public void test() {
		StockMultiBuyOneSell tester=new StockMultiBuyOneSell();
		int[] p1={1,2,100};
		int[] p2={3,2,1};
		int[] p3={1,3,1,2};
		assertTrue(tester.findMaxProfix(p1)==197);
		assertTrue(tester.findMaxProfix(p2)==0);
		assertTrue(tester.findMaxProfix(p3)==3);
	}

}
