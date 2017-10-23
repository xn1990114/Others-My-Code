package phoneTester;

import static org.junit.Assert.*;

import org.junit.Test;

import phone.AssembleStrings;

public class AssembleStringsTester {

	@Test
	public void test() {
		AssembleStrings tester=new AssembleStrings();
		String t1="learning";
		String[] dic1={"math", "science", "english", "history"};
		assertTrue(tester.findMinStickersRequired(t1, dic1)==4);
		String t2="nanxiao";
		assertTrue(tester.findMinStickersRequired(t2, dic1)==-1);
		String t3="nan";
		assertTrue(tester.findMinStickersRequired(t3, dic1)==3);
		String t4="nanliao";
		assertTrue(tester.findMinStickersRequired(t4, dic1)==5);
		String t5="cceeins";
		assertTrue(tester.findMinStickersRequired(t5, dic1)==1);
		String t6="his";
		assertTrue(tester.findMinStickersRequired(t6, dic1)==1);
		
	}

}
