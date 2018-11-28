import java.io.*;
import java.net.*;
import java.io.BufferedReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
//import java.net.Socket;*;
public class Server {
	
	public static void main(String[] args) throws Exception {
		ServerSocket serverSocket = new ServerSocket(6789);
		System.out.println("This is server.");
		Socket socket = serverSocket.accept();
		
		BufferedReader keyRead = new BufferedReader(new InputStreamReader(System.in));
		
		OutputStream outStream = socket.getOutputStream();
		DataOutputStream dataOutStream = new DataOutputStream(outStream);
		PrintWriter write = new PrintWriter(outStream, true);
		
		InputStream inStream = socket.getInputStream();
		BufferedReader receiveRead = new BufferedReader(new InputStreamReader(inStream));
		
		dataOutStream.writeUTF("Hello!");
		
		String receiveMessage, sendMessage;
		while(true) {
			if((receiveMessage = receiveRead.readLine()) != null) {
				System.out.println(receiveMessage);
			}
			sendMessage = keyRead.readLine();
			write.println(sendMessage);
			write.flush();
		}
		//receiveRead.close();
		//socket.close();
		//serverSocket.close();
	}

}
