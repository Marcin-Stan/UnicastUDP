package Program1;

import java.io.IOException;
import java.net.SocketException;
import java.net.UnknownHostException;

public class MainClient {

    public static void main(String[] args) throws IOException {

        EchoClient echoClient = new EchoClient();
        echoClient.sendEcho("Testowa wiadomość");

    }
}
