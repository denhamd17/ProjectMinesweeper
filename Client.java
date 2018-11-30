package minesweeper;

import java.io.*;
import java.net.*;
import java.net.Socket;
import java.util.Random;
public class Client extends User {
	
	private Socket socket;
	private PrintWriter write;
	private BufferedReader receiveRead;
	
	public Client() {
		//String address, int port
		
		try
        { 
			socket = new Socket("127.0.0.1", 700);
            //socket = new Socket(address, port); 
            System.out.println("Connected"); 
            
            
    		
    		OutputStream outStream = socket.getOutputStream();
    		write = new PrintWriter(outStream, true);
  
    		InputStream inStream = socket.getInputStream();
    		
    		
    		receiveRead = new BufferedReader(new InputStreamReader(inStream));
    		
    		
        } 
        catch(UnknownHostException u) 
        { 
            System.out.println(u); 
        } 
        catch(IOException i) 
        { 
            System.out.println(i); 
        } 
		
	}
	
	public String recieveMsg() {
		try {
			return (receiveRead.readLine());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	public void sendMsg(String sendMessage) {
		write.println(sendMessage);
	}
	public void close() {
		try {
			receiveRead.close();
			write.close();
		    socket.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
//	public static void main(String[] args) throws Exception {
//		
//		
//		BufferedReader keyRead = new BufferedReader(new InputStreamReader(System.in));
//		
//		OutputStream outStream = socket.getOutputStream();
//		PrintWriter write = new PrintWriter(outStream, true);
//		
//		InputStream inStream = socket.getInputStream();
//		DataInputStream dataInputStream = new DataInputStream(inStream);
//		String sentence = new String (dataInputStream.readUTF());
//		BufferedReader receiveRead = new BufferedReader(new InputStreamReader(inStream));
//		
//		System.out.println("Start chatting, and press Enter");
//		
//		String receiveMessage, sendMessage;
//		while(true) {
//			sendMessage = keyRead.readLine();
//			write.println(sendMessage);
//			if((receiveMessage = receiveRead.readLine()) != null) {
//				System.out.println(receiveMessage);
//			}
//		}
//		//receiveRead.close();
//		//inStream.close();
//		//socket.close();
//	}

}
