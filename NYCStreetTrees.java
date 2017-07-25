import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**The main class that reads the CSV file
 * @author Imtiaz Haque
 * @version 04/22/2017
 * 
 */
public class NYCStreetTrees {




	@SuppressWarnings("resource")
	public static void main(String[] args) {
		Scanner input=null;
		Scanner treeFile=null;
		File file = null;

		TreeCollection List=new TreeCollection();
		try{
			file = new File(args[0]);
		}

		catch ( Exception e) {
			// TODO Auto-generated catch block
			if(args.length==0){
				System.err.println("Input error: No file entered");
				System.exit(1);
			}
			if(!file.exists()){
				System.err.println("This file does not exist or is invalid");
			}
		}


		try{
			treeFile=new Scanner(file);
			treeFile.nextLine();
		}
		catch(FileNotFoundException e){
			System.err.println("Invalid file entered or the file may not exist.");

		}


		Tree tree;
		// The while loop creates the tree list containing all the trees in the CSV file
		while(treeFile.hasNextLine()){

			ArrayList<String> data=splitCSVLine(treeFile.nextLine());
			int tree_id=Integer.parseInt(data.get(0));
			int dbh=Integer.parseInt(data.get(3));
			String status=data.get(6);
			String health=data.get(7);
			String spc=data.get(9);
			int zipcode=Integer.parseInt(data.get(25));
			String borough=data.get(29);
			double x_sp=Double.parseDouble(data.get(39));
			double y_sp=Double.parseDouble(data.get(40));
			try{
				tree=new Tree(tree_id,dbh,status,health,spc,zipcode,borough,x_sp,y_sp);
				List.add(tree);

			}
			catch ( IllegalArgumentException e) {



			}

			catch ( Exception e) {
				// TODO Auto-generated catch block

				System.err.println("May have encountered an unexpected error");


			}
		}

		// This while loop keeps on running the main program until the user types "quit"
		while(true){
			System.out.println("Enter the tree species to learn more about it ('quit' to stop):");
			input = new Scanner(System.in);
			String species=input.nextLine();

			//the if statement breaks the loop when "quit" is typed as species argument
			if(species.equalsIgnoreCase("quit")){
				break;
			}


			// else if statement checks to if there are any matching species.	
			else if(List.getCountByTreeSpecies(species.toLowerCase())==0){
				System.out.println("The species: "+species+" does not exist\n");
			}
			//displays the tree popularity
			else{
				System.out.println("All matching species:\n");
				ArrayList<String> commonSpecies=(ArrayList<String>) List.getMatchingSpecies(species);
				for(int i=0;i<commonSpecies.size();i++){
					System.out.println(commonSpecies.get(i));	
				}

				System.out.println("\n\nPopularity in the city:");


				treePopularityNY(List,species);

				treePopularityBorough( List, species,"Manhattan");

				treePopularityBorough(List,species,"Bronx");

				treePopularityBorough(List,species,"Brooklyn");

				treePopularityBorough(List,species,"Queens");

				treePopularityBorough(List,species,"Staten Island");

				System.out.println("");


			}
		}

		System.exit(0);

	}

	/** dispalys the tree popularity of a certain species in NY
	 * 
	 * @param  TreeCollection  the BST containing the Tree Objects
	 * 		   species   the species to be searched for
	 * 
	 * @ return prints out a string which shows the total number of mathching species, the total number of trees in NY
	 * 			and the percentage popularity
	 */

	public static void treePopularityNY(TreeCollection List, String species){

		double percentagePopularity=(100*((double)List.getCountByTreeSpecies(species))/(double)List.getTotalNumberOfTrees());
		String s="NYC";
		System.out.printf("%15s: %15d (%6d)  %10.3f %% \n",s,List.getCountByTreeSpecies(species),List.getTotalNumberOfTrees(),
				percentagePopularity);

	}
	/** displays the tree popularity of a certain species in a certain borough
	 * 
	 * @param  TreeCollection  the BST containing the Tree Objects
	 * 		   species   the species to be searched for
	 * 		   borough   the borough to be searched
	 * @ return prints out a string which shows the total number of mathching species
	 * 			in the specified borough, the total number of trees in the borough
	 * 			and the percentage popularity
	 * 
	 */

	public static void treePopularityBorough(TreeCollection List, String species,String borough){

		double percentagePopularity=100*((double)List.getCountByTreeSpeciesBorough(species, borough))/
				(double)List.getCountByBorough(borough);

		System.out.printf("%15s: %15d (%6d)  %10.3f %% \n",borough, List.getCountByTreeSpeciesBorough(species, borough)
				,List.getCountByBorough(borough),percentagePopularity);
	}



	/**
	 * Splits the given line of a CSV file according to commas and double quotes
	 * (double quotes are used to surround  multi-word entries that may contain commas). 
	 * 
	 * @param textLine  line of text to be parsed
	 * @return an ArrayList object containing all individual entries/tokens
	 *         found on the line.
	 */
	public static ArrayList<String> splitCSVLine(String textLine) {
		ArrayList<String> entries = new ArrayList<String>();
		int lineLength = textLine.length();
		StringBuffer nextWord = new StringBuffer();
		char nextChar;
		boolean insideQuotes = false;
		boolean insideEntry= false;

		//iterate over all characters in the textLine
		for (int i = 0; i < lineLength; i++) {
			nextChar = textLine.charAt(i);

			//handle smart quotes as well as regular quotes 
			if (nextChar == '"' || nextChar == '\u201C' || nextChar =='\u201D') { 
				//change insideQuotes flag when nextChar is a quote
				if (insideQuotes) {
					insideQuotes = false;
					insideEntry = false; 
				}
				else {
					insideQuotes = true; 
					insideEntry = true; 
				}
			}
			else if (Character.isWhitespace(nextChar)) {
				if  ( insideQuotes || insideEntry ) {
					// add it to the current entry
					nextWord.append( nextChar );
				}
				else  { // skip all spaces between entries 
					continue;
				}
			}
			else if ( nextChar == ',') {
				if (insideQuotes) //comma inside an entry 
					nextWord.append(nextChar);
				else { //end of entry found 
					insideEntry = false; 
					entries.add(nextWord.toString());
					nextWord = new StringBuffer();
				}
			}
			else {
				//add all other characters to the nextWord 
				nextWord.append(nextChar);
				insideEntry = true; 
			}

		}
		// add the last word (assuming not empty)
		// trim the white space before adding to the list
		if (!nextWord.toString().equals("")) {
			entries.add(nextWord.toString().trim());
		}

		return entries;
	}

}
