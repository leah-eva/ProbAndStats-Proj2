

import java.util.ArrayList;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;

/**
 * This program takes an ArrayList of BigDecimal values and and outputs the 
 * values into a CSV file, along with the result of putting those values in
 * 
 * 
 * @author leah-eva
 *
 */
public class FunctionMapper {
	
	/**
	 * This method runs the program, given an ArrayList of BigInteger values.
	 * 	
	 * @param inputList An ArrayList of BigInteger values.
	 */
	public void run(ArrayList<BigDecimal> inputList) {
		
		//Create BufferedWriter object output
		BufferedWriter output = null;
		
		//Create FileWriter object fw
		FileWriter fw = null;
		
		try {
			
			//Set fw equal to new FileWriter that writes to "data.csv"
			fw = new FileWriter("data.csv");
			
			//Set output equal to new BufferedWriter object to increase 
			// efficiency of FileWriter fw
			output = new BufferedWriter(fw);
			
			//Write header "x,y" to "data.csv"
			output.write("x,y");
			
			//New line
			output.newLine();
			
			//Loop through inputList values
			for(BigDecimal value: inputList) {
			
				//Write value and function of value to "data.csv"
				output.write(value.toString() + "," 
						+ function(value).toString());
				
				//New line
				output.newLine();
			
			}
			
			//Close stream
			output.close();
		
		}
		
		catch (IOException e) {
			
			e.printStackTrace();
			System.out.println("An error occurred!");
			
		}
		
	}
	
	/**
	 * This method takes a BigDecimal object and computes the corresponding
	 * function value, which is returned as a BigInteger object.
	 * 
	 * @param inputValue A BigDecimal object that stores the input value.
	 * @return A BigDecimal object that stores the value of the output of the function.
	 */
	public BigDecimal function(BigDecimal inputValue) {
		
		return inputValue.multiply(inputValue).add(BigDecimal.valueOf(100)) ;
		
	}
	
}
