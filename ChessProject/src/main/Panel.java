
package main;

import java.awt.Component;
import javax.swing.JOptionPane;
import Moves.MoveMaker;
import java.awt.event.MouseEvent;
import java.net.URL;
import java.awt.Image;
import java.awt.image.ImageObserver;
import java.awt.Toolkit;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javax.swing.JPanel;

public class Panel extends JPanel implements MouseMotionListener, MouseListener
{
    final int SquareSize = 96;
    Color white;
    Color black;
    public static int mouseX1;
    public static int mouseY1;
    public static int mouseX2;
    public static int mouseY2;
    public static boolean whiteKing;
    public static boolean blackKing;
    public static boolean moveHappen;
    
    static {
        Panel.whiteKing = true;
        Panel.blackKing = true;
        Panel.moveHappen = false;
    }
    
    public Panel() {
        this.white = new Color(255, 200, 100);
        this.black = new Color(150, 50, 30);
        this.addMouseListener(this);
    }
    
    public void paintComponent(final Graphics g) {
        super.paintComponent(g);
        for (int i = 0; i < 64; i += 2) {
            g.setColor(this.white);
            g.fillRect((i % 8 + i / 8 % 2) * 96, i / 8 * 96, 96, 96);
            g.setColor(this.black);
            g.fillRect(((i + 1) % 8 - (i + 1) / 8 % 2) * 96, (i + 1) / 8 * 96, 96, 96);
        }
        Image Piece = null;
        for (int j = 0; j < 64; ++j) {
            Label_0646: {
                final String s;
                switch (s = Board.board[j / 8][j % 8]) {
                    case "A": {
                        final URL url = this.getClass().getResource("/whiteKing.png");
                        Piece = Toolkit.getDefaultToolkit().getImage(url);
                        break Label_0646;
                    }
                    case "B": {
                        final URL url = this.getClass().getResource("/whiteBishop.png");
                        Piece = Toolkit.getDefaultToolkit().getImage(url);
                        break Label_0646;
                    }
                    case "K": {
                        final URL url = this.getClass().getResource("/whiteKnight.png");
                        Piece = Toolkit.getDefaultToolkit().getImage(url);
                        break Label_0646;
                    }
                    case "P": {
                        final URL url = this.getClass().getResource("/whitePawn.png");
                        Piece = Toolkit.getDefaultToolkit().getImage(url);
                        break Label_0646;
                    }
                    case "Q": {
                        final URL url = this.getClass().getResource("/whiteQueen.png");
                        Piece = Toolkit.getDefaultToolkit().getImage(url);
                        break Label_0646;
                    }
                    case "R": {
                        final URL url = this.getClass().getResource("/whiteRook.png");
                        Piece = Toolkit.getDefaultToolkit().getImage(url);
                        break Label_0646;
                    }
                    case "a": {
                        final URL url = this.getClass().getResource("/blackKing.png");
                        Piece = Toolkit.getDefaultToolkit().getImage(url);
                        break Label_0646;
                    }
                    case "b": {
                        final URL url = this.getClass().getResource("/blackBishop.png");
                        Piece = Toolkit.getDefaultToolkit().getImage(url);
                        break Label_0646;
                    }
                    case "k": {
                        final URL url = this.getClass().getResource("/blackKnight.png");
                        Piece = Toolkit.getDefaultToolkit().getImage(url);
                        break Label_0646;
                    }
                    case "p": {
                        final URL url = this.getClass().getResource("/blackPawn.png");
                        Piece = Toolkit.getDefaultToolkit().getImage(url);
                        break Label_0646;
                    }
                    case "q": {
                        final URL url = this.getClass().getResource("/blackQueen.png");
                        Piece = Toolkit.getDefaultToolkit().getImage(url);
                        break Label_0646;
                    }
                    case "r": {
                        final URL url = this.getClass().getResource("/blackRook.png");
                        Piece = Toolkit.getDefaultToolkit().getImage(url);
                        break Label_0646;
                    }
                    default:
                        break;
                }
                Piece = null;
            }
            g.drawImage(Piece, j % 8 * 96, j / 8 * 96, (j % 8 + 1) * 96, (j / 8 + 1) * 96, 0, 0, 60, 60, this);
        }
    }
    
    @Override
    public void mouseDragged(final MouseEvent e) {
    }
    
    @Override
    public void mouseMoved(final MouseEvent e) {
    }
    
    @Override
    public void mouseClicked(final MouseEvent e) {
    }
    
    @Override
    public void mousePressed(final MouseEvent e) {
        if (e.getX() < 768 && e.getY() < 768) {
            Panel.mouseX1 = e.getX() / 96;
            Panel.mouseY1 = e.getY() / 96;
        }
    }
    
    @Override
    public void mouseReleased(final MouseEvent e) {
        if (e.getX() < 768 && e.getY() < 768) {
            Panel.mouseX2 = e.getX() / 96;
            Panel.mouseY2 = e.getY() / 96;
            if (MoveMaker.makeMove(Panel.mouseX1, Panel.mouseY1, Panel.mouseX2, Panel.mouseY2)) {
                Panel.moveHappen = true;
                this.repaint();
                this.kingCheck();
            }
            Panel.moveHappen = false;
        }
    }
    
    private void kingCheck() {
        Panel.whiteKing = false;
        Panel.blackKing = false;
        for (int i = 0; i < 8; ++i) {
            for (int j = 0; j < 8; ++j) {
                if (Board.board[i][j].equals("A")) {
                    Panel.whiteKing = true;
                }
                if (Board.board[i][j].equals("a")) {
                    Panel.blackKing = true;
                }
            }
        }
        if (!Panel.whiteKing) {
            JOptionPane.showMessageDialog(this.getComponentPopupMenu(), "Black won");
        }
        if (!Panel.blackKing) {
            JOptionPane.showMessageDialog(this.getComponentPopupMenu(), "White won");
        }
    }
    
    @Override
    public void mouseEntered(final MouseEvent e) {
    }
    
    @Override
    public void mouseExited(final MouseEvent e) {
    }
}
