
package Moves;

import main.Board;

public class King
{
    public static boolean kingCheck(final int x1, final int y1, final int x2, final int y2, final boolean w) {
        System.out.println("trying to move the king from: " + x1 + "," + y1 + " to " + x2 + "," + y2);
        if (w && Math.abs(x1 - x2) <= 1 && Math.abs(y1 - y2) <= 1 && !Character.isUpperCase(Board.board[y2][x2].charAt(0))) {
            return true;
        }
        if (x1 == 4 && y1 == 7 && (x2 == 6 & y2 == 7) && (!MoveMaker.whiteKing || !MoveMaker.whiteHRook) && Board.board[7][5].equals(" ") && Board.board[7][6].equals(" ")) {
            Board.board[7][5] = "R";
            Board.board[7][7] = " ";
            return true;
        }
        if (x1 == 4 && y1 == 7 && (x2 == 2 & y2 == 7) && (!MoveMaker.whiteKing || !MoveMaker.whiteARook) && Board.board[7][1].equals(" ") && Board.board[7][2].equals(" ") && Board.board[7][3].equals(" ")) {
            Board.board[7][3] = "R";
            Board.board[7][0] = " ";
            return true;
        }
        if (!w && Math.abs(x1 - x2) <= 1 && Math.abs(y1 - y2) <= 1 && !Character.isLowerCase(Board.board[y2][x2].charAt(0))) {
            return true;
        }
        if (x1 == 4 && y1 == 0 && (x2 == 6 & y2 == 0) && (!MoveMaker.blacking || !MoveMaker.blackHRook) && Board.board[0][5].equals(" ") && Board.board[0][6].equals(" ")) {
            Board.board[0][5] = "r";
            Board.board[0][7] = " ";
            return true;
        }
        if (x1 == 4 && y1 == 0 && (x2 == 2 & y2 == 0) && (!MoveMaker.whiteKing || !MoveMaker.whiteARook) && Board.board[0][1].equals(" ") && Board.board[0][2].equals(" ") && Board.board[0][3].equals(" ")) {
            Board.board[0][3] = "r";
            Board.board[0][0] = " ";
            return true;
        }
        return false;
    }
}
