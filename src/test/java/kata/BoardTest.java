package kata;

import org.junit.Before;
import org.junit.Test;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

// This is version 1 of this comment
public class BoardTest  {
	
	Board board = null;
	
	@Before
	public void setUp() throws Exception {
      board = new Board();
	}
	
	@Test
	public void itShouldNumberOfLettersShouldInitiallyBeZero() {
		assertThat(board.numberOfLetters(), is(equalTo(0)));
	}
	@Test
	public void itShouldAllowAddingO() {
		board.addLetter('o', 0, 0);
		assertThat(board.numberOfLetters(), is(equalTo(1)));
	}
	@Test
	public void itShouldAllowAddingX() {
		board.addLetter('x', 0, 0);
		assertThat(board.numberOfLetters(), is(equalTo(1)));
	}
	@Test
	public void itShouldNotAllowNonXOLetter() {
		board.addLetter('w', 0, 0);
		assertThat(board.numberOfLetters(), is(equalTo(0)));
        board.addLetter('a', 1, 1);
        assertThat(board.numberOfLetters(), is(equalTo(0)));
	}
	@Test
	public void itShouldNotAllowAddingMoreThanOneLetter() {
		board.addLetter('x', 0, 0);
		board.addLetter('o', 1, 0);
		assertThat(board.numberOfLetters(), is(equalTo(2)));
	}
	@Test
	public void itShouldOnlyAllowAddingAlternateLetter() {
		board.addLetter('x', 0, 0);
		board.addLetter('x', 0, 1);
		assertThat(board.numberOfLetters(), is(equalTo(1)));
		board.addLetter('o', 1, 1);
		assertThat(board.numberOfLetters(), is(equalTo(2)));
		board.addLetter('o', 1, 2);
		assertThat(board.numberOfLetters(), is(equalTo(2)));
	}
	@Test
	public void itShouldNotAllowAddingLetterToPreviouslyFilledSquare() {
		board.addLetter('x', 0, 0);
		board.addLetter('o', 0, 0);
		assertThat(board.numberOfLetters(), is(equalTo(1)));
	}
	@Test
	public void itShouldReportNoWinnerIfNobodyHasWon() {
		board.addLetter('x', 0, 0);
		board.addLetter('o', 0, 1);
		assertThat(board.winner(), is(equalTo(null)));
	}
	@Test
	public void itShouldReportWinnerWhenXFillsFirstRow() {
		board.squares[0] = 'x';
		board.squares[1] = 'x';
		board.squares[2] = 'x';
		assertThat(board.winner(), is(equalTo('x')));
	}
	@Test
	public void itShouldReportWinnerWhenXFillsSecondRow() {
		board.squares[3] = 'x';
		board.squares[4] = 'x';
		board.squares[5] = 'x';
		assertThat(board.winner(), is(equalTo('x')));
	}
	@Test
	public void itShouldReportWinnerWhenXFillsThirdRow() {
		board.squares[6] = 'x';
		board.squares[7] = 'x';
		board.squares[8] = 'x';
		assertThat(board.winner(), is(equalTo('x')));
	}
	@Test
	public void itShouldReportWinnerWhenXFillsFirstColumn() {
		board.squares[0] = 'x';
		board.squares[3] = 'x';
		board.squares[6] = 'x';
		assertThat(board.winner(), is(equalTo('x')));
	}
	@Test
	public void itShouldReportWinnerWhenXFillsSecondColumn() {
		board.squares[1] = 'x';
		board.squares[4] = 'x';
		board.squares[7] = 'x';
		assertThat(board.winner(), is(equalTo('x')));
	}
	@Test
	public void itShouldReportWinnerWhenXFillsThirdColumn() {
		board.squares[2] = 'x';
		board.squares[5] = 'x';
		board.squares[8] = 'x';
		assertThat(board.winner(), is(equalTo('x')));
	}
	@Test
	public void itShouldReportWinnerWhenXFillsDownhillDiagonal() {
		board.squares[0] = 'x';
		board.squares[4] = 'x';
		board.squares[8] = 'x';
		assertThat(board.winner(), is(equalTo('x')));
	}
	@Test
	public void itShouldReportWinnerWhenXFillsUphillDiagonal() {
		board.squares[2] = 'x';
		board.squares[4] = 'x';
		board.squares[6] = 'x';
		assertThat(board.winner(), is(equalTo('x')));
	}
	@Test 
	public void isShouldNotAddAnotherLetterIfThereIsAwinner() {
		board.squares[0] = 'o';
		board.squares[1] = 'o';
		board.squares[2] = 'o';
		assertThat(board.numberOfLetters(), is(equalTo(3)));
		board.addLetter('x', 2, 2);
		assertThat(board.numberOfLetters(), is(equalTo(3)));
	}
}
