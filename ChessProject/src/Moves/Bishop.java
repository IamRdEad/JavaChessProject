
package Moves;

import main.Board;

public class Bishop
{
    public static boolean bishopCheck(final int x1, final int y1, final int x2, final int y2, final boolean w) {
        int xDir;
        if (x1 > x2) {
            xDir = -1;
        }
        else {
            xDir = 1;
        }
        int yDir;
        if (y1 > y2) {
            yDir = -1;
        }
        else {
            yDir = 1;
        }
        if (w && Math.abs(x1 - x2) == Math.abs(y2 - y1) && !Character.isUpperCase(Board.board[y2][x2].charAt(0))) {
            for (int amount = Math.abs(x1 - x2), i = 1; i < amount; ++i) {
                System.out.println(Board.board[y1 + i * yDir][x1 + i * xDir]);
                if (!Board.board[y1 + i * yDir][x1 + i * xDir].equals(" ")) {
                    return false;
                }
            }
            return true;
        }
        if (!w && Math.abs(x1 - x2) == Math.abs(y2 - y1) && !Character.isLowerCase(Board.board[y2][x2].charAt(0))) {
            for (int amount = Math.abs(x1 - x2), i = 1; i < amount; ++i) {
                if (!Board.board[y1 + i * yDir][x1 + i * xDir].equals(" ")) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }
}
