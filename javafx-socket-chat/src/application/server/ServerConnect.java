package application.server;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class ServerConnect {

    Socket socket;

    public ServerConnect(Socket socket) {
        this.socket = socket;
        receive();
    }

    public void receive() {
        Runnable thread = () -> {
            try {
                while (true) {
                    InputStream in = socket.getInputStream();
                    byte[] buffer = new byte[512];

                    int length = in.read(buffer);
                    while(length == -1) throw new IOException();

                    System.out.println("[메시지 수신 성공]" + socket.getRemoteSocketAddress()+ " : "  + Thread.currentThread().getName());

                    String message = new String(buffer, 0, length, StandardCharsets.UTF_8);

                    for(ServerConnect client : Server.serverConnects) {
                        client.send(message);
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        };
        Server.threadPool.submit(thread);
    }

    public void send(String message) {
        Runnable thread = () -> {
            try {
                OutputStream out = socket.getOutputStream();
                byte[] buffer = message.getBytes(StandardCharsets.UTF_8);
                out.write(buffer);
                out.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        };
        Server.threadPool.submit(thread);
    }
}