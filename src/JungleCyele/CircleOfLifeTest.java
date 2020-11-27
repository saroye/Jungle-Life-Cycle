package JungleCyele;

import java.io.FileNotFoundException;
import static org.junit.Assert.*;

import java.io.FileNotFoundException;

import org.junit.Before;
import org.junit.Test;
public class CircleOfLifeTest {

	@Before
	public void setUp() throws FileNotFoundException 
	{
		Jungle jOld = new Jungle("/Users/Saroye/Documents/jungleCycle/project-1/Jungle-Life-Cycle/tests/test1.txt");
		Jungle jNew = new Jungle(jOld.getWidth());
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
	public void testUpdateJungle() throws FileNotFoundException 
	{}

}
