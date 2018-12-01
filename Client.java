package minesweeper;

import java.io.*;
import java.net.*;
import java.net.Socket;
import java.util.Random;
public class Client extends User {
	
	private Socket socket;
	private PrintWriter write;
	private BufferedReader receiveRead;
	private boolean open;
	
	
	
	public Client() {
		//String address, int port
		
		try
        { 
			socket = new Socket("127.0.0.1", 701);
            //socket = new Socket(address, port); 
            System.out.println("Connected"); 
            
            
    		
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
			e.printStackTrace();
		}
		return null;
	}
	public void sendMsg(String sendMessage) {
		write.println(sendMessage);
	}
	public void close() {
		try {
			socket.shutdownOutput(); 
		    socket.close();
		    open=false;
		    System.out.println("c closed");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
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

}
