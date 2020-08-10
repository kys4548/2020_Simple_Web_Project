package application.server;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Server extends Application {

    public static ExecutorService threadPool;
    public static List<ServerConnect> serverConnects = new ArrayList<>();

    ServerSocket serverSocket;

    public void startServer(String IP, int port) {
        try {
            serverSocket = new ServerSocket();
            serverSocket.bind(new InetSocketAddress(IP, port));
        } catch (IOException e) {
            e.getStackTrace();
            if(!serverSocket.isClosed()) {
                stopServer();
            }
            return;
        }
        Runnable thread = () -> {
            while(true) {
                try {
                    Socket socket = serverSocket.accept();
                    serverConnects.add(new ServerConnect(socket));
                    System.out.println("[클라이언트 접속]" + socket.getRemoteSocketAddress()+" : " + Thread.currentThread().getName());
                } catch (IOException e) {
                    if(!serverSocket.isClosed()) {
                        stopServer();
                    }
                    break;
                }
            }
        };

        threadPool = Executors.newCachedThreadPool();
        threadPool.submit(thread);
    }

    public void stopServer() {
        try {
            Iterator<ServerConnect> iterator = serverConnects.iterator();

            while (iterator.hasNext()) {
                ServerConnect serverConnect = iterator.next();
                serverConnect.socket.close();
                iterator.remove();
            }
            if(serverSocket != null && !serverSocket.isClosed()) {
                serverSocket.close();
            }
            if(threadPool != null & !threadPool.isShutdown()) {
                threadPool.shutdown();
                threadPool.awaitTermination(100, TimeUnit.SECONDS);
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void start(Stage primaryStage) throws Exception{

        BorderPane root = new BorderPane();

        root.setPadding(new Insets(5));

        TextArea textArea = new TextArea();
        textArea.setEditable(false);
        textArea.setFont(new Font("나눔고딕", 15));
        root.setCenter(textArea);

        Button button = new Button("시작하기");
        button.setMaxWidth(Double.MAX_VALUE);
        BorderPane.setMargin(button, new Insets(1, 0, 0, 0));
        root.setBottom(button);

        String IP = "127.0.0.1";
        int port = 9876;

        button.setOnAction(event -> {
            if(button.getText().equals("시작하기")) {
                startServer(IP,port);

                Platform.runLater(() -> {
                    String message =  String.format("[서버 시작]\n", IP, port);
                    textArea.appendText(message);
                    button.setText("종료하기");
                });
            } else {
                stopServer();
                Platform.runLater(() -> {
                    String messgae = String.format("[서버 종료]\n",IP, port);
                    textArea.appendText(messgae);
                    button.setText("시작하기");
                });
            }
        });

        Scene scene = new Scene(root, 500, 500);
        primaryStage.setTitle("[채팅 서버]");
        primaryStage.setOnCloseRequest(event -> stopServer());
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
