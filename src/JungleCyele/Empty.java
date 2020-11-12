package JungleCyele;

/**
 *  
 * @author
 *
 */

/** 
 * Empty squares are competed by various forms of life.
 */
public class Empty extends Living 
{
	public Empty (Jungle j, int r, int c) 
	{
		super(j,r,c);
	}
	
	@Override
	public State who()
	{ 
		return State.EMPTY; 
	}
	
	/**
	 * An empty square will be occupied by a neighboring Deer, Grass, Jaguar, or Puma, or 
	 * remain empty. 
	 * @param jNew     jungle in the next life cycle.
	 * @return Living  life form in the next cycle.   
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
		 if(population[0] > 1) 
		 {
			return  jNew.grid[row][column] = new Deer(jNew,this.row,this.column, 0);
		 }
		 else if(population[4] > 1)
			 {
				return jNew.grid[row][column] = new Puma(jNew, this.row, this.column, 0);
			 }
		 else if(population[3] > 1)
		 {
			return jNew.grid[row][column] = new Jaguar(jNew, this.row, this.column, 0);
		 }
		 else if(population[2] >= 1)
		 {
			return  jNew.grid[row][column] = new Grass(jNew, this.row, this.column);
		 }
		 else 
		 {
			return jNew.grid[row][column] = new Empty(jNew, this.row, this.column);
		 }
		// See Living.java for an outline of the function. 
		// See Section 2.1 in the project description for the survival rules for a jaguar. 
	
	}
}
