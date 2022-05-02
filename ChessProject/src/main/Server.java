
package main;

import Moves.MoveMaker;
import java.io.IOException;
import java.io.EOFException;
import javax.swing.JOptionPane;
import java.awt.Component;
import java.net.Socket;
import java.net.ServerSocket;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import javax.swing.JFrame;

public class Server extends JFrame
{
    private DataOutputStream output;
    private DataInputStream input;
    private ServerSocket server;
    private Socket connection;
    private Panel p;
    
    public Server() {
        super("Drunked Chess Server");
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.p = new Panel();
        this.setSize(784, 807);
        this.add(this.p);
        this.setVisible(true);
    }
    
    public void startRunning() {
        try {
            this.server = new ServerSocket(6789, 100);
            while (true) {
                try {
                    this.waitForConnection();
                    this.setupStreams();
                    this.whilePlaying();
                }
                catch (EOFException eof) {
                    JOptionPane.showMessageDialog(null, "\n server ended the connection");
                    this.close();
                    continue;
                }
                finally {
                    this.close();
                }
                this.close();
            }
        }
        catch (IOException ioEx) {
            ioEx.printStackTrace();
        }
    }
    
    private void waitForConnection() throws IOException {
        this.connection = this.server.accept();
    }
    
    private void setupStreams() throws IOException {
        (this.output = new DataOutputStream(this.connection.getOutputStream())).flush();
        this.input = new DataInputStream(this.connection.getInputStream());
    }
    
    private void whilePlaying() throws IOException {
        do {
            if (Panel.moveHappen) {
                this.sendMove(Panel.mouseX1, Panel.mouseY1, Panel.mouseX2, Panel.mouseY2);
            }
            if (this.input.available() > 3) {
                try {
                    this.getMove();
                }
                catch (IOException iee) {
                    System.out.println("Error");
                }
            }
        } while (Panel.blackKing && Panel.whiteKing);
    }
    
    private void sendMove(final int mouseX1, final int mouseY1, final int mouseX2, final int mouseY2) {
        try {
            this.output.writeInt(mouseX1);
            this.output.writeInt(mouseY1);
            this.output.writeInt(mouseX2);
            this.output.writeInt(mouseY2);
            this.output.flush();
        }
        catch (IOException ioE) {
            System.out.println("Cant send the move");
        }
    }
    
    private void getMove() throws IOException {
        final int mouseX1 = this.input.readInt();
        final int mouseY1 = this.input.readInt();
        final int mouseX2 = this.input.readInt();
        final int mouseY2 = this.input.readInt();
        final String temp = Board.board[mouseY1][mouseX1];
        Board.board[mouseY1][mouseX1] = " ";
        Board.board[mouseY2][mouseX2] = temp;
        MoveMaker.white = !MoveMaker.white;
        this.p.repaint();
    }
    
    private void close() {
        try {
            this.output.close();
            this.input.close();
            this.connection.close();
        }
        catch (IOException ioE) {
            ioE.printStackTrace();
        }
    }
}
