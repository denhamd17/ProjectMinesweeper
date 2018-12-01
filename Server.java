package minesweeper;

import java.io.*;
import java.net.*;
//import java.net.Socket;*;
public class Server extends User {
	
	private Socket socket;
	private PrintWriter write;
	private BufferedReader receiveRead;
	public boolean open;
	
	protected void finalize(){
		//Objects created in run method are finalized when
		//program terminates and thread exits
		     try{
		        socket.close();
		    } catch (IOException e) {
		        System.out.println("Could not close socket");
		        System.exit(-1);
		    }
		  }
	
	public Server() {
		//String address, int port
		
		try
        { 
			ServerSocket serverSocket = new ServerSocket(701);
			System.out.println("This is server.");
			socket = serverSocket.accept();
            //socket = new Socket(address, port); 
            
            
            
    		
    		OutputStream outStream = socket.getOutputStream();
    		write = new PrintWriter(outStream, true);
    		
    		InputStream inStream = socket.getInputStream();
    		
    		receiveRead = new BufferedReader(new InputStreamReader(inStream));
    		
    		open=true;
    		
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
		if(!open) close();
		try {
			return (receiveRead.readLine());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}
		return null;
	}
	public void sendMsg(String sendMessage) {
		//System.out.println(sendMessage);
		write.println(sendMessage);
	}
	public void close() {
		try {
			socket.shutdownOutput(); 
			socket.close();
			open=false;
			System.out.println("s closed");
		    
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	


}
