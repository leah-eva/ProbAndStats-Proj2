import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * This program takes data from a CSV file, smoothes the data, and exports the 
 * 	output to a new CSV file.
 * 
 * @author leah-eva
 *
 */
public class Smoother {
	/**
	 * This method runs the program
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
		
		
		//Create String firstLine that will store lines read from input file
		String firstLine;
		
		//Create String secondLine that will store lines read from input file
		String secondLine;
		
		//Create array of Strings row that will store data from input file
		String[] firstRow;
		
		//Create array of Strings secondRow that will store data from input file
		String[] secondRow;
		
		double x1;
		double y1;
		double x2;
		double y2;
		double x;
		double y;
		
		try {
			
			//Set fr equal to new FileReader that read data from "data.csv"
			fr = new FileReader("data.csv");
			
			//Set input equal to new BufferedReader object to increase
			// efficiency of FileReader
			input = new BufferedReader(fr);
			
			//Set fw equal to new FileWriter that writes to "smoothed-data.csv"
			fw = new FileWriter("smoothed-data.csv");
			
			//Set output equal to new BufferedWriter object to increase 
			// efficiency of FileWriter fw
			output = new BufferedWriter(fw);
			
			//Read header of input file and store it in header
			String header = input.readLine();
			
			//Write header "x,y" to new file "salted-data.csv"
			output.write(header);
			
			//New line
			output.newLine();
			
			firstLine = input.readLine();
			
			//check to ensure next line is not empty in csv file
			//source: https://stackabuse.com/reading-and-writing-csvs-in-java/
			while((secondLine = input.readLine())!= null) {
				
				//Set row equal to array of values read from a line of the input 
				// file. Delimiter is "," since the file type is csv
				firstRow = firstLine.split(",");
				
				secondRow = secondLine.split(",");
				
				x1 = Double.parseDouble(firstRow[0]);
				x2 = Double.parseDouble(secondRow[0]);
				y1 = Double.parseDouble(firstRow[1]);
				y2 = Double.parseDouble(secondRow[1]);
				
				x = (x1 + x2) / 2.0;
				y = (y1+ y2) / 2.0;
				
				String[] newRow = {Double.toString(x), Double.toString(y)};
				
				output.write(newRow[0] + "," + newRow[1]);
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
