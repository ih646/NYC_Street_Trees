
/**
 * @author Imtiaz Haque
 * @version 04/22/2017
 * 
 * This is the BSTNode class which stores the data in the BST
 */
public class BSTNode <E extends Comparable<E>> implements Comparable <BSTNode <E>> {

	private E data;
	private BSTNode <E> left;
	private BSTNode <E> right;
	public BSTNode (E data){
		this.data=data;
	}
	/**Compares the data between two nodes and returns either 0, positive or 
	 * negative int based off of the result.
	 * 
	 * (non-Javadoc)
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	public int compareTo(BSTNode <E> other){
		return this.data.compareTo(other.data);

	}

	public BSTNode<E> getLeft() {
		return left;
	}

	public void setLeft(BSTNode<E> left) {
		this.left = left;
	}

	public BSTNode<E> getRight() {
		return right;
	}

	public void setData(E data) {
		this.data = data;
	}

	public E getData() {
		return data;
	}

	public void setRight(BSTNode<E> right) {
		this.right = right;
	}

}
