package phoneTester;

import static org.junit.Assert.*;

import org.junit.Test;

import phone.Calculator1;

public class Calculator1Tester {

	@Test
	public void test() {
		Calculator1 tester=new Calculator1();
		assertTrue(tester.calString("((2+3)*(4*5))")==100);
		assertTrue(tester.calString("1+1")==2);
		assertTrue(tester.calString("2-1+2")==3);
		assertTrue(tester.calString("(1+(4+5+2)-3)+(6+8)")==23);
		assertTrue(tester.calString("(1*(4+5+2)-3)+(6+8)")==22);
		assertTrue(tester.calString("(1+(4*5-2)-3)*(6+8)")==224);
		assertTrue(tester.calString("(1+(4*5*2+9*(7-9)*7)-3)-(6*8)")==-136);
		assertTrue(tester.calString("(((1+(4*5*(2+9*(7-9)*7)-3)-(6*8))))")==-2530);
	}

}
