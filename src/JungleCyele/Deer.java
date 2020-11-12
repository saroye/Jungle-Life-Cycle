package JungleCyele;

/**
 *  
 * @author
 *
 */

/*
 * A deer eats grass and lives no more than six years.
 */
public class Deer extends Animal 
{	
	/**
	 * Creates a Deer object.
	 * @param j: jungle  
	 * @param r: row position 
	 * @param c: column position
	 * @param a: age 
	 */
	public Deer (Jungle j, int r, int c, int a) 
	{
		super(j,r,c,a);
	}
		
	// Deer occupies the square.
	@Override
	public State who()
	{  
		return State.DEER; 
	}
	
	/**
	 * @param jNew     jungle in the next cycle 
	 * @return Living  new life form occupying the same square
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
	// See Living.java for an outline of the function. 
	// See Section 2.3 in the project description for the survival rules for a deer. 
	{
		int[] population = new int[5];
		census(population);
		 if(this.myAge() == this.DEER_MAX_AGE)
		 {
			 return jNew.grid[row][column] = new Empty( jNew,this.row,this.column );
		 }
		 else if(  population[2] == 0 ) 
		 {
			 return jNew.grid[row][column] = new Empty( jNew,this.row,this.column );
		 }
		 else if( population[4] + population[3] > population[0] &&  population[4] >= population[3]*2 )
		 {
			 return jNew.grid[row][column] = new Puma(jNew, this.row, this.column, 0);
			 }
		 else if ( population[4] + population[3] > population[0] && population[4] <= population[3])
			 {
				return  jNew.grid[row][column] = new Jaguar(jNew, this.row,this.column,0);
			 }
		 else 
		 {
			return jNew.grid[row][column] = new Deer(jNew, this.row,this.column, this.myAge()+1);
		 }
	}
}
