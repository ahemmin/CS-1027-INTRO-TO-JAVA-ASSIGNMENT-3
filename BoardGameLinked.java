/**
 * Class determines the characteristics of the game board
 * @author Hemming
 *
 */
public class BoardGameLinked {
	int boardLength;
	int boardWidth;
	SnakeLinked theSnake;
	DoubleList<String>[] board;

/**
 * Constructor opens and reads file, creates an array of doubly linked lists and initializes initial game blocks including the initial position of the snake 
 * @param boardFile
 */
public BoardGameLinked(String boardFile) {
	MyFileReader Line = new MyFileReader(boardFile);
	 Line.readInt();
	 Line.readInt();
	 boardLength = Line.readInt();
	 boardWidth = Line.readInt();
	 board = (DoubleList<String>[]) new DoubleList[boardWidth];
	 int row = Line.readInt();
	 int col = Line.readInt();
	 theSnake = new SnakeLinked(row,col);
	 
	for (int i = 0 ; i < boardWidth ; i++) {
		DoubleList<String> list = new DoubleList();
		board[i] = list;
		for (int j = 0 ; j < boardLength ; j++) {
			board[i].addData(j, "empty");
		}
		 }
	 while (Line.endOfFile() == false) {
	  row = Line.readInt();
	  col = Line.readInt();
	  String Object_Type = Line.readString();
	  board[row].setData(col, Object_Type);
	 }
	}

/**
 * Method returns contents of a game block
 * @param row The user's specified row coordinate
 * @param col The user's specified column coordinate
 * @return board[row].getData(col) Contents of the game block
 * @throws InvalidPositionException
 */
public String getObject(int row, int col) throws InvalidPositionException {
	if (row < 0 || col < 0 || row >= boardWidth || col >= boardLength) {
		throw new InvalidPositionException("Sorry an object does not exist at your specified indicies");
	}
	 return board[row].getData(col);
}

/**
 * Method sets contents of desired game block to a user specified object of any generic type
 * @param row The user's specified row coordinate
 * @param col The user's specified column coordinate
 * @param newObject The user specified object of any generic type 
 * @throws InvalidPositionException Exception meant to catch invalid input
 */
public void setObject(int row, int col, String newObject) throws InvalidPositionException {
	if (row < 0 || col < 0 || row >= boardWidth || col >= boardLength) {
		throw new InvalidPositionException("Sorry an object does not exist at your specified indicies");
	}
	 board[row].setData(col, newObject);
}

/**
 * Method returns the snake
 * @return theSnake An object of type SnakeLinked
 */
public SnakeLinked getSnakeLinked() {
	return theSnake;
}

/**
 * Method sets the snake to a user specified object of type SnakeLinked
 * @param newSnake The user specified object of type SnakeLinked
 */
public void setSnakeLinked(SnakeLinked newSnake) {
	theSnake = newSnake;
}

/**
 * Method returns the length of the board
 * @return boardLength The length of the game board
 */
public int getLength() {
	return boardLength;
}

/**
 * Method returns the width of the board
 * @return boardWidth The width of the game board
 */
public int getWidth() {
	return boardWidth;
}
}