package edu.iastate.cs228.hw1;

/**
 *  
 * @author
 *
 */

/**
 * Grass may be eaten out or taken over by deers. 
 *
 */
public class Grass extends Living 
{
	public Grass (Jungle j, int r, int c) 
	{
		super(j,r,c);
	}
	@Override
	public State who()
	{  
		return State.GRASS; 
	}
	
	/**
	 * Grass can be eaten out by too many deers in the neighborhood. Deers may also 
	 * multiply fast enough to take over Grass. 
	 * 
	 * @param jNew     jungle in the next cycle
	 * @return Living  life form occupying the square in the next cycle. 
	 */
	
	/**
	 * 	0 = DEER
	 * 	1 = EMPTY
	 * 	2 = GRASS
	 * 	3 = JAGUAR
	 * 	4 = PUMA
	 */
	@Override
	public Living next(Jungle jNew)
	{
		int[] population = new int[5];
		census(population);
		 if(population[2]*3 <= population[0]) 
		 {
			 return jNew.grid[row][column] = new Empty(jNew,this.row,this.column);
		 }
		 else if(population[0] >= 4)
			 {
				return jNew.grid[row][column] = new Deer(jNew, this.row, this.column, 0);
			 }
		 else 
		 {
			return  jNew.grid[row][column] = new Grass(jNew, this.row, this.column);
		 }
		// See Living.java for an outline of the function. 
		// See Section 2.1 in the project description for the survival rules for a jaguar. 
	
	}
}
