package phoneTester;

import static org.junit.Assert.*;

import org.junit.Test;

import phone.CountPrimeSquare;

public class CountPrimeSquareTester {

	@Test
	public void test1() {
		CountPrimeSquare tester=new CountPrimeSquare();
		int[][] nums={{3,4,6,0,4,3},
					  {3,7,9,5,0,2},
					  {3,7,9,5,0,2},
					  {3,7,9,5,0,2},
					  {3,7,9,5,0,2},
					  {3,7,9,5,0,2},
					  {3,7,9,5,0,2}};
		assertTrue(tester.countSqr(nums)==14+12+5);
	}
	@Test
	public void test2() {
		CountPrimeSquare tester=new CountPrimeSquare();
		int[][] nums={{3,4,6,0,4,3},
					  {3,7,3,5,0,2},
					  {3,7,3,5,0,2},
					  {3,7,3,5,0,2},
					  {3,7,3,5,0,2},
					  {3,7,3,5,0,2},
					  {3,7,3,5,0,2}};
		assertTrue(tester.countSqr(nums)==14+18+15+8+3);
	}
	@Test
	public void test3() {
		CountPrimeSquare tester=new CountPrimeSquare();
		int[][] nums={{3,4,6,0,4,3},
					  {3,7,3,5,0,2},
					  {3,7,3,5,0,2},
					  {3,9,3,5,0,2},
					  {3,7,3,5,0,2},
					  {3,7,3,5,0,2},
					  {3,7,3,5,0,2}};
		assertTrue(tester.countSqr(nums)==14+17+11+2);
	}
}
