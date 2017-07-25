/**This is the tree class that constructs the tree objects
 * 
 * @author Imtiaz Haque
 * @version 04/22/2017
 */
public class Tree implements Comparable<Tree>{
	private int id;
	private int diam;
	private String status;
	private String health;
	private String spc_common;
	private int zipcode;
	String boroname;
	private double x_sp;
	private double y_sp;

	/**This is the tree constructor that creates the tree object
	 * @ param  unique tree  id, tree  dbh, Status (Alive or Dead), health (Good or Bad, spc_common (Species)
	 * 			zipcode  location zipcode, boroname  borough location (e.g Manhattan)
	 * 			x_sp longitude, y_sp latitude
	 * 			
	 * 
	 * @throws IllegalArgumentException if id, dbh or zipcode is less than zero.
	 *         status must be "alive","dead" or "stump"
	 *         health must be "Good", "fair" or "poor"
	 *         spc_common cannot be null
	 *         boroname must be either "Manhattan," "Brooklyn", "Queens", "Staten Island" or "Bronx"
	 */

	public Tree(int id, int diam, String status, String health, String spc_common, int zipcode, String boroname,
			double x_sp, double y_sp) throws IllegalArgumentException{


		if(health==null){
			health="";

		}
		else if(status==null){
			status="";

		}


		else if((id<0 || diam<0) || (zipcode<0 || zipcode>99999)){
			throw new IllegalArgumentException("All int arguments (id,dbh,zipcode) "
					+ " must be positive.You entered:id:"+id+" diam:"+diam+" zipcode:" +zipcode);
		}


		else if(spc_common == null){
			throw new IllegalArgumentException("Spc_common cannot be null");
		}

		else if(!(((status.equalsIgnoreCase("Stump") || status.equalsIgnoreCase("Dead")) 
				||((status.equalsIgnoreCase("Alive")) || status.isEmpty()))) ){
			throw new IllegalArgumentException("Invalid string argument. Status must be either \"Alive\",\"Dead\" or\"Stump\",empty or null");
		}

		else if(!(((health.equalsIgnoreCase("Good") || health.equalsIgnoreCase("Fair")) || (health.equalsIgnoreCase("Poor") || health.isEmpty())) 
				) ){

			throw new IllegalArgumentException("Invalid string argument. health must be either \"Good\",\"Fair\" or\"Poor\",empty or null");
		}
		else if(boroname==null){
			throw new IllegalArgumentException("Invalid string argument. boroname must be either \"Manhattan\",\"Bronx\",\"Queens\""
					+" \"Brooklyn\" or \"Staten Island\"");
		}
		else if(!(((boroname.equalsIgnoreCase("Manhattan") || boroname.equalsIgnoreCase("Brooklyn")) ||
				(boroname.equalsIgnoreCase("Queens") || boroname.equalsIgnoreCase("Bronx"))) || boroname.equalsIgnoreCase("Staten Island") )
				){
			throw new IllegalArgumentException("Invalid string argument. boroname must be either \"Manhattan\",\"Bronx\",\"Queens\""
					+" \"Brooklyn\" or \"Staten Island\"");
		}


		else{
			this.id = id;
			this.diam = diam;
			this.status = status;
			this.health = health;
			this.spc_common = spc_common;
			this.zipcode = zipcode;
			this.boroname = boroname;
			this.x_sp = x_sp;
			this.y_sp = y_sp;
		}

	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getDbh() {
		return diam;
	}
	public void setDbh(int dbh) {
		this.diam = diam;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getHealth() {
		return health;
	}
	public void setHealth(String health) {
		this.health = health;
	}
	public String getSpc_common() {
		return spc_common;
	}
	public void setSpc_common(String spc_common) {
		this.spc_common = spc_common;

	}
	public int getZipcode() {
		return zipcode;
	}
	public void setZipcode(int zipcode) {
		this.zipcode = zipcode;
	}
	public String getBoroname() {
		return boroname;
	}
	public void setBoroname(String boroname) {
		this.boroname = boroname;
	}
	public double getX_sp() {
		return x_sp;
	}
	public void setX_sp(int x_sp) {
		this.x_sp = x_sp;
	}
	public double getY_sp() {
		return y_sp;
	}
	public void setY_sp(int y_sp) {
		this.y_sp = y_sp;
	}
	/**Checks whether two tree objects are the same
	 * 
	 * @ param tree takes in a tree object
	 * 
	 * @return true or false
	 * 
	 * @throws IllegalArgument exception if two trees have same id but different species name.
	 * 
	 */
	@Override
	public boolean equals(Object tree) throws IllegalArgumentException{
		if (!(tree instanceof Tree)) return false;
		Tree tree1 = (Tree) tree;


		if(getSpc_common().equalsIgnoreCase(tree1.getSpc_common()) && getId()==tree1.getId()){
			return true;
		}
		else if((!(getSpc_common().equalsIgnoreCase(tree1.getSpc_common()))) && getId()==tree1.getId()){
			throw new IllegalArgumentException("Two trees cannot have the same id's with different species names.");
		}
		else{
			return false;
		}

	}
	/**Compares two tree objects with species name as primary key and id as secondary key
	 * 
	 * @param tree takes in a tree object
	 * 
	 * @return int 1,-1 or 0
	 * 
	 * 
	 */
	@Override
	public int compareTo(Tree tree){
		if(this.getSpc_common().compareToIgnoreCase(tree.getSpc_common())>0 ){

			return 1;
		}
		else if(this.getSpc_common().compareToIgnoreCase(tree.getSpc_common())<0 ){

			return -1;
		}
		else if(this.getId()>tree.getId()){
			return 1;
		}
		else if(this.getSpc_common().compareToIgnoreCase(tree.getSpc_common())==0 && this.getId()==tree.getId()){
			return 0;
		}
		else{
			return -1;
		}
	}
	/**Compares the species name of two tree objects and returns
	 * either a positive or negative int depending on which object's name is
	 * greater lexicographically
	 * 
	 * @param t  t Tree object with the comparison is done
	 * @return int 0 if species names match, 1 if species name of t is smaller lexicographically, 
	 * -1 if species name of t is bigger lexicographically
	 */
	int compareName ( Tree t ){

		if(this.getSpc_common().compareToIgnoreCase(t.getSpc_common())>0 ){

			return 1;
		}
		else if(this.getSpc_common().equalsIgnoreCase(t.getSpc_common()) ){
			return 0;
		}
		else{
			return -1;
		}
	}
	/**Compares the name of two tree objects and returns
	 * either true if the species name is the same
	 * false otherwise
	 * 
	 * @param t Tree object with the comparison is done
	 * @return boolean true if names are the same, false otherwise
	 */
	boolean sameName ( Tree t ){
		if(this.getSpc_common().equalsIgnoreCase(t.getSpc_common())){
			return true;
		}
		else return false;
	}


	/**Displays the tree's species, id and status
	 * 
	 * @param no parameters needed
	 * 
	 * @return String 
	 * 
	 * 
	 */
	@Override
	public String toString(){
		return "This tree is of species: " +getSpc_common().toLowerCase()+" its id is "+getId()+" and its status is "+getStatus().toLowerCase();
	}



}