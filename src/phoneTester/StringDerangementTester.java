package phoneTester;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import phone.StringDerangement;

public class StringDerangementTester {

	@Test
	public void test() {
		StringDerangement tester=new StringDerangement();
		List<String> r1=tester.calDerangement("ABBCCDDE");
		for(String s:r1){
			System.out.println(s);
		}
	}

}
