
package Moves;

import main.Board;

public class Pawn
{
    public static boolean PawnCheck(final int x1, final int y1, final int x2, final int y2, final Boolean w) {
        return (w && x1 == x2 && y1 - 1 == y2 && Board.board[y2][x2].equals(" ")) || (w && y1 == 6 && y2 == 4 && x1 == x2 && Board.board[y2][x2].equals(" ") && Board.board[y2 + 1][x2].equals(" ")) || (w && Math.abs(x1 - x2) == 1 && y1 - 1 == y2 && Character.isLowerCase(Board.board[y2][x2].charAt(0))) || (!w && x1 == x2 && y1 + 1 == y2 && Board.board[y2][x2].equals(" ")) || (!w && y1 == 1 && y2 == 3 && x1 == x2 && Board.board[y2][x2].equals(" ") && Board.board[y2 - 1][x2].equals(" ")) || (!w && Math.abs(x1 - x2) == 1 && y1 + 1 == y2 && Character.isUpperCase(Board.board[y2][x2].charAt(0)));
    }
}
