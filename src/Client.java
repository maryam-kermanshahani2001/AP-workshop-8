import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

/**
 * The type Client.
 */
public class Client {
    /**
     * Run.
     *
     * @param port the port
     */
    public void run(int port) {
        String msg;
        try {
            Socket socket = new Socket("localhost", port);
            DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
            DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());

            Scanner sc = new Scanner(System.in);
            String message;
            do {
                String str;
                message = sc.nextLine();
                dataOutputStream.writeUTF(message);
                str = dataInputStream.readUTF();
                System.out.println(str);

            } while (!message.equals("over"));

//            while (true) {
//                String str;
//                msg = sc.nextLine();
//                dataOutputStream.writeUTF(msg);
//
//                if (msg.equals("over")) {
//                    str = dataInputStream.readUTF();
//                    System.out.println(str);
//                    break;
//                }
//                else {
//                    str = dataInputStream.readUTF();
//                    System.out.println(str);
//                }
            // }
            dataInputStream.close();
            dataOutputStream.close();
            socket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
