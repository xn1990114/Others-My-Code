package phoneTester;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import phone.FindLocalMax;

public class FindLocalMaxTester {

	@Test
	public void test() {
		FindLocalMax tester=new FindLocalMax();
		int[] nums1={1,2,3,4,5,6,7,8,7,6,5,4,3,4,5,6,7,6,5};
		List<Integer> r1=tester.findMax(nums1);
		assertTrue(r1.get(0)==8&&r1.get(1)==7);
		
		int[] nums2={1,0,1,2,3,4,5,6,7,8};
		List<Integer> r2=tester.findMax(nums2);
		assertTrue(r2.get(0)==1&&r2.get(1)==8);
		
		int[] nums3={3,2,1,2,3,4,5,6,7,8,7,6,5,6,7,8,9};
		List<Integer> r3=tester.findMax(nums3);
		for(int num:r3){
			System.out.println(num);
		}
		assertTrue(r3.get(0)==3&&r3.get(1)==9&&r3.get(2)==8);
	}

}
