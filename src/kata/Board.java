package kata;

public class Board {

	public Character[] squares = new Character[9];
	Character lastLetter = null;
	
	public void addLetter(Character letter, int row, int col) {
		if (letterIsAllowed(letter, row, col)) {
			squares[cellFrom(row, col)] = letter;
			lastLetter = letter;
		}
	}
	
	private Boolean letterIsAllowed(Character letter, int row, int col) {
		return 
			(letter == 'o' || letter == 'x') && 
			lastLetter != letter && 
			squares[cellFrom(row, col)] == null && 
			winner() == null;
	}

	public Integer numberOfLetters() {
		int letterCount = 0;
		for(int i = 0; i < squares.length; i++) {
			if (squares[i] != null) {
				letterCount++;
			}
		}
		return letterCount;
	}
	
	private Integer cellFrom(int row, int col) {
		return ((row * 3) + col);
	}

	public Character winner() {
		if (squares[4] != null &&
			((squares[4] == squares[0] && squares[4] == squares[8]) ||   // downhill diagonal
			 (squares[4] == squares[2] && squares[4] == squares[6]) ||   // uphill diagonal
			 (squares[4] == squares[1] && squares[4] == squares[7]) ||   // center column
			 (squares[4] == squares[3] && squares[4] == squares[5]) )) { // center row
			return squares[4];
		} else if (squares[0] != null &&
			((squares[0] == squares[3] && squares[0] == squares[6]) ||   // first column
			 (squares[0] == squares[1] && squares[0] == squares[2]) )) { // first row
			return squares[0];
		} else if (squares[8] != null &&
			((squares[8] == squares[5] && squares[8] == squares[2]) ||   // last column
			 (squares[8] == squares[7] && squares[8] == squares[6]) )) { // last row
			return squares[8];
		} else {
			return null;
		}
	}

}
