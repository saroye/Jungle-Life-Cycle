package edu.iastate.cs228.hw1;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

public class EmptyTest {
	private Jungle j = new Jungle(3);
	int[] pop;
	@Before
	public void setUp() 
	{
		j.grid[0][0] = new Deer(j,0,0,0);
		j.grid[0][1] = new Empty(j,0,1);
		j.grid[0][2] = new Grass(j,0,0);
		j.grid[1][0] = new Puma(j,1,0,1);
		j.grid[1][1] = new Empty(j,1,1);
		j.grid[1][2] = new Jaguar(j,1,2,2);
		j.grid[2][0] = new Puma(j,2,0,1);
		j.grid[2][1] = new Jaguar(j,2,1,3);
		j.grid[2][2] = new Puma(j,2,2,3);
		pop = new int[5];
	}
	
	@Test
	public void testWho() {
		assertEquals(State.EMPTY, j.grid[1][1].who());
	}
	@Test
	public void testRuleA()
	{
		j.grid[0][2] = new Deer(j,0,2,0);
		j.grid[1][1].census(pop);
		assertTrue((j.grid[1][1].next(j)).who() == State.DEER);
	}
	
	@Test
	public void testRuleB()
	{
		j.grid[0][2] = new Puma(j,0,2,0);
		j.grid[1][1].census(pop);
		assertTrue((j.grid[1][1].next(j)).who() == State.PUMA);
	}
	@Test
	public void testRuleC()
	{
		j.grid[0][2] = new Jaguar(j,0,2,0);
		j.grid[0][1] = new Jaguar(j,0,1,1);
		j.grid[2][0] = new Jaguar(j,2,0,1);
		j.grid[2][2] = new Jaguar(j,2,2,1);
		j.grid[1][1].census(pop);
		assertTrue((j.grid[1][1].next(j)).who() == State.JAGUAR);
	}
	@Test
	public void testRuleD()
	{
		j.grid[0][2] = new Grass(j,0,2);
		j.grid[0][1] = new Grass(j,0,1);
		j.grid[2][0] = new Grass(j,2,0);
		j.grid[2][2] = new Grass(j,2,2);
		j.grid[1][1].census(pop);
		assertTrue((j.grid[1][1].next(j)).who() == State.JAGUAR);
	}
	@Test
	public void testRuleE()
	{
		j.grid[0][2] = new Empty(j,0,2);
		j.grid[0][1] = new Empty(j,0,1);
		j.grid[2][0] = new Empty(j,2,0);
		j.grid[2][1] = new Empty(j,2,1);
		j.grid[2][2] = new Empty(j,2,2);
		j.grid[1][1].census(pop);
		System.out.println(Arrays.toString(pop));
		assertTrue((j.grid[1][1].next(j)).who() == State.EMPTY);
	}


}
