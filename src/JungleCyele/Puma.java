package JungleCyele;

/**
 *  
 * @author
 *
 */

/**
 * A puma eats deers and competes against a jaguar. 
 */
public class Puma extends Animal 
{
	/**
	 * Constructor 
	 * @param j: jungle
	 * @param r: row position 
	 * @param c: column position
	 * @param a: age 
	 */
	public Puma (Jungle j, int r, int c, int a) 
	{
		super(j,r,c,a);
	}
		
	/**
	 * A puma occupies the square. 	 
	 */
	@Override
	public State who()
	{
		return State.PUMA; 
	}
	
	/**
	 * A puma dies of old age or hunger, or from attack by a jaguar. 
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
		 if(this.myAge() == this.PUMA_MAX_AGE )
		 {
			return jNew.grid[row][column] = new Empty(jNew,this.row,this.column);
		 }
		 else if(population[4] < population[3])
			 {
				return  jNew.grid[row][column] = new Jaguar(jNew, this.row, this.column, 0);
			 }
		 else if(population[3] + population[4] > population[0]) 
		 {
			 return jNew.grid[row][column] = new Empty(jNew,this.row,this.column);
				 
		 }
		 else 
		 {
			 return jNew.grid[row][column] = new Puma(jNew, this.row,this.column, this.myAge()+1);
		 }
	}
}
