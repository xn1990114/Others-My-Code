package onsiteTester;

import static org.junit.Assert.*;


import org.junit.Test;

import onsite.PlantFlower;

public class PlantFlowerTester {

	@Test
	public void test1() {
		PlantFlower tester=new PlantFlower();
		int pathLen=9;
		int[][] workers={{1,5},{3,5},{1,3},{2,7},{2,4},{3,8},{6,7},{7,9}};
		assertTrue(tester.findMaxWorker(pathLen, workers)==6);
	}
	@Test
	public void test2() {
		PlantFlower tester=new PlantFlower();
		int pathLen=9;
		int[][] workers={{1,5},{3,5},{1,3},{2,7},{2,4},{4,8},{6,7},{7,9}};
		assertTrue(tester.findMaxWorker(pathLen, workers)==7);
	}
	@Test
	public void test3() {
		PlantFlower tester=new PlantFlower();
		int pathLen=9;
		int[][] workers={{1,5},{3,5},{1,3},{4,7},{2,4},{4,9},{6,7},{7,9}};
		assertTrue(tester.findMaxWorker(pathLen, workers)==7);
	}
	@Test
	public void test4() {
		PlantFlower tester=new PlantFlower();
		int pathLen=9;
		int[][] workers={{1,5},{3,5},{1,3},{4,7},{2,4},{4,8},{6,7},{7,9},{6,9}};
		assertTrue(tester.findMaxWorker(pathLen, workers)==8);
	}
	@Test
	public void test5() {
		PlantFlower tester=new PlantFlower();
		int pathLen=9;
		int[][] workers={{1,5},{3,5},{1,3},{4,6},{2,4},{4,8},{6,7},{7,9},{6,9},{6,6}};
		assertTrue(tester.findMaxWorker(pathLen, workers)==9);
	}
}
