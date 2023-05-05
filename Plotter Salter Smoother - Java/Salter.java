
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

/**
 * This program takes data from a CSV file, salts the data, and exports the 
 * 	output to a new CSV file.
 * 
 * @author leah-eva
 *
 */
public class Salter {

	/**
	 * This method runs the program.
	 * 	
	 */
	public void run() {
		
		//Create BufferedReader object input
		BufferedReader input = null;
		
		//Create FileReader object fr
		FileReader fr = null;
		
		//Create BufferedWriter object output
		BufferedWriter output = null;
		
		//Create FileWriter object fw
		FileWriter fw = null;
		
		//Create Random object rand
		Random rand = new Random();
		
		//Create String line that will store lines read from input file
		String line;
		
		//Create array of Strings row that will store data from input file
		String[] row;
		
		try {
			
			//Set fr equal to new FileReader that read data from "data.csv"
			fr = new FileReader("data.csv");
			
			//Set input equal to new BufferedReader object to increase
			// efficiency of FileReader
			input = new BufferedReader(fr);
			
			//Set fw equal to new FileWriter that writes to "salted-data.csv"
			fw = new FileWriter("salted-data.csv");
			
			//Set output equal to new BufferedWriter object to increase 
			// efficiency of FileWriter fw
			output = new BufferedWriter(fw);
			
			//Read header of input file and store it in header
			String header = input.readLine();
			
			//Write header "x,y" to new file "salted-data.csv"
			output.write(header);
			
			//New line
			output.newLine();
			
			//check to ensure next line is not empty in csv file
			//source: https://stackabuse.com/reading-and-writing-csvs-in-java/
			while((line = input.readLine())!= null) {
				
				//Set row equal to array of values read from a line of the input 
				// file. Delimiter is "," since the file type is csv
				row = line.split(",");
				
				row[1] = Integer.toString(Integer.parseInt(row[1])
						+ (rand.nextInt(-2,2)));
				
				output.write(row[0] + "," + row[1]);
				output.newLine();
				
			}
			
			//Close output stream
			output.close();
			
		}
		
		catch (IOException e) {
			
			e.printStackTrace();
			System.out.println("An error occurred!");
			
		}
		
	}
	
}
