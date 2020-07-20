import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    private ServerSocket serverSocket;
    private Socket clientSocket;

    private DataInputStream dataInputStream;
    private DataOutputStream dataOutputStream;

    public void serverSetting() {
        try {
            serverSocket = new ServerSocket(10002);

            clientSocket = serverSocket.accept();
            System.out.println("클라이언트 소켓 연결");
            Thread.sleep(5000);

            dataInputStream = new DataInputStream(clientSocket.getInputStream());
            dataOutputStream = new DataOutputStream(clientSocket.getOutputStream());

            String recvData = dataInputStream.readUTF();
            System.out.println("recvData = " + recvData);
            dataOutputStream.writeUTF("잘 받았어요^^");
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    public Server() {
        serverSetting();
    }

    public static void main(String[] args) {
        new Server();
    }
}
