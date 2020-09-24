package edu.iastate.cs228.hw1;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

public class JaguarTest {


	Jungle j = new Jungle(3);
	Jungle jNew;
	int[] pop;
	@Before
	public void setUp() 
	{
		j.grid[0][0] = new Deer(j,0,0,0);
		j.grid[0][1] = new Grass(j,0,1);
		j.grid[0][2] = new Deer(j,0,2,0);
		j.grid[1][0] = new Jaguar(j,1,0,0);
		j.grid[1][1] = new Jaguar(j,1,1,2);
		j.grid[1][2] = new Grass(j,1,2);
		j.grid[2][0] = new Deer(j,2,0,1);
		j.grid[2][1] = new Puma(j,2,1,0);
		j.grid[2][2]	 = new Empty(j,2,2);									
		pop = new int[5];
	}
	/**
	 *	Jungle grid in .txt file:
	 *
	 *	D0 G D0 
	 *	J0 J2 G 
	 *	D1 P0 E
	 */

	@Test
	public void testWho() {
		assertEquals(j.grid[1][1].who(),State.JAGUAR);
	}
	@Test
	public void testAge() 
	{
		assertEquals(2,((Animal)j.grid[1][1]).myAge());
	}
	
	@Test
	public void testRuleA() {
		int age = ((Animal)j.grid[1][1]).myAge();
		age = 5;
		assertTrue(age == Deer.JAGUAR_MAX_AGE);
	}
	@Test
	public void testRuleB() 
	{
		j.grid[1][0] =new Puma(j,1,0,1);
		j.grid[0][1] =new Puma(j,0,1,1);
		j.grid[1][2] = new Puma(j,1,2,1);
		j.grid[1][1].census(pop);
		assertTrue((j.grid[1][1].next(j)).who() == State.PUMA);
	}


	@Test
	public void testRuleC() 
	{
		j.grid[0][1] =new Puma(j,0,1,1);
		j.grid[1][2] = new Puma(j,1,2,1);
		j.grid[1][1].census(pop);
		assertTrue((j.grid[1][1].next(j)).who() == State.EMPTY);
	}
	@Test
	public void testRuleD() 
	{

		j.grid[1][0] = new Jaguar(j,1,0,1);
		j.grid[1][2] = new Jaguar(j,1,2,1);
		j.grid[0][0] = new Jaguar(j,0,0,1);
		j.grid[1][2] = new Jaguar(j,1,2,1);
		j.grid[1][1].census(pop);
		assertTrue((j.grid[1][1].next(j)).who() == State.JAGUAR);
	}


}
