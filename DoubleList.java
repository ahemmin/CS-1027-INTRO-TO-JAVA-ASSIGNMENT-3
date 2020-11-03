/**
 * Class determines the characteristics of a doubly linked list including all operations that can be performed upon one
 * @author Hemming
 *
 * @param <T> Generic Type
 */
public class DoubleList<T> {
	private DoubleNode<T> head; 
	private DoubleNode<T> rear;
	private int numDataItems;
	
/**
 * Constructor initializes instance variables of list (head = rear = null and # nodes = 0)
 */
public DoubleList() {
	head = null;
	rear = null;
	numDataItems = 0;
}

/**
 * Method adds a user desired node to the doubly linked list at a index with a desired contents
 * @param index The user's desired position of node in the doubly linked list
 * @param newData The user's desired contents of the added node
 * @throws InvalidPositionException Exception meant to catch invalid inputs
 */
public void addData(int index, T newData) throws InvalidPositionException {
	boolean indicator = true;
	if (index < 0 || index > numDataItems) {
		throw new InvalidPositionException("The index is invalid");
		}
	if (numDataItems == 0 && indicator) {
		DoubleNode<T> newNode = new DoubleNode(newData);
		numDataItems++;
		head = newNode;
		rear = newNode;
		indicator = false;
	}
	if (index == 0 && numDataItems != 0 && indicator) {
		DoubleNode<T> newNode = new DoubleNode(newData);
		newNode.setNext(head);
		head = newNode;
		numDataItems++;
		indicator = false;
	}
	if (index != 0 && index == numDataItems && indicator) {
		DoubleNode<T> newNode = new DoubleNode(newData);
		rear.setNext(newNode);
		newNode.setPrev(rear);
		rear = newNode;
		numDataItems++;
		indicator = false;
	}
	if (index > 0 && index < numDataItems && indicator) {
		DoubleNode<T> newNode = new DoubleNode(newData);
		DoubleNode<T> prevNode = getNode(index-1);
		DoubleNode<T> nextNode = prevNode.getNext();
		prevNode.setNext(newNode);
		newNode.setPrev(prevNode);
		nextNode.setPrev(newNode);
		newNode.setNext(nextNode);
		numDataItems++;
		indicator = false;
	}
}

/**
 * Method returns the node at a user's desired index
 * @param index The user's desired index
 * @return temp The user's desired node at a given index 
 * @throws InvalidPositionException Exception used to catch invalid input
 */
public DoubleNode<T> getNode(int index) throws InvalidPositionException {
	int counter = 0;
	DoubleNode<T> temp = head;
	if (index < 0 || index >= numDataItems) {
		throw new InvalidPositionException("Sorry this index does not exist");
	}
	if (index == 0) {
		return head;
	}
	if (index == numDataItems - 1) {
		return rear;
	}
	while (index != counter) {
		temp = temp.getNext();
		counter++;
	}
	return temp;
}

/**
 * Method removes a node from a doubly linked list at a desired index
 * @param index The user's desired index
 * @throws InvalidPositionException Exception used to catch invalid input
 */
public void removeData(int index) throws InvalidPositionException {
	boolean indicator2 = true;
	if (index < 0 || index >= numDataItems && indicator2) {
		throw new InvalidPositionException("Sorry this index does not exist");
	}
	if (index == 0 && indicator2 && numDataItems == 1) {
		head.setData(null);
		head.setNext(null);
		rear.setPrev(null);
		head = null;
		rear = null;
		numDataItems--;
		indicator2 = false;
	}
	if (index == 0 && indicator2) {
		head = head.getNext();
		head.setPrev(null);
		numDataItems--;
		indicator2 = false;
	}
	if (index == numDataItems-1 && indicator2) {
		getNode(index-1).setNext(null);
		rear = getNode(index-1);
		numDataItems--;
		indicator2 = false;
	}
	if (index > 0 && index < numDataItems-1 && indicator2) {
		getNode(index-1).setNext(getNode(index+1));
		getNode(index+1).setPrev(getNode(index-1));
		numDataItems--;
		indicator2 = false;
	}	
}

/**
 * Method returns contents of a user specified node
 * @param index The user's desired index
 * @return getNode(index).getData() Contents of node
 * @throws InvalidPositionException Exception used to catch invalid input
 */
public T getData(int index) throws InvalidPositionException {
	if (index < 0 || index >= numDataItems) {
		throw new InvalidPositionException("Sorry this index does not exist");
	}
	return getNode(index).getData();
}

/**
 * Method sets contents of a user specified node
 * @param index The user's desired index
 * @param newData The user's specified object of any generic type
 * @throws InvalidPositionException Exception used to catch invalid input
 */
public void setData(int index, T newData) throws InvalidPositionException {
	if (index < 0 || index >= numDataItems) {
		throw new InvalidPositionException("Sorry this index does not exist");
	}
	getNode(index).setData(newData);
}
}
