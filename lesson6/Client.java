package lesson6;

import javax.swing.*;
import java.awt.*;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Client extends JFrame{
    private Socket socket;
    private JTextArea textArea;
    private JTextField textField;
    private DataOutputStream outputStream;
    private DataInputStream inputStream;


    public Client () {
        initConnection();
        initGui();
        initReceiver();
    }

    private void initReceiver () {
        Thread thread = new Thread(()-> {
            while (true) {
                try {
                    String echoMessage = inputStream.readUTF();
                    textArea.append(echoMessage);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        thread.start();
        System.out.println("receiver initialized");
    }
    private void initConnection () {
        try {
            socket = new Socket("localhost", 8080);
            inputStream = new DataInputStream(socket.getInputStream());
            outputStream = new DataOutputStream(socket.getOutputStream());
            System.out.println("connection initialized");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private void processMessage () {
        if(!textField.getText().equals("")) {
            String message = textField.getText();
            textArea.append(new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(Calendar.getInstance().getTime()) + "\n" + textField.getText() + "\n");
            textField.setText("");
            sendMessage(message);
        }
    }

    private void sendMessage (String message) {
        try {
            outputStream.writeUTF(message);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(message);
    }


    public void initGui (){
        textArea = new JTextArea();
        textField = new JTextField(20);

            setTitle("Client");
            setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            setSize(400, 500);
            setResizable(true);

//        setLayout(new GridLayout(3, 1));

            JMenuBar menuBar = new JMenuBar();
            menuBar.setSize(400, 10);
            JMenu menu1 = new JMenu("Главная");
            JMenu menu2 = new JMenu("Контакты");
            menuBar.add(menu1);
            menuBar.add(menu2);

            JMenuItem menuItem11 = new JMenuItem("Открыть новое окно");
            JMenuItem menuItem12 = new JMenuItem("Сохранить");
            JMenuItem menuItem13 = new JMenuItem("Закрыть");
            menu1.add(menuItem11);
            menu1.add(menuItem12);
            menu1.add(menuItem13);

            JMenuItem menuItem21 = new JMenuItem("Найти новый контакт");
            JMenuItem menuItem22 = new JMenuItem("Удалить контакт");
            JMenuItem menuItem23 = new JMenuItem("Заблокировать контакт");
            menu2.add(menuItem21);
            menu2.add(menuItem22);
            menu2.add(menuItem23);

            getContentPane().add(BorderLayout.NORTH, menuBar);




            JPanel panel1 = new JPanel();
            panel1.setLayout(new GridLayout());

            panel1.add(new JScrollPane(textArea));
            panel1.setBackground(Color.cyan);// почему пропала заливка после добавления скролла?


            getContentPane().add(BorderLayout.CENTER, panel1);


            JPanel panel2 = new JPanel();
            panel2.setBackground(Color.lightGray);
            panel2.setLayout(new FlowLayout());

            getContentPane().add(BorderLayout.SOUTH, panel2);

            JButton button = new JButton("Отправить");
            panel2.add(textField);
            panel2.add(button);

// нажатие Enter
            textField.addActionListener(e -> {
                processMessage();

            });
//         нажатие кнопки


            button.addActionListener(e -> {
                processMessage();
            });


            setVisible(true);
        System.out.println("gui initialized");
    }

    public static void main(String[] args) {
        new Client();
    }
}
