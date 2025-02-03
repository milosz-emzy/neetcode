import org.junit.jupiter.api.Test;

import java.util.HashSet;

import static org.assertj.core.api.Assertions.*;

public class SudokuValidatorTest {

    @Test
    void testValidator() {
        assertThat(isValidSudoku(getValidBoard())).isTrue();
        assertThat(isValidSudoku(getInvalidBoard())).isFalse();
    }

    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            HashSet<Character> row = new HashSet<>();
            HashSet<Character> column = new HashSet<>();
            HashSet<Character> square = new HashSet<>();
            for (int j = 0; j < board[i].length; j++) {
                char cx = board[i][j];
                char cy = board[j][i];

                int squareRowIndex = 3 * (i / 3) + (j / 3);
                int squareColumnIndex = 3 * (i % 3) + (j % 3);
                char cz = board[squareRowIndex][squareColumnIndex];

                if (ifCharExists(cx, row)) return false;
                if (ifCharExists(cy, column)) return false;
                if (ifCharExists(cz, square)) return false;
            }
        }

        return true;
    }

    private static boolean ifCharExists(char cz, HashSet<Character> square) {
        if (cz != '.') {
            boolean add = square.add(cz);
            if (!add) return true;
        }
        return false;
    }


    private char[][] getValidBoard() {
        return new char[][]{{'1', '2', '.', '.', '3', '.', '.', '.', '.'},
                {'4', '.', '.', '5', '.', '.', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '.', '3'},
                {'5', '.', '.', '.', '6', '.', '.', '.', '4'},
                {'.', '.', '.', '8', '.', '3', '.', '.', '5'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '.', '.', '.', '.', '.', '2', '.', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '8'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};
    }

    private char[][] getInvalidBoard() {
        return new char[][]{{'1', '2', '.', '.', '3', '.', '.', '.', '.'},
                {'4', '.', '.', '5', '.', '.', '.', '.', '.'},
                {'.', '9', '1', '.', '.', '.', '.', '.', '3'},
                {'5', '.', '.', '.', '6', '.', '.', '.', '4'},
                {'.', '.', '.', '8', '.', '3', '.', '.', '5'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '.', '.', '.', '.', '.', '2', '.', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '8'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};
    }
}
