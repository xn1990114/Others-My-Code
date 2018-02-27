package phoneTester;

import static org.junit.Assert.*;

import org.junit.Test;

import phone.PaintWall;

public class PaintWallTester {

	@Test
	public void test() {
		PaintWall tester=new PaintWall();
		int[] n1={1,3,2,3,2};
		int[] n2={1,1,1,1};
		int[] n3={1,0,1,1};
		int[] n4={5,8};
		int[] n5={5,8,5,7};
		assertTrue(tester.brushNeeded(n1)==4);
		assertTrue(tester.brushNeeded(n2)==1);
		assertTrue(tester.brushNeeded(n3)==2);
		assertTrue(tester.brushNeeded(n4)==8);
		assertTrue(tester.brushNeeded(n5)==10);
	}

}
