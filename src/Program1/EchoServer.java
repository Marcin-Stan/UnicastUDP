package Program1;

import java.io.IOException;
import java.net.*;

public class EchoServer{

    private DatagramSocket socket;
    private boolean running;
    private byte[] buf = new byte[1024];

    public EchoServer() throws SocketException {
        socket = new DatagramSocket(4445);
    }

    public void run() throws IOException {
        running = true;

        while (running) {

            DatagramPacket packet
                    = new DatagramPacket(buf, buf.length);
            try {
                socket.receive(packet);
            } catch (IOException exception) {
                exception.printStackTrace();
            }

            InetAddress address = packet.getAddress();
            int port = packet.getPort();
            packet = new DatagramPacket(buf, buf.length, address, port);
            String received
                    = new String(packet.getData(), 0, packet.getLength());

            System.out.println("Wiadomość otrzymana od klienta: "+received);

            socket.send(packet);

            if (received.equals("end")) {
                running = false;
                continue;
            }
            try {
                socket.send(packet);
            } catch (IOException exception) {
                exception.printStackTrace();
            }
        }
        socket.close();
    }
}