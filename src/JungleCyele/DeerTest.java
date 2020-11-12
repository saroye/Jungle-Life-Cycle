package JungleCyele;
import static org.junit.Assert.*;

import java.io.FileNotFoundException;

import org.junit.Before;
import org.junit.Test;

public class DeerTest {
	Jungle j = new Jungle(3);
	Jungle jNew;
	int[] pop;
	@Before
	public void setUp() throws FileNotFoundException 
	{
		j.grid[0][0] = new Deer(j,0,0,0);
		j.grid[0][1] = new Empty(j,0,1);
		j.grid[0][2] = new Grass(j,0,2);
		j.grid[1][0] = new Puma(j,1,0,1);
		j.grid[1][1] = new Deer(j,1,1,2);
		j.grid[1][2] = new Jaguar(j,1,2,2);
		j.grid[2][0] = new Puma(j,2,0,1);
		j.grid[2][1] = new Jaguar(j,2,1,3);
		j.grid[2][2]	 = new Puma(j,2,2,3);		
		 pop = new int[5];
	}
	/**
	 *	Jungle grid in .txt file:
	 *
	 *	D0 E  G
	 * 	P1 D2 J2
	 *  	P1 J3 P3
	 */

	@Test
	public void testWho() {
		assertEquals(State.DEER, j.grid[1][1].who());
	}
	@Test
	public void testAge() 
	{
		assertEquals(2,((Animal)j.grid[1][1]).myAge());
	}
	
	@Test
	public void testRuleA() {
		int age = ((Animal)j.grid[1][1]).myAge();
		age = 6;
		assertTrue( age== Deer.DEER_MAX_AGE);
	}
	
	@Test
	public void testRuleB() 
	{
		j.grid[0][2] =new Empty(j,0,2);
		j.grid[1][1].census(pop);
		assertEquals((j.grid[1][1].next(j)).who(), State.EMPTY);
	}
	@Test
	public void testRuleC()
	{
		j.grid[1][0] =new Puma(j,1,0,1);
		j.grid[0][1] =new Puma(j,0,1,1);
		j.grid[1][2] = new Puma(j,1,2,1);
		j.grid[1][1].census(pop);
		assertTrue((j.grid[1][1].next(j)).who() == State.PUMA);
	}
	@Test
	public void testRuleD() 
	{
		j.grid[1][2] = new Jaguar(j,1,2,1);
		j.grid[0][0] = new Jaguar(j,0,0,1);
		j.grid[1][1].census(pop);
		assertTrue((j.grid[1][1].next(j)).who() == State.JAGUAR);
	}
	@Test
	public void testRuleE() 
	{

		j.grid[1][0] =new Deer(j,1,0,1);
		j.grid[0][1] =new Deer(j,0,1,1);
		j.grid[2][2] =new Deer(j,2,2,2);
		assertTrue((j.grid[1][1].next(j)).who() == State.DEER);
	}
}
