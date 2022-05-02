
package main;

import javax.swing.JOptionPane;

public class ClientApp
{
    public static void main(final String[] args) {
        final String IP = JOptionPane.showInputDialog("Enter the ip of the server host");
        final Client client = new Client(IP);
        client.setDefaultCloseOperation(3);
        client.startRunning();
    }
}
