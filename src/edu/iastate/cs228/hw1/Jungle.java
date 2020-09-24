package edu.iastate.cs228.hw1;

import java.io.BufferedWriter;

/**
 *  
 * @author
 *
 */

import java.io.File; 
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.Scanner; 
import java.util.Random; 

/**
 * 
 * The jungle is represented as a square grid of size width X width. 
 *
 */
public class Jungle 
{
	private int width; // grid size: width X width 
	public Living[][] grid; 	//all the living animals in Jungle
	private String s;			// animals in jungle as a string
	private int count = 0;
	
	/**
	 *  Default constructor reads from a file 
	 */
	public Jungle(String inputfile) throws FileNotFoundException
	{		
		// Assumption: The input file is in correct format. 
		// You may create the grid jungle in the following steps: 
		File file = new File(inputfile);
		Scanner in = new Scanner(file);
		// 1) Reads the first line to determine the width of the grid.
		width = new Scanner(file).nextLine().length()/3;
		// 2) Creates a grid object.  
		grid = new Living[width][width];
		// 3) Fills in the grid according to the input file. 
		for(int i =0; i < grid.length; i++)
		{
			for(int j=0; j< grid[0].length; j++)
			{
				String next = in.next();
				
				if(next.charAt(0) == 'D')
				{
					grid[i][j] = new Deer(this,i,j,next.charAt(1)-48);
				}
				else if(next.charAt(0) == 'E')
				{
					grid[i][j] = new Empty(this,i,j);
				}
				else if(next.charAt(0) == 'G')
				{
					grid[i][j]=new Grass(this,i,j);
				}
				else if(next.charAt(0) == 'J')
				{
					grid[i][j]=new Jaguar(this,i,j,next.charAt(1)-48);
				}
				else if(next.charAt(0) == 'P')
				{
					grid[i][j]=new Puma(this,i,j,next.charAt(1)-48);
				}
			}
		}
		// Be sure to close the input file when you are done. 
		in.close();
	}
	/**
	 * Constructor that builds a w X w grid without initializing it. 
	 * @param width  the grid 
	 */
	public Jungle(int w)
	{
		grid = new Living[w][w];
	}
	
	
	public int getWidth()
	{
		// TODO  
		return grid.length;  // to be modified 
	}
	
	/**
	 * Initialize the jungle by randomly assigning to every square of the grid  
	 * one of Deer, Empty, Grass, Jaguar, or Puma.  
	 * 
	 * Every animal starts at age 0.
	 */
	public void randomInit()
	{
		Random generator = new Random(); 
		for(int i =0; i< grid.length; i++)
		{
			for(int j =0; j< grid[0].length; j++)
			{
				int rand = generator.nextInt(5);
				if(rand == 0)
				{
					grid[i][j]=new Deer(this,i,j,0);
				}
				else if(rand == 1)
				{
					grid[i][j] = new Empty(this,i,j);
				}
				else if(rand == 2)
				{
					grid[i][j]=new Grass(this,i,j);
				}
				else if(rand == 3)
				{
					grid[i][j]=new Jaguar(this,i,j,0);
				}
				else if(rand == 4)
				{
					grid[i][j]=new Puma(this,i,j,0);
				}
			}
		}
		
	}
	
	
	/**
	 * Output the jungle grid. For each square, output the first letter of the living form
	 * occupying the square. If the living form is an animal, then output the age of the animal 
	 * followed by a blank space; otherwise, output two blanks.  
	 */

	public String toString()
	{
		s ="";
		for(int i=0; i < grid.length; i++)
		{
			for(int j =0; j < grid[0].length; j++)
			{
				Living a = grid[i][j];
				
				if(a.who() == State.DEER)
				{
					
					s += "D"+((Animal)a).myAge()+" ";
				}
				else if(a.who() == State.EMPTY)
				{
					s +="E  ";
				}
				else if(a.who() == State.GRASS)
				{
					s += "G  ";
				}
				else if(a.who() == State.JAGUAR)
				{
					s += "J"+((Animal)a).myAge()+" ";
				}
				else if(a.who() == State.PUMA)
				{
					s += "P"+((Animal)a).myAge()+" ";
				}
			}
			s += "\n"; 
		}
		return s; 
	}
	

	/**
	 * Write the jungle grid to an output file.  Also useful for saving a randomly 
	 * generated jungle for debugging purpose. 
	 * @throws FileNotFoundException
	 */
	public void write(String outputFileName) throws FileNotFoundException
	{
		File file=new File(outputFileName); 
		PrintWriter pw = new PrintWriter(file);
		pw.print(s);
		pw.close();
	}
}
