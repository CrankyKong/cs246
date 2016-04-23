import java.io.FileReader;
import java.io.BufferedReader;
import java.io.File;


/*********************************************************
*	 Assignment 01, CS246
*	 Logan Skidmore
*
* Desc - Opens a file and counts the words of each line
*********************************************************/
class FileTest{
	public FileTest(){
	
	}
	/********************************************************
	* lineCount
	* Takes a string uses the String method TRIM to eliminate
	* extra whitespace. Then splits the string by spaces and
	* returns the length. Counting the words in the line. 
	*********************************************************/
	int lineCount(String theLine){
		//trim leading or trailing whitespace
		String trim = theLine.trim();
		
		//empty string = no words
		if(trim.isEmpty())
				return 0;
			
		//separate string around spaces
		return trim.split("\\s+").length; 
	}
	
	/*****************************************************
	* ReadFile
	* Handles Error then reads file to user line by line
	* counting the words using the lineCOunt function 	
	****************************************************/
	void ReadFile(String filename) {
		File theFile = new File(filename);
		System.out.println("\nOpening file '" + filename + "'...\n");
		
		//does the file exist?
		if(!theFile.exists()){
			System.out.println("\n'" + filename + "' does not exist...\n");
			System.exit(-1);
		}
		
		//can the file be read?
		if(!theFile.canRead()){
			System.out.println("\nError reading '" + filename + "'...\n");
			System.exit(-2);
		}
			
		try(BufferedReader b = new BufferedReader(new FileReader(filename))){
			int number = 0;
			String theLine;
			while((theLine = b.readLine())!= null){
				number = lineCount(theLine);
				System.out.print(number + ": ");
				System.out.println(theLine);
			}
		}
		catch(Exception ex){
			System.out.println("Exception occurred " + ex.getMessage());
			System.exit(-4);
		}
	}
	/******************************
	* Main
	* creates a FileTest object	
	******************************/
	public static void main(String[] args){
		//checks if there is a filename argument
		if(args.length == 0){
			System.out.println("Put in a filename");
			System.exit(-3);
		}
		
		String filename = args[0];
		FileTest tester = new FileTest();
		tester.ReadFile(filename);
	}
}