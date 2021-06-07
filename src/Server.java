import java.io.DataInput;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * The type Server.
 */
public class Server {
    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        Server server = new Server();
        server.run();
    }

    /**
     * Run.
     */
    public static void run() {
        String response = "";
        try {
            ServerSocket serverSocket = new ServerSocket(4041);
            Socket socket = serverSocket.accept();
            System.out.println("this is from server");
            DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
            DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());

            String str;
            do {
                str = dataInputStream.readUTF();
                System.out.println(str);
                response += str + " || ";
                dataOutputStream.writeUTF(response);
            }while (!str.equals("over"));

//
//            while (true) {
//                String str = dataInputStream.readUTF();
//                System.out.println(str);
//                if (str.equals("over")) {
//                    dataOutputStream.writeUTF(response);
//                    break;
//                }
//                else {
//                    response += str + " || ";
//                    dataOutputStream.writeUTF(response);
//                }
//            }
//

            dataOutputStream.close();
            dataInputStream.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
