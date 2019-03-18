package lesson6;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ChatServer {
    public static void main(String[] args) throws IOException {
        try (ServerSocket ss = new ServerSocket(8080)) {
            System.out.println("Server started");
            Socket socket = ss.accept();
            System.out.println("client connected " + socket);
            try (DataInputStream is = new DataInputStream(socket.getInputStream());
                 DataOutputStream os = new DataOutputStream(socket.getOutputStream())) {
                while (true) {
                    String message = is.readUTF();
                    System.out.println("received message: " + message);
                    Scanner scanner = new Scanner(System.in);
                    String messageToClient = scanner.nextLine();
                    os.writeUTF("From server: " + messageToClient);

                }
            }
        }
    }
        public static void sendToClient (Socket socket) {
            try {
                Scanner scanner = new Scanner(socket.getInputStream());
                PrintWriter printWriter = new PrintWriter(socket.getOutputStream(), true);
                String messageToClient = scanner.nextLine();


            } catch (IOException e) {
                e.printStackTrace();
            }

        }
}
