package JungleCyele;

/**
 *  
 * @author Saroye
 *
 */

/*
 * This class is to be extended by the Deer, Jaguar, and Puma classes. 
 */
public abstract class Animal extends Living implements MyAge
{
	protected int age;   // age of the animal 

	public Animal(Jungle j, int r, int c, int a)
	{
		super(j,r,c);
		this.age = a;
	}
	
	@Override
	/**
	 * @return age of the animal 
	 */
	public int myAge()
	{
		return age; 
	}
}
