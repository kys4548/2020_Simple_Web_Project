import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

public class Client {
    private Socket socket;

    public void connect() {
        try {
            socket = new Socket("172.30.1.20", 10002);


        final DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
        final DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());

        dataOutputStream.writeUTF("클라이언트 요청이 왔습니다.");
        System.out.println(dataInputStream.readUTF());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Client() {
        connect();
    }

    public static void main(String[] args) {
        new Client();
    }
}
