package phoneTester;

import static org.junit.Assert.*;

import org.junit.Test;

import phone.CalculatorTree;

public class CalculatorTreeTester {

	@Test
	public void test1() {
		CalculatorTree tester=new CalculatorTree();
		String s="(3*(5-4))+((-6)/2)";
		assertTrue(tester.printTree(tester.makeCalculatorTree(s)).equals(s));
	}
	@Test
	public void test2() {
		CalculatorTree tester=new CalculatorTree();
		String s="-6";
		assertTrue(tester.printTree(tester.makeCalculatorTree(s)).equals(s));
	}
	@Test
	public void test3() {
		CalculatorTree tester=new CalculatorTree();
		String s="(-105)";
		assertTrue(tester.printTree(tester.makeCalculatorTree(s)).equals("-105"));
	}
	@Test
	public void test4() {
		CalculatorTree tester=new CalculatorTree();
		String s="(3*(5-4))-((-6)/(-20))";
		assertTrue(tester.printTree(tester.makeCalculatorTree(s)).equals(s));
	}
	@Test
	public void test5() {
		CalculatorTree tester=new CalculatorTree();
		String s="";
		assertTrue(tester.printTree(tester.makeCalculatorTree(s)).equals(s));
	}
	@Test
	public void test6() {
		CalculatorTree tester=new CalculatorTree();
		String s="124124-1455";
		assertTrue(tester.printTree(tester.makeCalculatorTree(s)).equals(s));
	}

}
