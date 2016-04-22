import java.io.FileReader;
import java.io.BufferedReader;
//import java.io.FileNotFoundException;
//import java.io.IOException;
import java.io.File;
//import java.io.Exception;

class FileTest{
	public FileTest(){
	
	}
	
	void ReadFile(String filename) {
		File theFile = new File(filename);
		if(!theFile.exists()){
			System.out.println("Bad Filename");
			System.exit(-1);
		}
		
		if(!theFile.canRead()){
			System.out.println("Couldn't Read file.");
			System.exit(-2);
		}
			
		try(BufferedReader b = new BufferedReader(new FileReader(filename))){
	
			String theLine;
			while((theLine = b.readLine())!= null){
				System.out.println(theLine);
			}
		}
		catch(Exception ex){
			System.out.println("Exception occurred " + ex.getMessage());
			System.exit(-4);
		}
	}
	public static void main(String[] args){
		if(args.length == 0){
			System.out.println("Put in a filename");
			System.exit(-3);
		}
		
		String filename = args[0];
		FileTest tester = new FileTest();
		tester.ReadFile(filename);
	}
}