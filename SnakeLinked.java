/**
 * Class determines the characteristics of the snake
 * @author Hemming
 *
 */
public class SnakeLinked {
	int snakeLength;
	DoubleList<Position> snakeBody;

/**
 * Constructor initializes snake by creating a doubly linked list of position objects and adding a user specified Position object to the list.  The length of the snake is also set to 1
 * @param row The user's specified row coordinate
 * @param col The user's specified column coordinate
 */
public SnakeLinked(int row, int col) {
	snakeLength = 1;
	snakeBody = (DoubleList<Position>) new DoubleList();
	Position firstNode = new Position(row, col);
	snakeBody.addData(0, firstNode);
}

/**
 * Method returns the length of the snake
 * @return snakeLength The length of the snake
 */
public int getLength() {
	return snakeLength;
}

/**
 * Method returns to position object at a user specified index
 * @param index The user's desired index
 * @return snakeBody.getData(index) The position object at the designated index
 */
public Position getPosition(int index) {
	if (index < 0 || index >= snakeLength) {
		return null;
	}
	return snakeBody.getData(index);
}

/**
 * Method determines if the snake is present at a given position
 * @param pos The user's desired position
 * @return indicator3 The boolean variable that allows user to know whether their specified position in contained within the snake or not
 */
public boolean snakePosition(Position pos) {
	boolean indicator3 = false;
	for (int i = 0; i < snakeLength ; i++) {
		Position temp3 = getPosition(i);
		if (temp3.equals(pos)) {
			indicator3 = true;
		}
	}
	return indicator3;
}

/**
 * Method determines the new head position of the snake
 * @param direction The user's desired direction of travel
 * @return Position(row, col) The new position of the snake
 */
public Position newHeadPosition(String direction) {
	Position initial_head = getPosition(0);
	int row = initial_head.getRow();
	int col = initial_head.getCol();
	if (direction == "up") {
		--row;
	}
	else if (direction == "down") {
		++row;		
	}
	else if (direction == "left") {
		--col;		
	}
	else if (direction == "right") {
		++col;
	}
	return new Position(row,col);
}

/**
 * Method moves the snake in a specified direction
 * @param direction The user's desired direction of travel
 */
public void moveSnakeLinked(String direction) {
	Position newHead = newHeadPosition(direction);
	snakeBody.addData(0, newHead);
	snakeBody.removeData(snakeLength);
}

/**
 * Method reduces the length of the snake by removing the last node in the doubly linked list
 */
public void shrink() {
	snakeBody.removeData(snakeLength-1);
	snakeLength--;
}

/**
 * Method increases the length of the snake by changing the contents of the head of the snake to the new head position determined by the user's desired dirction of travel
 * @param direction The user's desired direction of travel
 */
public void grow(String direction) {
	snakeLength++;
	Position newHead2 = newHeadPosition(direction);
	snakeBody.addData(0, newHead2);
}
}

