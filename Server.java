package minesweeper;

import java.io.*;
import java.net.*;
//import java.net.Socket;*;
public class Server extends User {
	
	private Socket socket;
	private PrintWriter write;
	private BufferedReader receiveRead;
	
	public Server() {
		//String address, int port
		
		try
        { 
			ServerSocket serverSocket = new ServerSocket(700);
			System.out.println("This is server.");
			socket = serverSocket.accept();
            //socket = new Socket(address, port); 
            
            
            
    		
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
		//System.out.println(sendMessage);
		write.println(sendMessage);
	}
	public void close() {
		try {
			socket.close();
			receiveRead.close();
			write.close();
		    
		    
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	
//	public static void main(String[] args) throws Exception {
//		ServerSocket serverSocket = new ServerSocket(6781);
//		System.out.println("This is server.");
//		Socket socket = serverSocket.accept();
//		
//		BufferedReader keyRead = new BufferedReader(new InputStreamReader(System.in));
//		
//		OutputStream outStream = socket.getOutputStream();
//		DataOutputStream dataOutStream = new DataOutputStream(outStream);
//		PrintWriter write = new PrintWriter(outStream, true);
//		
//		InputStream inStream = socket.getInputStream();
//		BufferedReader receiveRead = new BufferedReader(new InputStreamReader(inStream));
//		
//		dataOutStream.writeUTF("Hello!");
//		
//		String receiveMessage, sendMessage;
//		while(true) {
//			if((receiveMessage = receiveRead.readLine()) != null) {
//				System.out.println(receiveMessage);
//			}
//			sendMessage = keyRead.readLine();
//			write.println(sendMessage);
//			write.flush();
//		}
//		//receiveRead.close();
//		//socket.close();
//		//serverSocket.close();
//	}

}
