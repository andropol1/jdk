package swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;

public class ChatWindow extends JFrame {
    private static final int WINDOW_HEIGHT = 555;
    private static final int WINDOW_WIDTH = 507;
    private static final int WINDOW_POSX = 500;
    private static final int WINDOW_POSY = 100;

    JPanel panelLogin = new JPanel(new GridLayout(1,2));
    JLabel jLabelLogin = new JLabel("Введите логин: ");
    JTextField jFieldLogin = new JTextField();
    JPanel panelPassword = new JPanel(new GridLayout(1,2));
    JLabel jLabelPassword = new JLabel("Введите пароль: ");
    JTextField jFieldPassword = new JTextField();
    JPanel panelIp = new JPanel(new GridLayout(1, 2));
    JLabel jLabelIp = new JLabel("Введите IP адрес сервера: ");
    JTextField jFieldIp = new JTextField();
    JPanel panelPort = new JPanel(new GridLayout(1, 2));
    JLabel jLabelPort = new JLabel("Введите номер порта: ");
    JTextField jFieldPort = new JTextField();
    JButton btnLogin = new JButton("Подключиться");
    static JTextArea textChatTextArea = new JTextArea();
    JScrollPane scrollPane = new JScrollPane(textChatTextArea);
    JLabel jLabelMessage = new JLabel("Введите ваше сообщение: ");
    JTextField jTextFieldMessage = new JTextField();
    JButton btnPushMsg = new JButton("Отправить сообщение");
    private String message;
    private static String chatContent;
    public ChatWindow() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocation(WINDOW_POSX, WINDOW_POSY);
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        setTitle("GB_chat");
        setVisible(true);
        setLayout(new GridLayout(9, 1));

        WindowListener winListener = new WinListener();
        addWindowListener(winListener);

        add(panelLogin);
        add(panelPassword);
        add(panelIp);
        add(panelPort);
        add(btnLogin);
        add(scrollPane);
        add(jLabelMessage);
        add(jTextFieldMessage);
        add(btnPushMsg);

        panelLogin.add(jLabelLogin);
        panelLogin.add(jFieldLogin);
        panelPassword.add(jLabelPassword);
        panelPassword.add(jFieldPassword);
        panelIp.add(jLabelIp);
        panelIp.add(jFieldIp);
        panelPort.add(jLabelPort);
        panelPort.add(jFieldPort);

        textChatTextArea.setEditable(false);
        /**
         * Отправка сообщения по нажатию кнопки
         */
        btnPushMsg.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                message = jFieldLogin.getText() + ": " + jTextFieldMessage.getText();
                textChatTextArea.append("\n" + message);
                chatContent = textChatTextArea.getText();
                System.out.println("Отправлено сообщение: " + jTextFieldMessage.getText());
                jTextFieldMessage.setText("");
            }
        });
        /**
         * Отправка сообщения по клавише Enter
         */
        jTextFieldMessage.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                message = jFieldLogin.getText() + ": " + jTextFieldMessage.getText();
                textChatTextArea.append(message + "\n");
                chatContent = textChatTextArea.getText();
                System.out.println("Отправлено сообщение: " + jTextFieldMessage.getText());
                jTextFieldMessage.setText("");
            }
        });
        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try(FileInputStream fr = new FileInputStream("src/swing/chat_content.txt")) {
                    int b;
                    while ((b = fr.read()) != -1) {
                        textChatTextArea.append(Character.valueOf((char) b).toString());
                    }
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
    }
    public static class WinListener implements WindowListener {

        public void windowActivated(WindowEvent e) {  }

        public void windowClosed(WindowEvent e) {  }

        public void windowClosing(WindowEvent e) {
            try {
                writeChatToFile(chatContent, "src/swing/chat_content.txt");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }

        public void windowDeactivated(WindowEvent e) { }

        public void windowDeiconified(WindowEvent e) { }

        public void windowIconified(WindowEvent e) { }

        public void windowOpened(WindowEvent e) { }
    }
    public static void writeChatToFile(String messages, String fileName) throws IOException {
        if (messages != null ) {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true))) {
                writer.write(messages);
                writer.flush();
            }
        }

    }
}
