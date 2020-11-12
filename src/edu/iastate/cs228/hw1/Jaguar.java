package edu.iastate.cs228.hw1;

/**
 *  
 * @author
 *
 */

/**
 * A jaguar eats a deer and competes against a puma. 
 */
public class Jaguar extends Animal
{
	/**
	 * Constructor 
	 * @param j: jungle
	 * @param r: row position 
	 * @param c: column position
	 * @param a: age 
	 */
	public Jaguar (Jungle j, int r, int c, int a) 
	{
		super(j,r,c,a);
	}
	
	/**
	 * A jaguar occupies the square. 	 
	 */
	@Override
	public State who()
	{
		return State.JAGUAR; 
	}
	
	/**
	 * A jaguar dies of old age or hunger, from isolation and attack by numerous pumas.
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
		this.census(population);
		 if(this.myAge() == this.JAGUAR_MAX_AGE )
		 {
			return jNew.grid[row][column] = new Empty(jNew,this.row,this.column);
		 }
		 else if(population[4] >= 2*population[3])
			 {
				 return jNew.grid[row][column] = new Puma(jNew, this.row, this.column, 0);
			 }
		 else if( population[3] + population[4] > population[0] ) 
		 {
			 return jNew.grid[row][column] = new Empty(jNew,this.row,this.column);
		 }
		 else 
		 {
			return  jNew.grid[row][column] = new Jaguar(jNew, this.row,this.column, this.myAge()+1);
		 }
		// See Living.java for an outline of the function. 
		// See Section 2.1 in the project description for the survival rules for a jaguar. 
	}
}
