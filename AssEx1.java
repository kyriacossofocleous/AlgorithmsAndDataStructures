import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

public class AssEx1 {
	/** read strings from file 
     * and add them to an array. Assume that in the file there is one string
     * per line.
     * @param filename
     * return array
     */
	public static String[] readFromFile(String fileName) {
		List<String> allLines=new ArrayList<String>();
		String[] content;
		try {
			BufferedReader br = new BufferedReader(new FileReader(fileName));
			String line;
			while ((line = br.readLine()) != null) {
			     allLines.add(line);
			  }
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		content=new String[allLines.size()];
		for (int i=0;i<content.length;i++) {
			content[i]=allLines.get(i);
		}
    	return content;
			
	}
	
	
	/**
	 * Add all of the elements of an array of Strings
	 * to a set of strings - note repeats will disappear
	 * your set should be instantiated as a TreeSet (see lecture 1)
	 */
	
	public static Set<String> arrayToSet(String[] myArray){
		Set <String> content=new TreeSet<String>();
		for (int i=0;i<myArray.length;i++) {
			content.add(myArray[i]);
		}
		return content; // replace this with your implementation 
		
	}
	
	
	/** randomly re-order an array
	 * 
	 * @param origArray
	 */
	public static void jumbleArray(String[] origArray){
		Random r=new Random();
		String temp="";
		for (int i=0;i<origArray.length;i++) {
			int a=r.nextInt(origArray.length);
			temp=origArray[i];
			origArray[i]=origArray[a];
			origArray[a]=temp;
		}
		return; //replace this with your implementation
		
	}
	
	/** create a string consisting all of the elements in an array,
	 * one element per row.
	 * Use a for--each loop to return them in the order in which they 
	 * are stored
	 */
	public static String arrayToString(String[] stringArray){
		StringBuilder content=new StringBuilder();
		for (int i=0;i<stringArray.length;i++) {
			content.append(stringArray[i]+" ");
		}
		content.append("\n");
		return content.toString(); //replace this with your implementation
		
	}
	
	/** create a string consisting of all of the elements in a set,
	 * one element per row.
	 * Use a for--each loop to return them in the order in which they 
	 * are stored
	 */
	public static String setToString(Set<String> stringSet){
		StringBuilder content=new StringBuilder();
		for (String str : stringSet) {
			content.append(str+" ");
		}
		content.append("\n");
		return content.toString(); //replace this with your implementation
		
	}
	
	
	
	/**
	 * main method - do not edit this
	 * @param args
	 */
	public static void main(String[] args){
		String fileName = args[0];
		String[] originalArray = readFromFile(fileName);
		System.out.println("the array has length " + originalArray.length + "\n");
		String[] newArray1 = originalArray.clone();
		String[] newArray2 = originalArray.clone();
		
		jumbleArray(newArray1);
		jumbleArray(newArray2);
		
		System.out.print("The original array is:\n");
		System.out.print(arrayToString(originalArray) + "\n");
		
		System.out.print("The frst jumbled array is:\n");
		System.out.print(arrayToString(newArray1) + "\n");
		System.out.print("The corresponding set is:\n");
		System.out.print(setToString(arrayToSet(newArray1))+"\n");
		
		System.out.print("The second jumbled array is:\n");
		System.out.print(arrayToString(newArray2) + "\n");
		System.out.print("The corresponding set is:\n");
		System.out.print(setToString(arrayToSet(newArray2)) + "\n");
		}
	
}