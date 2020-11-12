package JungleCyele;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

public class GrassTest {
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
		j.grid[1][1] = new Grass(j,1,1);
		j.grid[1][2] = new Grass(j,1,2);
		j.grid[2][0] = new Deer(j,2,0,1);
		j.grid[2][1] = new Puma(j,2,1,0);
		j.grid[2][2]	 = new Empty(j,2,2);									
		pop = new int[5];
	}

	@Test
	public void testRuleA()
	{
		j.grid[0][2] = new Deer(j,0,2,3);
		j.grid[0][1] = new Deer(j,0,1,1);
		j.grid[2][0] = new Deer(j,2,0,2);
		j.grid[1][2] = new Deer(j,1,2,1);
		j.grid[1][1].census(pop);
		assertTrue((j.grid[1][1].next(j)).who() == State.EMPTY);
	}
	@Test
	public void testRuleB() 
	{

		j.grid[1][0] =new Deer(j,1,0,1);
		j.grid[0][1] =new Deer(j,0,1,1);
		j.grid[1][1].census(pop);
		assertTrue((j.grid[1][1].next(j)).who() == State.DEER);
	}

	@Test
	public void testRuleC() 
	{
		j.grid[1][1].census(pop);
		assertTrue((j.grid[1][1].next(j)).who() == State.GRASS);
	}
}
