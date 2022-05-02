
package main;

public class ServerApp
{
    public static void main(final String[] args) {
        final Server server = new Server();
        server.setDefaultCloseOperation(3);
        server.startRunning();
    }
}
