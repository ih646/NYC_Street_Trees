import java.util.ArrayList;
import java.util.Collection;
/**The Class that stores the Tree Objects in a BST
 * 
 * @author Imtiaz Haque
 * @version 04/22/2017
 */
public class TreeCollection extends MyBST<Tree> {


	private int count;
	//contains the name of all the species
	private ArrayList<String> species=new ArrayList<String>();
	//contains the names for all the boroughs
	private ArrayList<String> boroname=new ArrayList<String>();
	//contains the number of trees in the boroughs
	private ArrayList<Integer> boroCount=new ArrayList<Integer>();

	public TreeCollection(){

	}

	/**Adds the specified Tree bbject to the BST
	 * @param Tree object to be added to BST
	 * @return true if Tree object added succesfully, false if already present in BST
	 */
	public boolean add(Tree item){
		if(item==null){
			throw new NullPointerException("Tree Object cannot be null");
		}
		else if(contains(item)){
			return false;
		}
		else{
			if(!species.contains(item.getSpc_common())){

				species.add(item.getSpc_common());
			}
			if(!boroname.contains(item.getBoroname())){
				boroname.add(item.getBoroname());
				boroCount.add(new Integer(1));
			}
			else{

				Integer temp=boroCount.get(boroname.indexOf(item.getBoroname()));
				temp++;
				boroCount.set(boroname.indexOf(item.getBoroname()), temp);

			}
		}

		count++;
		return super.add(item);

	}
	/**Gets the total number of trees in the BST
	 * @param no parameters
	 * 
	 * @return an int value of the total number of trees in list
	 */

	public int getTotalNumberOfTrees(){
		return count;

	}
	/**Gets the total number of trees in the list which are located in a particular borough
	 * @param boroname the borough in which the total number of trees are to be counted
	 * 
	 * @return an int value of the total number of matching trees in list
	 */
	public int getCountByBorough ( String boroName ){
		int boroCounter=0;
		for(int i=0;i<boroname.size();i++){
			if(this.boroname.get(i).equalsIgnoreCase(boroName)){
				boroCounter=boroCount.get(i);
				return boroCounter;
			}

		}
		return boroCounter;
	}
	/**Gets the total number of trees in the list which matches a particular species name
	 * @param speciesName  the tree species to be counted
	 * 
	 * @return an int value of the total number of matching trees in list
	 */

	public int getCountByTreeSpecies ( String speciesName ){
		int count=0;

		for(int i=0;i<species.size();i++){
			if(species.get(i).toLowerCase().contains(speciesName.toLowerCase())){
				count=count+helperCountbyTreeSpecies(root, species.get(i));
			}

		}
		return count;
	}
	/**helper method for getCountbyTreeSpecies
	 * 
	 * @param node First reference node
	 * @param speciesName species to searched for
	 * @return total number of specified species in BST
	 */
	private int helperCountbyTreeSpecies(BSTNode <Tree> node, String speciesName){
		if(node==null){
			return 0;
		}

		if(node.getData().getSpc_common().equalsIgnoreCase(speciesName)){

			return 1+helperCountbyTreeSpecies(node.getLeft(),speciesName)+
					helperCountbyTreeSpecies(node.getRight(),speciesName);

		}
		else if(node.getData().getSpc_common().compareToIgnoreCase(speciesName)>=1){
			return	helperCountbyTreeSpecies(node.getLeft(),speciesName);
		}
		else{
			return helperCountbyTreeSpecies(node.getRight(),speciesName);
		}

	}



	/**Returns an ArrayList of the matching species specified by the user
	 * 
	 * @param speciesName Species to be searched for
	 * @return ArrayList<String> of the matching species
	 */
	public Collection<String> getMatchingSpecies(String speciesName){
		ArrayList <String> speciesList=new ArrayList<String>();
		for(int i=0;i<species.size();i++){
			if(species.get(i).toLowerCase().contains(speciesName.toLowerCase())){
				speciesList.add(species.get(i));
			}

		}

		return speciesList;

	}

	/**Gets the total number of trees in the BST which are located in a particular borough
	 * and with a specific species name
	 * @param boroname the borough in which the total number of trees are to be counted,
	 * 		  speciesName  the species to be searched for
	 * @return an int value of the total number of matching trees in list
	 */
	public int getCountByTreeSpeciesBorough ( String speciesName, String boroName ){
		int count=0;
		for(int i=0;i<species.size();i++){
			if(species.get(i).toLowerCase().contains(speciesName.toLowerCase())){
				count=count+helperCountbyTreeSpeciesBorough(root,species.get(i), boroName);
			}
		}
		return count;
	}
	/**helper method for getCountbyTreeSpeciesBorough
	 * 
	 * @param node First reference node
	 * @param speciesName species to searched for
	 * @param boroName borough to be searched for
	 * @return total number of specified species in BST
	 */
	private int helperCountbyTreeSpeciesBorough(BSTNode <Tree> node, String speciesName, String boroName){

		if(node==null){
			return 0;
		}

		if(node.getData().getSpc_common().equalsIgnoreCase(speciesName) && node.getData().getBoroname().equalsIgnoreCase(boroName)){


			return 1+helperCountbyTreeSpeciesBorough(node.getLeft(),speciesName,boroName)+
					helperCountbyTreeSpeciesBorough(node.getRight(),speciesName,boroName);
		}
		else if(node.getData().getSpc_common().equalsIgnoreCase(speciesName.toLowerCase())){
			return  helperCountbyTreeSpeciesBorough(node.getLeft(),speciesName,boroName)+
					helperCountbyTreeSpeciesBorough(node.getRight(),speciesName,boroName);
		}
		else if(node.getData().getSpc_common().compareToIgnoreCase(speciesName)>=1){
			return	helperCountbyTreeSpeciesBorough(node.getLeft(),speciesName,boroName);
		}
		else{
			return helperCountbyTreeSpeciesBorough(node.getRight(),speciesName,boroName);
		}
	}


	/**Displays the total number of trees in the list as a String
	 * 
	 * @param no parameters needed
	 * 
	 * @return String which displays the total number of trees in BST.
	 * 
	 * 
	 */
	@Override
	public String toString(){
		return "this list has a total number of "+getTotalNumberOfTrees()+" trees";
	}



}
