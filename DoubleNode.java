/**
 * Class determines the characteristics of a node in a doubly linked list
 * @author Hemming
 *
 * @param <T> Generic Type
 */
public class DoubleNode<T> {
	private DoubleNode<T> next;
	private DoubleNode<T> prev;
	private T data;
	
/**
 * Constructor given no parameters, initializes node by setting contents as well as references to previous and next nodes to null
 */
	
public DoubleNode() {
	
	next = null;
	prev = null;
	data = null;
}

/**
 * Constructor given parameter, initializes node content to parameters and references to previous and next nodes to null 
 * @param newData User's desired contents of node
 */
public DoubleNode(T newData) {
	next = null;
	prev = null;
	data = newData;
}

/**
 * Method returns the next node in the doubly linked list
 * @return next The following node to the user's desired node
 */
public DoubleNode<T> getNext() {
	return next;
}

/**
 * Method returns the previous node in the doubly linked list
 * @return previous The previous node to the user's desired node
 */
public DoubleNode<T> getPrev() {
	return prev;
}

/**
 * Method returns the contents of the user's desired node
 * @return data The object of any generic type stored in the user's desired node
 */
public T getData() {
	return data;
}

/**
 * Method sets the next node in relation to the user's desired node to a user specified node
 * @param nextNode The user's desired node
 */
public void setNext(DoubleNode<T> nextNode) {
	next = nextNode;
}

/**
 * Method sets the previous node in relation to the user's desired node to a user specified node
 * @param prevNode The user's desired node
 */
public void setPrev(DoubleNode<T> prevNode) {
	prev = prevNode;
}

/**
 * Method sets the contents of the user's desired node to a user specified object of any generic type
 * @param newData The user's specified object of any generic type
 */
public void setData(T newData) {
	data = newData;
}
}
