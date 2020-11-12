package JungleCyele;

import java.io.FileNotFoundException;
import java.util.Scanner; 

/**
 *  
 * @author
 *
 */

/**
 * 
 * The CircleOfLife class performs simulation over a grid jungle 
 * with squares occupied by deers, jaguars, pumas, grass, or none. 
 *
 */
public class CircleOfLife 
{
	/**
	 * Update the new jungle from the old jungle in one cycle. 
	 * @param jOld  old jungle
	 * @param jNew  new jungle 
	 */
	public static void updateJungle(Jungle jOld, Jungle jNew)
	{
		for(int i = 0; i < jOld.getWidth(); i++)
		{
			for(int j =0; j< jOld.getWidth(); j++)
			{
				jNew.grid[i][j] = jOld.grid[i][j].next(jNew);
			}
		}
	}
	
	/**
	 * Repeatedly generates jungles either randomly or from reading files. 
	 * Over each jungle, carries out an input number of cycles of evolution. 
	 * @param args
	 * @throws FileNotFoundException
	 */
	public static void main(String[] args) throws FileNotFoundException
	{	
		// TODO 
		
		Jungle even;   				 // the jungle after an even number of cycles 
		Jungle odd;                  // the jungle after an odd number of cycles
		// 
		// Generate CircleOfLife simulations repeatedly like shown in the 
		// sample run in the project description. 
		// 
		// 1. Enter 1 to generate a random jungle, 2 to read a jungle from an input
		//    file, and 3 to end the simulation. (An input file always ends with 
		//    the suffix .txt.)
		// 
		
		int trial = 1;
		int cycles;
		Scanner in = new Scanner(System.in);
		System.out.println("Circle of Life in the Amazon Jungle. \nChoices:  \n1: Random Jungle \n2: File input \n3: Exit");
		int key = in.nextInt();
		while ( key < 3) 
		{
			if(key == 1)
			{
				System.out.println("Trial "+trial+": "+key);
				trial++;
				System.out.println("Random jungle");
				System.out.print("Enter grid Width: \n");
				int size = in.nextInt();
				even = new Jungle(size);
				even.randomInit();
				System.out.print("Enter the number of cycles: \n");
				cycles = in.nextInt();
				System.out.println("Initial Jungle: \n");
				System.out.println(even);
				odd = new Jungle(even.getWidth());
				for(int i =0; i < cycles; i++)
				{
					if(i % 2 == 0)
					{
						updateJungle(even, odd);
					}
					else
					{
						updateJungle(odd, even);
					}
				}
				System.out.println("Final Jungle: \n");
				if(cycles % 2 == 0){
					System.out.println(even);
				}
				else
				{
					System.out.println(odd);
				}
			}
			else if (key == 2)
			{
				System.out.println("Trial "+trial+": "+key);
				trial++;
				System.out.println("Jungle input from a file");	
				System.out.println("File name: ");
				String file = in.next();
				System.out.print("Enter the number of cycles: ");
				even = new Jungle(file);
				odd= new Jungle(even.getWidth());
				cycles = in.nextInt();
				System.out.println("Initial Jungle: \n"+even.toString());
				for(int i =0; i < cycles; i++)
				{
					if(i % 2 == 0){
						updateJungle(even, odd);
					}
					else{
						updateJungle(odd, even);
					}
				}
				System.out.println("Final Jungle: \n");
				if(cycles % 2 == 0)
				{
					System.out.println(even);
				}
				else{
					System.out.println(odd);
				}
			}
		System.out.println("Trial"+trial+": ");
		key = in.nextInt();
		}
		
		
		// 2. Print out standard messages as given in the project description. 
		// 
		// 3. For convenience, you may define two jungles even and odd as below. 
		//    In an even numbered cycle (starting at zero), generate the jungle 
		//    odd from the jungle even; in an odd numbered cycle, generate even 
		//    from odd. 
		
		// 4. Print out initial and final jungles only.  No intermediate jungles should
		//    appear in the standard output.  (When debugging your program, you can 
		//    print intermediate jungles.)
		// 
		// 5. You may save some randomly generated jungles as your own test cases. 
		// 
		// 6. It is not necessary to handle file input & output exceptions for this 
		//    project. Assume data in an input file to be correctly formated.
	}
}
