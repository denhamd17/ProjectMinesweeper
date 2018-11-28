import java.io.*;
import java.net.*;
import java.io.BufferedReader;
import java.io.PrintWriter;
import java.net.Socket;
public class Client {
	
	public static void main(String[] args) throws Exception {
		Socket socket = new Socket("172.217.197.26", 6789);
		
		BufferedReader keyRead = new BufferedReader(new InputStreamReader(System.in));
		
		OutputStream outStream = socket.getOutputStream();
		PrintWriter write = new PrintWriter(outStream, true);
		
		InputStream inStream = socket.getInputStream();
		DataInputStream dataInputStream = new DataInputStream(inStream);
		String sentence = new String (dataInputStream.readUTF());
		BufferedReader receiveRead = new BufferedReader(new InputStreamReader(inStream));
		
		System.out.println("Start chatting, and press Enter");
		
		String receiveMessage, sendMessage;
		while(true) {
			sendMessage = keyRead.readLine();
			write.println(sendMessage);
			if((receiveMessage = receiveRead.readLine()) != null) {
				System.out.println(receiveMessage);
			}
		}
		//receiveRead.close();
		//inStream.close();
		//socket.close();
	}

}
