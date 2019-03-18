package lesson6;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Calendar;
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

                    while (true) {
                        Scanner scanner = new Scanner(System.in);
                        String messageToClient = scanner.nextLine();
                        if (!messageToClient.equals("")) {
                            os.writeUTF("From server: " + new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(Calendar.getInstance().getTime()) + "\n" + messageToClient + "\n");
                        }
                    }

                }
            }
        }
    }
}
