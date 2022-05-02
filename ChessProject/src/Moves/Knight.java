
package Moves;

import main.Board;

public class Knight
{
    public static boolean KnightCheck(final int x1, final int y1, final int x2, final int y2, final Boolean w) {
        return (!w || !Character.isUpperCase(Board.board[y2][x2].charAt(0))) && (w || !Character.isLowerCase(Board.board[y2][x2].charAt(0))) && ((Math.abs(x1 - x2) == 2 && Math.abs(y1 - y2) == 1) || (Math.abs(x1 - x2) == 1 && Math.abs(y1 - y2) == 2));
    }
}
