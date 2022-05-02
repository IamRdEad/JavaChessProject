
package Moves;

import main.Board;

public class Rook
{
    public static boolean RookCheck(final int i1, final int j1, final int i2, final int j2, final boolean w) {
        if (w && Character.isUpperCase(Board.board[j2][i2].charAt(0))) {
            return false;
        }
        if (!w && Character.isLowerCase(Board.board[j2][i2].charAt(0))) {
            return false;
        }
        if ((i1 != i2 || j1 == j2) && (i1 == i2 || j1 != j2)) {
            return false;
        }
        if (i1 == i2) {
            for (int k = -1; k <= 1; k += 2) {
                int temp = 1;
                try {
                    while (temp < 7) {
                        if (w && Character.isUpperCase(Board.board[j1 + temp * k][i1].charAt(0))) {
                            break;
                        }
                        if (w && Character.isLowerCase(Board.board[j1 + temp * k][i1].charAt(0))) {
                            if (j1 + temp * k == j2 && i1 == i2) {
                                return true;
                            }
                            break;
                        }
                        else {
                            if (!w && Character.isLowerCase(Board.board[j1 + temp * k][i1].charAt(0))) {
                                break;
                            }
                            if (!w && Character.isUpperCase(Board.board[j1 + temp * k][i1].charAt(0))) {
                                if (j1 + temp * k == j2 && i1 == i2) {
                                    return true;
                                }
                                break;
                            }
                            else {
                                if (j1 + k * temp == j2) {
                                    return true;
                                }
                                ++temp;
                            }
                        }
                    }
                }
                catch (Exception ex) {}
            }
        }
        else {
            for (int k = -1; k <= 1; k += 2) {
                int temp = 1;
                try {
                    while (temp < 7) {
                        if (w && Character.isUpperCase(Board.board[j1][i1 + temp * k].charAt(0))) {
                            break;
                        }
                        if (w && Character.isLowerCase(Board.board[j1][i1 + temp * k].charAt(0))) {
                            if (i1 + temp * k == i2 && j1 == j2) {
                                return true;
                            }
                            break;
                        }
                        else {
                            if (!w && Character.isLowerCase(Board.board[j1][i1 + temp * k].charAt(0))) {
                                break;
                            }
                            if (!w && Character.isUpperCase(Board.board[j1][i1 + temp * k].charAt(0))) {
                                if (i1 + temp * k == i2 && j1 == j2) {
                                    return true;
                                }
                                break;
                            }
                            else {
                                if (i1 + k * temp == i2) {
                                    return true;
                                }
                                ++temp;
                            }
                        }
                    }
                }
                catch (Exception ex2) {}
            }
        }
        return false;
    }
}
