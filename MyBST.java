import java.util.*;

/**The Binary search tree that connects all the nodes
 * 
 * @author Imtiaz Haque
 * @version 04/22/2017
 */
public class MyBST<E extends Comparable<E>> {
	//the reference for the root node
	protected BSTNode <E> root;


	/**Helper method for add
	 * 
	 * @param node the first reference node
	 * @param data the data to be added
	 * @return node to be added to the BST
	 */


	private BSTNode<E> recAdd(BSTNode<E> node,E data){
		if (node==null){
			node= new BSTNode<E>(data);
			return node;

		}
		else if(data.compareTo(node.getData())<0){
			node.setLeft(recAdd(node.getLeft(),data));
		}
		else {
			node.setRight(recAdd(node.getRight(),data));
		}
		return node;
	}
	/**Searches for the specified item in the BST
	 * and returns a boolean value based off the result
	 * 
	 * @param item to be checked for in the BST
	 * @return
	 * @throws NullPointerException if item is null
	 * @throws ClassCastException   if invalid Object type is passed
	 */
	@SuppressWarnings("unchecked")
	public boolean contains (Object o) throws NullPointerException,ClassCastException{
		if(o==null){
			throw new NullPointerException("Tree is empty");
		}
		return recContains(root,(E)o);
	}
	/**helper method for contains
	 * 
	 * @param node The first reference node
	 * @param data to be checked for in BST
	 * @return true if data present, false otherwise
	 */

	private boolean recContains(BSTNode<E> node, E data){
		if(node==null){
			return false;
		}
		else if(data.compareTo(node.getData())<0){
			return recContains(node.getLeft(),data);
		}
		else if(data.compareTo(node.getData())>=1){
			return recContains(node.getRight(),data);
		}
		else{
			return true;
		}
	}
	/**helper method for first
	 * 
	 * @param node First reference node
	 * @return smallest data field in the BST
	 * @throws NoSuchElementException if node is null
	 */
	private E helperFirst(BSTNode<E> node)throws NoSuchElementException{
		if(node==null ){
			throw new NoSuchElementException("Tree is empty");
		}
		else{
			BSTNode<E> current=node;
			if(node.getLeft()!=null){

				while(current.getLeft()!=null){
					current=current.getLeft();
				}
				return current.getData();
			}
			else{
				return node.getData();
			}
		}
	}
	/**helper method for last
	 * 
	 * @param node First reference node
	 * @return Largest data field in the BST
	 * @throws NoSuchElementException if node is null
	 */

	private E helperLast(BSTNode<E> node) throws NoSuchElementException{
		if(node==null){
			throw new NoSuchElementException("Tree is Empty");
		}
		else{

			BSTNode<E> current=node;
			while(current.getRight()!=null){
				current=current.getRight();
			}
			return current.getData();
		}



	}
	/**helper method for remove
	 * 
	 * @param node First reference node
	 * @param data data field to be removed
	 * @return node
	 */

	private BSTNode<E> recRemove(BSTNode<E> node, E data){
		if(data.compareTo(node.getData())>=1){
			node.setRight(recRemove(node.getRight(),data));
		}
		else if(data.compareTo(node.getData())<0){
			node.setLeft(recRemove(node.getLeft(),data));
		}
		else{
			if(node.getLeft()==null && node.getRight()==null){


				node=null;


			}
			else if(node.getRight()==null && node.getLeft()!=null){

				node=node.getLeft();
				return node;

			}
			else if(node.getLeft()==null ){

				node=node.getRight();
				return node;

			}
			else{
				E tempData=helperFirst(node.getRight());
				node.setData(tempData);
				node.setRight(recRemove(node.getRight(),tempData));


			}

		}
		return node;



	}
	/**Adds the specified item to the BST
	 * 
	 * @param item to be added
	 * @return true if item is successfully add, false if item is already present
	 * @throws NullPointerException if item is null
	 * @throws ClassCastException if invalid Object type is passed as item
	 */

	public boolean add(E e) throws NullPointerException, ClassCastException{
		if(e==null){
			throw new NullPointerException("Data cannot be null");
		}
		if(!contains(e)){
			root=recAdd(root,e);
			return true;
		}
		else return false;



	}
	/**returns the smallest data field in BST
	 * @param no parameters
	 * @return the data at the leftmost node
	 */
	public E first(){

		E data= helperFirst(root);
		return data;
	}
	/**returns the largest data field in BST
	 * @param no parameters
	 * @return the data at the rightmost node
	 */

	public E last(){

		E data= helperLast(root);
		return data;
	}

	@SuppressWarnings("unchecked") 
	/**Removes specified object from BST
	 * 
	 * @param o Object to be removed from BST
	 * @return true if Object is successfully removed, false if specified object is not present to begin with
	 * @throws NullPointerException if o is null
	 * @throws ClassCastException if o is invalid Object type
	 */
	public boolean remove (Object o)throws NullPointerException, ClassCastException{
		if(o==null){
			throw new NullPointerException("Null data cannot be removed");
		}
		else if(recContains(root, (E)o)){
			root=recRemove(root,(E)o);
			return true;
		}
		else{
			return false;
		}

	}


	/**returns a sorted represented of the BST in array format
	 * 
	 */
	@Override
	public String toString(){
		ArrayList<E>stringList=new ArrayList<E>();
		inOrder(root,stringList);
		return  stringList.toString();
	}

	/**helper method for toString that performs the in order traversal and add the data to an
	 * ArrayList
	 * 
	 * @param node First reference node
	 * @param stringList Array that stores the node Data
	 */

	private void inOrder(BSTNode <E> node, ArrayList<E>stringList){
		if(node!=null){
			inOrder(node.getLeft(),stringList);
			stringList.add(node.getData());
			inOrder(node.getRight(),stringList);
		}

	}



}
