package Program1;

import java.io.IOException;
import java.net.*;

public class EchoClient {
    private DatagramSocket socket;
    private InetAddress address;

    private byte[] buf;

    public EchoClient() throws SocketException, UnknownHostException {
        socket = new DatagramSocket();
        address = InetAddress.getByName("localhost");
    }

    public String sendEcho(String msg) throws IOException {
            buf = msg.getBytes();
            DatagramPacket packet
                    = new DatagramPacket(buf, buf.length, address, 4445);
            socket.send(packet);

            socket.receive(packet);
        String received = new String(
                packet.getData(), 0, packet.getLength());
        System.out.println("Wiadomosc otrzymana od servera:" + received);
        close();
        return received;


    }

    public void close() {
        socket.close();
    }
}