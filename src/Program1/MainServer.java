package Program1;

import java.io.IOException;

public class MainServer {

    public static void main(String[] args) throws IOException, InterruptedException {

        EchoServer echoServer = new EchoServer();
        echoServer.run();

    }
}
