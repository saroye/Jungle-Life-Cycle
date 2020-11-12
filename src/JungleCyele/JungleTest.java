package JungleCyele;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;

import org.junit.Before;
import org.junit.Test;

public class JungleTest {
	Jungle jNew = new Jungle(3);
	 Jungle j;

	@Before
	public void setUp() throws FileNotFoundException 
	{
		 j = new Jungle("/Users/Saroye/Documents/Spring'18/CS-228/project-1/public/deer.txt");
		jNew.grid[0][0] = new Grass(jNew,0,0);
		jNew.grid[0][1] = new Empty(jNew,0,0);
		jNew.grid[0][2] = new Grass(jNew,0,0);
		jNew.grid[1][0] = new Empty(jNew,1,0);
		jNew.grid[1][1] = new Jaguar(jNew,1,1,0);
		jNew.grid[1][2] = new Puma(jNew,1,2,1);
		jNew.grid[2][0] = new Jaguar(jNew,2,0,1);
		jNew.grid[2][1] = new Empty(jNew,2,1);
		jNew.grid[2][2] = new Deer(jNew,2,2,0);
	}
	@Test
	public void testFile() 
	{
		assertTrue((j.grid[0][0]).who() == State.GRASS);
		assertTrue((j.grid[0][1]).who() == State.EMPTY);
		assertTrue((j.grid[0][2]).who() == State.GRASS);
		assertTrue((j.grid[1][0]).who() == State.EMPTY);
		assertTrue((j.grid[1][1]).who() == State.JAGUAR);
		assertTrue((j.grid[1][2]).who() == State.PUMA);
		assertTrue((j.grid[2][0]).who() == State.JAGUAR);
		assertTrue((j.grid[2][1]).who() == State.EMPTY);
		assertTrue((j.grid[2][2]).who() == State.DEER);
		
		
	}

}
