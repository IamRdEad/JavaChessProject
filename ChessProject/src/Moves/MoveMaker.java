
package Moves;

import main.Board;

public class MoveMaker
{
    public static boolean white;
    static boolean whiteKing;
    static boolean whiteARook;
    static boolean whiteHRook;
    static boolean blacking;
    static boolean blackARook;
    static boolean blackHRook;
    
    static {
        MoveMaker.white = true;
        MoveMaker.whiteKing = false;
        MoveMaker.whiteARook = false;
        MoveMaker.whiteHRook = false;
        MoveMaker.blacking = false;
        MoveMaker.blackARook = false;
        MoveMaker.blackHRook = false;
    }
    
    public static boolean makeMove(final int x1, final int y1, final int x2, final int y2) {
        final String piece = Board.board[y1][x1];
        if (MoveMaker.white && Character.isLowerCase(piece.charAt(0))) {
            return false;
        }
        if (!MoveMaker.white && Character.isUpperCase(piece.charAt(0))) {
            return false;
        }
        if ((piece.equals("P") || piece.equals("p")) && Pawn.PawnCheck(x1, y1, x2, y2, piece.equals("P"))) {
            Board.board[y2][x2] = Board.board[y1][x1];
            Board.board[y1][x1] = " ";
            MoveMaker.white = !MoveMaker.white;
            return true;
        }
        if ((piece.equals("K") || piece.equals("k")) && Knight.KnightCheck(x1, y1, x2, y2, piece.equals("K"))) {
            Board.board[y2][x2] = Board.board[y1][x1];
            Board.board[y1][x1] = " ";
            MoveMaker.white = !MoveMaker.white;
            return true;
        }
        if ((piece.equals("R") || piece.equals("r")) && Rook.RookCheck(x1, y1, x2, y2, piece.equals("R"))) {
            Board.board[y2][x2] = Board.board[y1][x1];
            Board.board[y1][x1] = " ";
            MoveMaker.white = !MoveMaker.white;
            if (piece.equals("R")) {
                if (y1 == 0) {
                    MoveMaker.whiteARook = true;
                }
                else {
                    MoveMaker.whiteHRook = true;
                }
            }
            else if (y1 == 0) {
                MoveMaker.blackARook = true;
            }
            else {
                MoveMaker.blackHRook = true;
            }
            return true;
        }
        if ((piece.equals("A") || piece.equals("a")) && King.kingCheck(x1, y1, x2, y2, piece.equals("A"))) {
            Board.board[y2][x2] = Board.board[y1][x1];
            Board.board[y1][x1] = " ";
            MoveMaker.white = !MoveMaker.white;
            if (piece.equals("A")) {
                MoveMaker.whiteKing = true;
            }
            else {
                MoveMaker.blacking = true;
            }
            return true;
        }
        if ((piece.equals("B") || piece.equals("b")) && Bishop.bishopCheck(x1, y1, x2, y2, piece.equals("B"))) {
            Board.board[y2][x2] = Board.board[y1][x1];
            Board.board[y1][x1] = " ";
            MoveMaker.white = !MoveMaker.white;
            return true;
        }
        if ((piece.equals("Q") || piece.equals("q")) && (Bishop.bishopCheck(x1, y1, x2, y2, piece.equals("Q")) || Rook.RookCheck(x1, y1, x2, y2, piece.equals("Q")))) {
            Board.board[y2][x2] = Board.board[y1][x1];
            Board.board[y1][x1] = " ";
            MoveMaker.white = !MoveMaker.white;
            return true;
        }
        return false;
    }
}
