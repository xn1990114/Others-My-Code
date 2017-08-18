package phoneTester;

import org.junit.Test;

import phone.CalMaxScore;

public class CalMaxScoreTester {

	@Test
	public void test() {
		CalMaxScore tester=new CalMaxScore();
		tester.display(tester.findCutWay("sjfbkaianjk", 2));
		tester.display(tester.findCutWay("sjfbkaianjk", 5));
		System.out.println(tester.calScore("s")+tester.calScore("j")+
				tester.calScore("fbk")+tester.calScore("aian")+tester.calScore("jk"));
		System.out.println(tester.calScore("s")+tester.calScore("j")+
				tester.calScore("fbka")+tester.calScore("ian")+tester.calScore("jk"));
		System.out.println(tester.calScore("sjf")+tester.calScore("bk")+
				tester.calScore("ai")+tester.calScore("an")+tester.calScore("jk"));
		tester.display(tester.findCutWay("sjfbkazznjk", 5));
	}

}
